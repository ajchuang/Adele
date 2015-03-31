import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.*;

public class TransPhase extends adeleBaseListener {
    
    ParseTreeProperty<Scope>    scopes;
    ParseTreeProperty<Object>   values;
    ParseTreeProperty<String>  m_codes;
    GlobalScope globals;
    STGroupFile stg;
    String tmp;
    Scope currentScope; // resolve symbols starting in this scope

    /* expression fragments */
    Stack<Stack<String>> m_frags;
    Stack<Stack<String>> m_stmts;
    
    /* helper function */
    static void printStack (Stack<String> s) {
        for (int i=0; i<s.size(); ++i)
            System.err.println ("  " + s.get (i));
    }

    public TransPhase (
        GlobalScope globals,
        ParseTreeProperty<Scope> scopes,
        ParseTreeProperty<Object> values,
        ParseTreeProperty<String> codes
        ) {
        
        this.scopes     = scopes;
        this.globals    = globals;
        this.values     = values;
        this.m_codes    = codes;
        
        stg = new STGroupFile("../src/template/group.stg");
        tmp = "";
        
        m_frags = new Stack<Stack<String>> ();
        m_stmts = new Stack<Stack<String>> ();
    }
    
    /* set the code of a certain node */
    public void setCode (ParseTree node, String code) {
        m_codes.put (node, code);
    }
    
    /* get the code of a certain node */
    public String getCode (ParseTree node) {
        return m_codes.get (node);
    }

    public int getValue (ParseTree node) {
        return (int)values.get(node);
    }

    public void enterProg(adeleParser.ProgContext ctx) {
        currentScope = globals;
        ST befprog = stg.getInstanceOf ("befprog");
        System.out.print (befprog.render());
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        ST aftprog = stg.getInstanceOf ("aftprog");
        System.out.print (aftprog.render());
        System.out.println ();
    }

    public void enterFunc(adeleParser.FuncContext ctx) {
        currentScope = scopes.get (ctx);

        System.out.print (tmp);
        tmp = "";
    }

    public void exitFunc (adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope();

        ST func = stg.getInstanceOf("funcdef");
        func.add("fname", ctx.ID());
        func.add("body", tmp);
        System.out.print(func.render());
        System.out.println();
        tmp = "";
    }
    
    /**************************************************************************/
    /* stmts                                                                  */
    /**************************************************************************/
    public void exitStm_expr (adeleParser.Stm_exprContext ctx) {
        System.err.println ("exitStm_expr");
        
        String c = getCode (ctx.getChild (0));
        System.err.println ("Stm_expr: " + c);
        System.out.println (c + ";");
    }

    /**************************************************************************/
    /* exprs                                                                  */
    /**************************************************************************/
    public void enterAssign (adeleParser.AssignContext ctx) {
        Stack<String> cexp = new Stack<String> ();
        m_frags.push (cexp);
    }
    
    public void exitAssign (adeleParser.AssignContext ctx) {
        
        System.err.println ("exitAssign: " + getValue(ctx.expr()));
        
        Stack<String> s = m_frags.pop ();
        printStack (s); 
        
        ST assign = stg.getInstanceOf ("assign");
        assign.add("lhs", ctx.ID ());
        assign.add("rhs", getValue (ctx.expr ()));
        tmp += assign.render() + '\n';
    }

    public void exitVarDecl(adeleParser.VarDeclContext ctx) {
        ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", ctx.ID());
        tmp += decl.render() + '\n';
    }

    public void exitVarDeclAssign(adeleParser.VarDeclAssignContext ctx) {
        ST decl = stg.getInstanceOf ("vardecl");
        decl.add ("vname", ctx.ID ());
        
        if (ctx.expr () != null) {
            decl.add ("value", getValue(ctx.expr()));
        }
        
        tmp += decl.render() + '\n';
    }

    public void enterFuncCall (adeleParser.FuncCallContext ctx) {
        System.err.println ("Enter funcall: " + ctx.ID().getText());
        m_frags.push (new Stack<String> ());
    }

    public void exitFuncCall (adeleParser.FuncCallContext ctx) {
        // ST funccall = stg.getInstanceOf("funccall");
        // funccall.add("fname", ctx.ID().getText());
        // funccall.add("params", "");
        // tmp += funccall.render() + '\n';
        //tmp += ctx.getText();
        
        System.err.println ("Exit funcall: " + ctx.ID().getText());

        ST funccall = stg.getInstanceOf ("funccall");
        funccall.add ("fname", ctx.ID ().getText ());
        
        String p = new String ();
        
        int nChild = ctx.getChildCount ();
        
        for (int i=0; i<nChild; ++i) {
            ParseTree node = ctx.getChild (i);
            
            if (node instanceof adeleParser.FpisContext) {
                funccall.add ("params", getCode (node));
                break;
            }
        }

        tmp += funccall.render () + "\n";
        setCode (ctx, funccall.render ());
    }
    
    public void exitFpis (adeleParser.FpisContext ctx) {
        
        int nChild = ctx.getChildCount ();
        String ans = new String ();
        
        for (int i=0; i<nChild - 1; ++i) {
            ParseTree node = ctx.getChild (i);
            
            if (node instanceof adeleParser.FpitemContext) {
                ans += getCode (node) + ",";
            }
        }
        
        ans += getCode (ctx.getChild (nChild-1));
        System.err.println ("Fpis: " + ":" + ans);
        setCode (ctx, ans);
    }
    
    public void exitFpitem (adeleParser.FpitemContext ctx) {
        
        int cnt = ctx.getChildCount ();
        
        for (int i=0; i<cnt; ++i) {
            ParseTree node = ctx.getChild (i);
            setCode (ctx, getCode (node));
            System.err.println ("Fpitem: " + node + ":" + getCode (node));
        }
        
        
    }
    
    public void exitAdd (adeleParser.AddContext ctx) {
        
        System.err.println ("Exit Add: " + ctx.expr (0).getText () + ":" + ctx.expr (1).getText ());
        
        /* output a: this is the last expression */
        ST add = stg.getInstanceOf ("add");
        add.add ("lhs", getCode (ctx.expr (0)));
        add.add ("rhs", getCode (ctx.expr (1)));
        
        /* set the code to the node */
        setCode (ctx, add.render ());
    }

    public void exitNum (adeleParser.NumContext ctx) {
        System.err.println ("Exit Num: " + ctx.NUM ());
        setCode (ctx, ctx.NUM ().getText ());
    }

    public void exitString (adeleParser.StringContext ctx) {
        System.err.println ("Exit String: " + ctx.STR ());
        setCode (ctx, ctx.STR ().getText ());
    }
    
    public void exitVar (adeleParser.VarContext ctx) {
        System.err.println ("Exit String: " + ctx.ID ());
        setCode (ctx, ctx.ID ().getText ());
    }
}
