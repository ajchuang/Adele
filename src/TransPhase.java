import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.*;

public class TransPhase extends adeleBaseListener {
    ParseTreeProperty<Scope> scopes;
    ParseTreeProperty<Object> values;
    GlobalScope globals;
    STGroupFile stg;
    String tmp;
    Scope currentScope; // resolve symbols starting in this scope

    Stack<Stack<String>> m_frags;

    public TransPhase (
        GlobalScope globals,
        ParseTreeProperty<Scope> scopes,
        ParseTreeProperty<Object> values) {
        
        this.scopes = scopes;
        this.globals = globals;
        this.values = values;
        
        stg = new STGroupFile("../src/template/group.stg");
        tmp = "";
        m_frags = new Stack<Stack<String>> ();
    }

    public int getValue(ParseTree node) {
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

    public void exitAssign(adeleParser.AssignContext ctx) {
        ST assign = stg.getInstanceOf("assign");
        assign.add("lhs", ctx.ID());
        assign.add("rhs", getValue(ctx.expr()));
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
        funccall.add ("fname", ctx.ID().getText());
        
        String p = new String ();
        Stack<String> param = m_frags.pop ();

        for (int i=0; i<param.size () - 1; ++i) {
            p += param.get (i) + ",";
        }

        p += param.get(param.size() - 1);
        System.err.println ("Exit funcall p: " + p);
        
        funccall.add ("params", p);
        tmp += funccall.render () + "\n";
    }
    
    public void exitAdd (adeleParser.AddContext ctx) {
        System.err.println ("Exit Add: " + ctx.expr (0).getText () + ":" + ctx.expr (1).getText ());
    }

    public void exitNum (adeleParser.NumContext ctx) {
        System.err.println ("Exit Num: " + ctx.NUM ());
        
        if (m_frags.size() > 0)
            m_frags.peek().push (ctx.NUM ().getText ());
    }

    public void exitString (adeleParser.StringContext ctx) {
        System.err.println ("Exit String: " + ctx.STR ());
        
        if (m_frags.size() > 0)
            m_frags.peek().push (ctx.STR ().getText ());
    }
    
    public void exitVar (adeleParser.VarContext ctx) {
        System.err.println ("Exit String: " + ctx.ID ());
        
        /* for function */
        if (m_frags.size() > 0)
            m_frags.peek().push (ctx.ID ().getText ());
    }
}
