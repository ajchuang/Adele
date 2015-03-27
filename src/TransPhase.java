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

    Stack<String> m_funParam;


    public TransPhase (
        GlobalScope globals,
        ParseTreeProperty<Scope> scopes,
        ParseTreeProperty<Object> values) {
        this.scopes = scopes;
        this.globals = globals;
        this.values = values;
        stg = new STGroupFile("../src/template/group.stg");
        tmp = "";
    }

    public int getValue(ParseTree node) {
        return (int)values.get(node);
    }

    public void enterProg(adeleParser.ProgContext ctx) {
        currentScope = globals;
        //System.out.println("--------------------------");
        // ST befprog = stg.getInstanceOf("befprog");
        // System.out.print(befprog.render());
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        // ST aftprog = stg.getInstanceOf("aftprog");
        // System.out.print(aftprog.render());
        System.out.println();
    }

    public void enterFunc(adeleParser.FuncContext ctx) {
        currentScope = scopes.get(ctx);
        System.out.print(tmp);
        tmp = "";
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
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
        ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", ctx.ID());
        if (ctx.expr() != null) {
            decl.add("value", getValue(ctx.expr()));
        }
        tmp += decl.render() + '\n';
    }

    public void enterFuncCall (adeleParser.FuncCallContext ctx) {
        System.err.println ("Enter funcall: " + ctx.ID().getText());
        m_funParam = new Stack<String> ();
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
        for (int i=0; i<m_funParam.size () - 1; ++i) {
            p += m_funParam.get (i) + ",";
        }

        p += m_funParam.get(m_funParam.size() - 1);
        System.err.println ("Exit funcall p: " + p);
        
        funccall.add ("params", p);
        tmp += funccall.render ();

        m_funParam = null;
    }

    public void exitNum (adeleParser.NumContext ctx) {
        System.err.println ("Exit Num: " + ctx.NUM ());
        
        if (m_funParam != null)
            m_funParam.push (ctx.NUM ().getText ());
    }

    public void exitString (adeleParser.StringContext ctx) {
        System.err.println ("Exit String: " + ctx.STR ());
    
        if (m_funParam != null)
            m_funParam.push (ctx.STR ().getText ());
    }
}
