import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class TransPhase extends adeleBaseListener {

    /* constants */
    final static String M_DefOutName = "output";
    final static String M_GroupFile = "../src/template/group.stg";

    /* SDD nodes */
    ParseTreeProperty<Scope>    scopes;
    ParseTreeProperty<Object>   values;
    ParseTreeProperty<String>   codes;
    
    /* common data members */
    GlobalScope globals;
    STGroupFile stg;
    String outName = M_DefOutName;
    Scope currentScope; // resolve symbols starting in this scope

    /*------------------------------------------------------------------------*/
    /* Utility functions                                                      */
    /*------------------------------------------------------------------------*/
    void print (String str) {
        System.out.println ("    [TransPhase] " + str);
    }

    void putCode (ParserRuleContext ctx, String snippet) {
         codes.put (ctx, snippet);
    }

    public void setOutputFilename (String name) {
        if (name != null)
            outName = name;
    }
    
    public String createFuncTable () {
      
        String x = 
            new String ( "function __exceptionHandler__ ()  { \n var __funcTable__ = {}; \n");
        Set<String> lnSet = FunctionSymbol.getFuncs ();

        for (String s : lnSet) {
            int n = FunctionSymbol.funcLine (s);
            x += ("__funcTable__['" + s + "'] = " + n + ";\n");
        }

        /* TODO: insert handler code here */

        x += "} \n";

        return x;
    }
    
    /*------------------------------------------------------------------------*/
    /* ctor                                                                   */
    /*------------------------------------------------------------------------*/
    public TransPhase(
            GlobalScope globals,
            ParseTreeProperty<Scope> scopes,
            ParseTreeProperty<Object> values,
            ParseTreeProperty<String> codes) {

        this.scopes     = scopes;
        this.globals    = globals;
        this.values     = values;
        this.codes      = codes;

        stg = new STGroupFile (M_GroupFile);
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
        print ("exitProg:");

        StringBuilder prog = new StringBuilder();
        StringBuilder testprog = new StringBuilder();

        ST befprog = stg.getInstanceOf("befprog");
        ST befprog_test = stg.getInstanceOf("befprog_test");
        //ST aftprog = stg.getInstanceOf("aftprog");

        //prog.append(befprog.render());
        prog.append("\n/***** Start of source codes semantics *****/\n");
        
        /* create the function-src line table */
        String fncTable = createFuncTable ();
        prog.append (fncTable);

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
            ST exports = stg.getInstanceOf("exports");
            exports.add("fname", func_list.get(i).ID());
            testprog.append('\n');
            testprog.append(exports.render());
        }


        List<adeleParser.DeclarationContext> decl_list = ctx.declaration();
        for (int i = 0; i < decl_list.size(); ++i) {
            ST exports = stg.getInstanceOf("exports");
            adeleParser.DeclarationContext decl = decl_list.get(i);
            TerminalNode idn=null;
            if (decl instanceof adeleParser.ArrayDeclContext) {
                idn = ((adeleParser.ArrayDeclContext)decl).ID();
            }
            if (decl instanceof adeleParser.VarDeclContext) {
                idn = ((adeleParser.VarDeclContext)decl).ID();
            }
            if (idn!=null) {
                exports.add("fname", idn);
                testprog.append('\n');
                testprog.append(exports.render());
            }

        }


        //print (prog.toString());

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
        print ("enter typr declaration:");
    }

    public void exitType_declaration(adeleParser.Type_declarationContext ctx) { 

        print ("exit Type declaration:");

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
        putCode (ctx, groupDef.render() + ";");

        print (codes.get(ctx));
    }

    public void exitGVarDecl(adeleParser.GVarDeclContext ctx) {

        print ("exitgVarDecl:");

        putCode (ctx, ctx.ID().getText());

        print (codes.get(ctx));

    }

    public void exitGArrayDecl(adeleParser.GArrayDeclContext ctx) {

        print ("exitgArrayDecl:");

        StringBuilder dimen = new StringBuilder();

        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_dimen(i) == null)
                break;
            else
                dimen.append("[" + codes.get(ctx.array_dimen(i)) + "]");

        putCode (ctx, ctx.ID().getText() + dimen);

        print (codes.get(ctx));

    }
/*
    public void exitType_dec_item(adeleParser.Type_dec_itemContext ctx) { 
        print ("exitType_dec_iten:");

        putCode (ctx, ctx.ID().getText());

        print (codes.get(ctx));
    }
    */
/*
    public void exitGVarDecl(adeleParser.GVarDeclContext ctx) { 

    }

    public void exitGArrayDecl(adeleParser.GArrayDeclContext ctx) {

    }
*/
    public void enterFunc(adeleParser.FuncContext ctx) {
        //currentScope = scopes.get(ctx);
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        print ("exitFunc:");

        //currentScope = currentScope.getEnclosingScope();

        ST func = stg.getInstanceOf("funcdef");
        func.add("fname", ctx.ID());
        func.add("params", codes.get(ctx.plist()));
        func.add("body", codes.get(ctx.stmts()));
        putCode (ctx, func.render());

        print (codes.get(ctx));
    }

    public void exitPlist(adeleParser.PlistContext ctx) {
        print ("exitPlist:");

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
        putCode (ctx, plist.toString());

        print (codes.get(ctx));
    }

    public void exitPitem(adeleParser.PitemContext ctx) {
        print ("exitPitem:");

        putCode (ctx, ctx.ID().getText());

        print (codes.get(ctx));
    }

    public void exitStmts(adeleParser.StmtsContext ctx) {
        print ("exitStmts:");

        StringBuilder stmts = new StringBuilder();

        if (ctx.getChild(0) != null)
            stmts.append (codes.get (ctx.getChild (0)));

        for (int i = 1; i < ctx.getChildCount(); ++i) {
            if (ctx.getChild(i) != null) {
                stmts.append('\n');
                stmts.append(codes.get(ctx.getChild(i)));
            }
        }
        putCode (ctx, stmts.toString());

        print (codes.get(ctx));
    }

    public void exitStm_if(adeleParser.Stm_ifContext ctx) {
        putCode (ctx, codes.get(ctx.if_stmt()));
    }

    public void exitStm_while(adeleParser.Stm_whileContext ctx) {
        putCode (ctx, codes.get(ctx.while_stmt()));
    }

    public void exitStm_expr(adeleParser.Stm_exprContext ctx) {
        print ("exitStm_expr:");

        putCode (ctx, codes.get(ctx.expr()) + ';');

        print (codes.get(ctx));
    }

    public void exitStm_dec(adeleParser.Stm_decContext ctx) {
        print ("exitStm_dec:");

        putCode (ctx, codes.get(ctx.declaration()) + ';');

        print (codes.get(ctx));
    }

    public void exitStm_ret(adeleParser.Stm_retContext ctx){
        print ("exitStm_ret:");

        putCode (ctx, "return "+codes.get(ctx.expr())+';');

        print (codes.get(ctx));
    }

    public void enterIf_stmt(adeleParser.If_stmtContext ctx) {
        //currentScope = scopes.get(ctx);
    }

    public void exitIf_stmt(adeleParser.If_stmtContext ctx) {
        print ("exitIf_stmt:");

        //currentScope = currentScope.getEnclosingScope();

        ST ifstmt = stg.getInstanceOf("ifstmt");
        ifstmt.add("expr", codes.get(ctx.expr()));
        ifstmt.add("body", codes.get(ctx.stmts()));
        putCode (ctx, ifstmt.render());

        print (codes.get(ctx));
    }

    public void enterWhile_stmt(adeleParser.While_stmtContext ctx) {
        //currentScope = scopes.get(ctx);
    }

    public void exitWhile_stmt(adeleParser.While_stmtContext ctx) {
        print ("exitWhile_stmt:");

        //currentScope = currentScope.getEnclosingScope();

        ST whilestmt = stg.getInstanceOf("whilestmt");
        whilestmt.add("expr", codes.get(ctx.expr()));
        whilestmt.add("body", codes.get(ctx.stmts()));
        putCode (ctx, whilestmt.render());

        print (codes.get(ctx));
    }

    public void exitVarDecl(adeleParser.VarDeclContext ctx) {
        print ("exitVarDecl:");

        String typeText = ctx.type().getText();

        ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", ctx.ID());

        StringBuilder initValue = new StringBuilder();

        String definePart = "";

        if (typeText.indexOf("group") == 0)
        {
            String typeName = typeText.substring(5);
            String symbolName = "group " + typeName;
            print  ("symbolName is " + symbolName);
            GroupSymbol gs = (GroupSymbol)currentScope.resolve(symbolName);

            Map<String, Symbol> members = gs.getMembers();

            initValue.append("new " + typeName + "()");
            decl.add("value", initValue.toString());

            //definePart = decl.render();
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

            //definePart = decl.render();
        }

        putCode (ctx, decl.render());

        print (codes.get(ctx));
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

    private String arrayDecl(adeleParser.ArrayDeclContext ctx) {

        StringBuilder dimen = new StringBuilder();

        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_dimen(i) == null)
                break;
            else
                dimen.append(codes.get(ctx.array_dimen(i)) + ", ");

        String res = ctx.ID().getText() + "=initArray([" + dimen.toString() + "]);";

        return res;
        /*
        List<Integer> d = new ArrayList<Integer>();

        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_dimen(i) == null)
                break;
            else
                d.add(Integer.parseInt(codes.get(ctx.array_dimen(i))));

        
        Collections.reverse(d);

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
        
        return adecl.render();
        */
    }

    public void exitArrayDecl(adeleParser.ArrayDeclContext ctx) {
        /*
        List<Integer> d = new ArrayList<Integer>();

        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_dimen(i) == null)
                break;
            else
                d.add(Integer.parseInt(codes.get(ctx.array_dimen(i))));

        Collections.reverse(d);

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
        
        putCode (ctx, adecl.render());
        */

        putCode (ctx, arrayDecl(ctx));
        print (codes.get(ctx));
    }

    public void enterArray_dimen(adeleParser.Array_dimenContext ctx) {
        //putCode (ctx, '[' + ctx.NUM().getText() + ']');
        putCode (ctx, ctx.NUM().getText());
    }

    public void exitSub(adeleParser.SubContext ctx) {
        print ("exitSub: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        /* output a: this is the last expression */
        /*
        ST add = stg.getInstanceOf("add");
        add.add("lhs", codes.get(ctx.expr(0)));
        add.add("rhs", codes.get(ctx.expr(1)));
        */

        /* set the code to the node */
        //putCode (ctx, add.render());

        putCode (ctx, codes.get(ctx.expr(0)) + ctx.SUB() + codes.get(ctx.expr(1)));

        print (codes.get(ctx));
    }

    public void exitMult(adeleParser.MultContext ctx) {
        print ("exitMult: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        putCode (ctx, codes.get(ctx.expr(0)) + ctx.MULTI_OP() + codes.get(ctx.expr(1)));

        print (codes.get(ctx));
    }

    public void exitAssign(adeleParser.AssignContext ctx) {
        print ("exitAssign: " + codes.get(ctx.expr()));

        ST assign = stg.getInstanceOf("assign");
        assign.add("lhs", ctx.ID());
        assign.add("rhs", codes.get(ctx.expr()));
        putCode (ctx, assign.render());

        print (codes.get(ctx));
    }

    public void exitNegNum(adeleParser.NegNumContext ctx) {
        print ("exitNegNum: " + ctx.SUB() + ctx.NUM());
        putCode (ctx, ctx.SUB() + ctx.NUM().getText());
        print (codes.get(ctx));
    }

    public void exitVar(adeleParser.VarContext ctx) {
        print ("exitVar: " + ctx.ID());
        putCode (ctx, ctx.ID().getText());
        print (codes.get(ctx));
    }

    public void exitCompare(adeleParser.CompareContext ctx) {
        print ("exitCompare: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        putCode (ctx, codes.get(ctx.expr(0)) + ctx.COMPARE_OP() + codes.get(ctx.expr(1)));

        print (codes.get(ctx));
    }

    public void exitAdd(adeleParser.AddContext ctx) {
        print ("exitAdd: " + ctx.expr(0).getText() + ":" + ctx.expr(1).getText());

        /* output a: this is the last expression */
        /*
        ST add = stg.getInstanceOf("add");
        add.add("lhs", codes.get(ctx.expr(0)));
        add.add("rhs", codes.get(ctx.expr(1)));
        */

        /* set the code to the node */
        //putCode (ctx, add.render());

        putCode (ctx, codes.get(ctx.expr(0)) + ctx.ADD() + codes.get(ctx.expr(1)));

        print (codes.get(ctx));
    }

    public void exitAtexpr(adeleParser.AtexprContext ctx) {
        print ("exitAt: ");
        ST at = stg.getInstanceOf("at");
        at.add("fg", ctx.ID().getText());
        at.add("r", ctx.expr(0).getText());
        at.add("c", ctx.expr(1).getText());

        putCode (ctx, at.render());
        print (codes.get(ctx));
    }

    public void exitArrayAccess(adeleParser.ArrayAccessContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.array_access(i)));

        putCode (ctx, ctx.ID().getText() + sb.toString());
    }

    public void exitMemberVar(adeleParser.MemberVarContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.member_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.member_access(i)));

        putCode (ctx, ctx.ID().getText() + sb.toString());
    }

    public void exitNum(adeleParser.NumContext ctx) {
        print ("exitNum: " + ctx.NUM());
        putCode (ctx, ctx.NUM().getText());
        print (codes.get(ctx));
    }

    public void exitVatt(adeleParser.VattContext ctx) {
        print("exitVatt: " + codes.get(ctx.expr(0)) + " | " + codes.get(ctx.expr(1)));

        ST vatt = stg.getInstanceOf("vatt");
        vatt.add("gu", codes.get(ctx.expr(0)));
        vatt.add("gd", codes.get(ctx.expr(1)));

        putCode(ctx, vatt.render());
    }

    public void exitCast(adeleParser.CastContext ctx) {
        print("exitCast:");
    }

    public void exitArrayAssign(adeleParser.ArrayAssignContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_access(i) == null)
                break;
            else
                sb.append(codes.get(ctx.array_access(i)));
        /*
        StringBuilder dimen = new StringBuilder();
        for (int i = 0; i < ctx.getChildCount(); ++i)
            if (ctx.array_access(i) == null)
                break;
            else
                dimen.append("[" + codes.get(ctx.array_access(i)) + "]");
        
        putCode (ctx, ctx.ID().getText() + sb.toString() + dimen.toString());
        */
        putCode (ctx, ctx.ID().getText() + sb.toString() + '=' + codes.get(ctx.expr()));
    }

    public void exitOverlay(adeleParser.OverlayContext ctx) {
        print ("exitOverlay: ");
        ST overlay = stg.getInstanceOf("overlay");
        overlay.add("fg", ctx.ID(0).getText());
        overlay.add("bg", ctx.ID(1).getText());
        overlay.add("r", ctx.expr(0).getText());
        overlay.add("c", ctx.expr(1).getText());

        putCode (ctx, overlay.render());
        print (codes.get(ctx));
    }

    public void exitString(adeleParser.StringContext ctx) {
        print ("exitString: " + ctx.STR());
        putCode (ctx, ctx.STR().getText());
        print (codes.get(ctx));
    }

    public void exitParenExpr(adeleParser.ParenExprContext ctx) {
        print ("exitParenExpr: " + ctx.expr().getText());

        putCode (ctx, ctx.LPAREN() + codes.get(ctx.expr()) + ctx.RPAREN());

        print (codes.get(ctx));
    }

    public void exitFuncCall(adeleParser.FuncCallContext ctx) {
        print ("exitFuncCall: " + ctx.ID().getText());

        ST funccall = stg.getInstanceOf("funccall");
        if (ctx.ID().getText().equals("load")) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(codes.get(ctx.func_plist()).replace("\"", "")));
                StringBuilder graph = new StringBuilder();
                graph.append("str2graph(\"");
                String line = reader.readLine();
                if (line != null) {
                    line = line.replace("\\", "\\\\");
                    line = line.replace("\"", "\\\"");
                    graph.append(line);
                    while ((line = reader.readLine()) != null) {
                        graph.append("\\n");
                        line = line.replace("\\", "\\\\");
                        line = line.replace("\"", "\\\"");
                        graph.append(line);
                    }
                }
                graph.append("\")");
                putCode (ctx, graph.toString());
            } catch (IOException ioe) {
                print ("Exception in opening file of loading");
            }
        } else {
            funccall.add("fname", ctx.ID().getText());
            funccall.add("params", codes.get(ctx.func_plist()));
            putCode (ctx, funccall.render());
        }

        print (codes.get(ctx));
    }

    public void exitArray_access(adeleParser.Array_accessContext ctx) {
        putCode (ctx, '[' + codes.get(ctx.expr()) + ']');
    }

    public void exitMember_access(adeleParser.Member_accessContext ctx) { 
        putCode (ctx, '.' + ctx.ID().getText());
    }

    public void exitFpis(adeleParser.FpisContext ctx) {
        print ("exitFpis:");

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
        putCode (ctx, plist.toString());

        print (codes.get(ctx));
    }

    public void exitFpitem(adeleParser.FpitemContext ctx) {
        print ("exitFpitem:");

        putCode (ctx, codes.get(ctx.expr()));

        print (codes.get(ctx));
    }
}
