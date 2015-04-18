import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class TransPhase extends adeleBaseListener {

    ParseTreeProperty<Scope>    scopes;
    ParseTreeProperty<Object>   values;
    ParseTreeProperty<String>   codes;
    GlobalScope globals;
    STGroupFile stg;
    String outName = "output";
    Scope currentScope; // resolve symbols starting in this scope

    public TransPhase(
            GlobalScope globals,
            ParseTreeProperty<Scope> scopes,
            ParseTreeProperty<Object> values,
            ParseTreeProperty<String> codes) {

        this.scopes     = scopes;
        this.globals    = globals;
        this.values     = values;
        this.codes      = codes;

        stg = new STGroupFile("../src/template/group.stg");
    }

    public void setOutputFilename(String name) {
        if (name != null)
            outName = name;
    }

    /* Start of overriding the methods in adeleBaseLisnter
     *
     * IMPORTANT:
     *     Please add the methods following the order as in adeleBaseListener!
     *     Also, if grammar files are modified, please double check the orders
     *     of adeleBaseListener and the below overriding. The examination and
     *     debugging should be eaiser if the orders between adeleBaseListener
     *     and this class are synced.
     *     If any auxiliary methods are added, please added above this comment.
     */

    public void enterProg(adeleParser.ProgContext ctx) {
        currentScope = globals;
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        System.err.println("exitProg:");

        StringBuilder prog = new StringBuilder();
        StringBuilder testprog = new StringBuilder();

        ST befprog = stg.getInstanceOf("befprog");
        ST befprog_test = stg.getInstanceOf("befprog_test");
        //ST aftprog = stg.getInstanceOf("aftprog");

        //prog.append(befprog.render());
        prog.append("\n/***** Start of source codes semantics *****/\n");
        for (int i = 0; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null) {
                if (ctx.getChild(i) instanceof TerminalNode) {
                    prog.append(ctx.getChild(i).getText());
                } else {
                    prog.append('\n');
                    prog.append(codes.get(ctx.getChild(i)));
                }
            }
        }
        prog.append("\n/***** End of source codes semantics *****/\n");
        testprog.append(prog.toString());
        prog.insert(0, befprog.render());
        testprog.insert(0, befprog_test.render());

        List<adeleParser.FuncContext> func_list = ctx.func();
        for (int i = 0; i < func_list.size(); ++i) {
            ST funcexports = stg.getInstanceOf("funcexports");
            funcexports.add("fname", func_list.get(i).ID());
            testprog.append('\n');
            testprog.append(funcexports.render());
        }

        //System.err.println(prog.toString());

        // Output Javascript and HTML
        try {
            PrintWriter jsOut = new PrintWriter(outName + ".js", "utf-8");
            jsOut.println(prog.toString());
            jsOut.flush();
            jsOut.close();

            ST html = stg.getInstanceOf("html");
            html.add("jssource", outName + ".js");
            PrintWriter htmlOut = new PrintWriter(outName + ".html", "utf-8");
            htmlOut.println(html.render());
            htmlOut.flush();
            htmlOut.close();

            PrintWriter jsTestOut = new PrintWriter("../test/"+outName + "_test.js", "utf-8");
            jsTestOut.println(testprog.toString());
            jsTestOut.flush();
            jsTestOut.close();
        } catch (IOException ioe) {
            System.out.println("Failed in outputing files");
        }
    }

    public void enterType_declaration(adeleParser.Type_declarationContext ctx) {
        System.err.println("enter typr declaration:");

        
    }

    public void exitType_declaration(adeleParser.Type_declarationContext ctx) { 

        System.err.println("exit Type declaration:");

        StringBuilder memberList = new StringBuilder();

        for (int i = 0; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null) {
                if (ctx.getChild(i) instanceof adeleParser.Type_dec_itemContext)
                memberList.append(codes.get(ctx.getChild(i)) + " ");
            }
        }

        ST groupDef = stg.getInstanceOf("groupdef");
        groupDef.add("gname", ctx.ID());
        groupDef.add("memberList", memberList.toString());
        codes.put(ctx, groupDef.render());

        System.err.println(codes.get(ctx));
    }

    public void exitType_dec_item(adeleParser.Type_dec_itemContext ctx) { 
        System.err.println("exitType_dec_iten:");

        codes.put(ctx, ctx.ID().getText());

        System.err.println(codes.get(ctx));
    }
/*
    public void exitGVarDecl(adeleParser.GVarDeclContext ctx) { 

    }

    public void exitGArrayDecl(adeleParser.GArrayDeclContext ctx) {

    }
*/
    public void enterFunc(adeleParser.FuncContext ctx) {
        currentScope = scopes.get(ctx);
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        System.err.println("exitFunc:");

        currentScope = currentScope.getEnclosingScope();

        ST func = stg.getInstanceOf("funcdef");
        func.add("fname", ctx.ID());
        func.add("params", codes.get(ctx.plist()));
        func.add("body", codes.get(ctx.stmts()));
        codes.put(ctx, func.render());

        System.err.println(codes.get(ctx));
    }

    public void exitPlist(adeleParser.PlistContext ctx) {
        System.err.println("exitPlist:");

        StringBuilder plist = new StringBuilder();

        if (ctx.getChild(0) != null) {
            plist.append(codes.get(ctx.getChild(0)));
        }
        for (int i = 1; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null &&
                    !(ctx.getChild(i) instanceof TerminalNode)) {
                /*
                 * For function parameter list, the added part should not be
                 * terminal.
                 */
                plist.append(",");
                plist.append(codes.get(ctx.getChild(i)));
            }
        }
        codes.put(ctx, plist.toString());

        System.err.println(codes.get(ctx));
    }

    public void exitPitem(adeleParser.PitemContext ctx) {
        System.err.println("exitPitem:");

        codes.put(ctx, ctx.ID().getText());

        System.err.println(codes.get(ctx));
    }

    public void exitStmts(adeleParser.StmtsContext ctx) {
        System.err.println("exitStmts:");

        StringBuilder stmts = new StringBuilder();

        if (ctx.getChild(0) != null)
            stmts.append(codes.get(ctx.getChild(0)));
        for (int i = 1; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null) {
                stmts.append('\n');
                stmts.append(codes.get(ctx.getChild(i)));
            }
        }
        codes.put(ctx, stmts.toString());

        System.err.println(codes.get(ctx));
    }

    public void exitStm_if(adeleParser.Stm_ifContext ctx) {
        codes.put(ctx, codes.get(ctx.if_stmt()));
    }

    public void exitStm_while(adeleParser.Stm_whileContext ctx) {
        codes.put(ctx, codes.get(ctx.while_stmt()));
    }

    public void exitStm_expr(adeleParser.Stm_exprContext ctx) {
        System.err.println("exitStm_expr:");

        codes.put(ctx, codes.get(ctx.expr()) + ';');

        System.err.println(codes.get(ctx));
    }

    public void exitStm_dec(adeleParser.Stm_decContext ctx) {
        System.err.println("exitStm_dec:");

        codes.put(ctx, codes.get(ctx.declaration()) + ';');

        System.err.println(codes.get(ctx));
    }

    public void exitStm_ret(adeleParser.Stm_retContext ctx){
        System.err.println("exitStm_ret:");

        codes.put(ctx, "return "+codes.get(ctx.expr())+';');

        System.err.println(codes.get(ctx));
    }


    public void enterIf_stmt(adeleParser.If_stmtContext ctx) {
        //currentScope = scopes.get(ctx);
    }

    public void exitIf_stmt(adeleParser.If_stmtContext ctx) {
        System.err.println("exitIf_stmt:");

        // Mark for it excepts currently
        //currentScope = currentScope.getEnclosingScope();

        ST ifstmt = stg.getInstanceOf("ifstmt");
        ifstmt.add("expr", codes.get(ctx.expr()));
        ifstmt.add("body", codes.get(ctx.stmts()));
        codes.put(ctx, ifstmt.render());

        System.err.println(codes.get(ctx));
    }

    public void enterWhile_stmt(adeleParser.While_stmtContext ctx) {
        //currentScope = scopes.get(ctx);
    }

    public void exitWhile_stmt(adeleParser.While_stmtContext ctx) {
        System.err.println("exitWhile_stmt:");

        // Mark for it excepts currently
        //currentScope = currentScope.getEnclosingScope();

        ST whilestmt = stg.getInstanceOf("whilestmt");
        whilestmt.add("expr", codes.get(ctx.expr()));
        whilestmt.add("body", codes.get(ctx.stmts()));
        codes.put(ctx, whilestmt.render());

        System.err.println(codes.get(ctx));
    }

    public void exitVarDecl(adeleParser.VarDeclContext ctx) {
        System.err.println("exitVarDecl:");

        String typeText = ctx.type().getText();

        ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", ctx.ID());

        StringBuilder initValue = new StringBuilder();

        if (typeText.indexOf("group") == 0)
        {
            String typeName = typeText.substring(5);
            String symbolName = "group " + typeName;
            System.err.println ("symbolName is " + symbolName);
            GroupSymbol gs = (GroupSymbol)currentScope.resolve(symbolName);

            Map<String, Symbol> members = gs.getMembers();

            initValue.append("new " + typeName + "()");
            decl.add("value", initValue.toString());
            /*
            for (String key : members.keySet())
                initValue.append(members.get(key).getName() + " ");

            initValue.append(")");
            */
        }
        else if (ctx.expr() != null)
        {
            initValue.append(codes.get(ctx.expr()));
            decl.add("value", initValue.toString());
        }
        codes.put(ctx, decl.render());

        System.err.println(codes.get(ctx));
    }

    private String genSB(List<Integer> dimenList)
    {
        int s = dimenList.size();

        if (s == 1)
            return "[]";

        StringBuilder res = new StringBuilder();

        String substr = genSB(dimenList.subList(0, s - 1));

        res.append("[" + substr);
        for (int i = 1; i < dimenList.get(s - 1); i++)
            res.append(", " + substr);
        res.append("]");

        return res.toString();
    }

    public void exitArrayDecl(adeleParser.ArrayDeclContext ctx) {

        List<Integer> d = new ArrayList<Integer>();

        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_dimen(i) == null)
                break;
            else
                d.add(Integer.parseInt(codes.get(ctx.array_dimen(i))));

        Collections.reverse(d);

        System.err.println(genSB(d));

        ST adecl = stg.getInstanceOf("arraydecl");
        adecl.add("aname", ctx.ID().getText());
        adecl.add("def", genSB(d));

        String initValue = "";

        String typeText = ctx.type().getText();
        if (typeText.indexOf("group") == 0)
        {
            String typeName = typeText.substring(5);
            initValue = "new " + typeName + "()";
        }
        else
            initValue = "0";

        StringBuilder initBlock = new StringBuilder();
        for (int i = d.size() - 1; i >= 0; i--)
        {
            ST forloop = stg.getInstanceOf("arrayinit");
            forloop.add("dimen", Integer.toString(d.get(i)));
            forloop.add("varName", "i" + Integer.toString(d.size() - 1 - i));
            initBlock.append(forloop.render() + " ");
        }

        StringBuilder initExpr = new StringBuilder();
        initExpr.append("ar");
        for (int i = 0; i < d.size(); i++)
            initExpr.append("[i" + Integer.toString(i) + "]");
        initExpr.append(" = " + initValue + ";");

        initBlock.append(initExpr.toString());

        adecl.add("init", initBlock.toString());

        codes.put(ctx, adecl.render());

        System.err.println(codes.get(ctx));
    }

    public void enterArray_dimen(adeleParser.Array_dimenContext ctx) {
        //codes.put(ctx, '[' + ctx.NUM().getText() + ']');
        codes.put(ctx, ctx.NUM().getText());
    }

    public void exitAdd(adeleParser.AddContext ctx) {
        System.err.println("exitAdd: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        /* output a: this is the last expression */
        /*
        ST add = stg.getInstanceOf("add");
        add.add("lhs", codes.get(ctx.expr(0)));
        add.add("rhs", codes.get(ctx.expr(1)));
        */

        /* set the code to the node */
        //codes.put(ctx, add.render());

        codes.put(ctx, codes.get(ctx.expr(0)) + ctx.ADD() + codes.get(ctx.expr(1)));

        System.err.println(codes.get(ctx));
    }

    public void exitSub(adeleParser.SubContext ctx) {
        System.err.println("exitSub: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        /* output a: this is the last expression */
        /*
        ST add = stg.getInstanceOf("add");
        add.add("lhs", codes.get(ctx.expr(0)));
        add.add("rhs", codes.get(ctx.expr(1)));
        */

        /* set the code to the node */
        //codes.put(ctx, add.render());

        codes.put(ctx, codes.get(ctx.expr(0)) + ctx.SUB() + codes.get(ctx.expr(1)));

        System.err.println(codes.get(ctx));
    }

    public void exitNegNum(adeleParser.NegNumContext ctx) {
        System.err.println("exitNegNum: " + ctx.SUB() + ctx.NUM());
        codes.put(ctx, ctx.SUB() + ctx.NUM().getText());
        System.err.println(codes.get(ctx));
    }

    public void exitCompare(adeleParser.CompareContext ctx) {
        System.err.println("exitCompare: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        codes.put(ctx, codes.get(ctx.expr(0)) + ctx.COMPARE_OP() + codes.get(ctx.expr(1)));

        System.err.println(codes.get(ctx));
    }

    public void exitMult(adeleParser.MultContext ctx) {
        System.err.println("exitMult: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        codes.put(ctx, codes.get(ctx.expr(0)) + ctx.MULTI_OP() + codes.get(ctx.expr(1)));

        System.err.println(codes.get(ctx));
    }

    public void exitOverlay(adeleParser.OverlayContext ctx) {
        System.err.println("exitOverlay: ");
        ST overlay = stg.getInstanceOf("overlay");
        overlay.add("fg", ctx.ID(0).getText());
        overlay.add("bg", ctx.ID(1).getText());
        overlay.add("r", ctx.expr(0).getText());
        overlay.add("c", ctx.expr(1).getText());

        codes.put(ctx, overlay.render());
        System.err.println(codes.get(ctx));
    }

    public void exitString(adeleParser.StringContext ctx) {
        System.err.println("exitString: " + ctx.STR());
        codes.put(ctx, ctx.STR().getText());
        System.err.println(codes.get(ctx));
    }

    public void exitArrayAssign(adeleParser.ArrayAssignContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.array_access(i)));

        codes.put(ctx, ctx.ID().getText() + sb.toString() + '=' + codes.get(ctx.expr()));
    }

    public void exitVar(adeleParser.VarContext ctx) {
        System.err.println("exitVar: " + ctx.ID());
        codes.put(ctx, ctx.ID().getText());
        System.err.println(codes.get(ctx));
    }

    public void exitNum(adeleParser.NumContext ctx) {
        System.err.println("exitNum: " + ctx.NUM());
        codes.put(ctx, ctx.NUM().getText());
        System.err.println(codes.get(ctx));
    }

    public void exitMemberVar(adeleParser.MemberVarContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.member_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.member_access(i)));

        codes.put(ctx, ctx.ID().getText() + sb.toString());
    }

    public void exitParenExpr(adeleParser.ParenExprContext ctx) {
        System.err.println("exitParenExpr: " + ctx.expr().getText());

        codes.put(ctx, ctx.LPAREN() + codes.get(ctx.expr()) + ctx.RPAREN());

        System.err.println(codes.get(ctx));
    }

    public void exitAtexpr(adeleParser.AtexprContext ctx) {
        System.err.println("exitAt: ");
        ST at = stg.getInstanceOf("at");
        at.add("fg", ctx.ID().getText());
        at.add("r", ctx.expr(0).getText());
        at.add("c", ctx.expr(1).getText());

        codes.put(ctx, at.render());
        System.err.println(codes.get(ctx));
    }

    public void exitFuncCall(adeleParser.FuncCallContext ctx) {
        System.err.println("exitFuncCall: " + ctx.ID().getText());

        ST funccall = stg.getInstanceOf("funccall");
        if (ctx.ID().getText().equals("load")) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(codes.get(ctx.func_plist()).replace("\"", "")));
                StringBuilder graph = new StringBuilder();
                graph.append("str2graph(\"");
                String line = reader.readLine();
                if (line != null) {
                    graph.append(line.replace("\\", "\\\\"));
                    while ((line = reader.readLine()) != null) {
                        graph.append("\\n");
                        graph.append(line.replace("\\", "\\\\"));
                    }
                }
                graph.append("\")");
                codes.put(ctx, graph.toString());
            } catch (IOException ioe) {
                System.err.println("Exception in opening file of loading");
            }
        } else {
            funccall.add("fname", ctx.ID().getText());
            funccall.add("params", codes.get(ctx.func_plist()));
            codes.put(ctx, funccall.render());
        }

        System.err.println(codes.get(ctx));
    }

    public void exitArrayAccess(adeleParser.ArrayAccessContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.array_access(i)));

        codes.put(ctx, ctx.ID().getText() + sb.toString());
    }

    public void exitAssign(adeleParser.AssignContext ctx) {
        System.err.println("exitAssign: " + codes.get(ctx.expr()));

        ST assign = stg.getInstanceOf("assign");
        assign.add("lhs", ctx.ID());
        assign.add("rhs", codes.get(ctx.expr()));
        codes.put(ctx, assign.render());

        System.err.println(codes.get(ctx));
    }

    public void exitArray_access(adeleParser.Array_accessContext ctx) {
        codes.put(ctx, '[' + codes.get(ctx.expr()) + ']');
    }

    public void exitMember_access(adeleParser.Member_accessContext ctx) { 
        codes.put(ctx, '.' + ctx.ID().getText);
    }

    public void exitFpis(adeleParser.FpisContext ctx) {
        System.err.println("exitFpis:");

        StringBuilder plist = new StringBuilder();

        if (ctx.getChild(0) != null) {
            plist.append(codes.get(ctx.getChild(0)));
        }
        for (int i = 1; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null &&
                    !(ctx.getChild(i) instanceof TerminalNode)) {
                /*
                 * For function parameter list, the added part should not be
                 * terminal.
                 */
                plist.append(",");
                plist.append(codes.get(ctx.getChild(i)));
            }
        }
        codes.put(ctx, plist.toString());

        System.err.println(codes.get(ctx));
    }

    public void exitFpitem(adeleParser.FpitemContext ctx) {
        System.err.println("exitFpitem:");

        codes.put(ctx, codes.get(ctx.expr()));

        System.err.println(codes.get(ctx));
    }
}
