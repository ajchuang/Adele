import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class AdeleRunTime {

    public boolean process(String fname, String oname) throws Exception {

        InputStream is;

        if (fname != null) {
            is = new FileInputStream(fname);
        } else {
            is = System.in;
        }

        /* read file and create the parse tree */
        ANTLRInputStream input = new ANTLRInputStream(is);
        adeleLexer lexer = new adeleLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(SimpleErrorListener._INST);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        adeleParser parser = new adeleParser(tokens);
        parser.setBuildParseTree(true);
        parser.removeErrorListeners();
        parser.addErrorListener(SimpleErrorListener._INST);
        /* start parsing */
        ParseTree tree = parser.prog();

        if (SimpleErrorListener._INST.getErrCount() > 0) {
            System.err.println("[ERROR] Syntax errors. Stop");
            return false;
        }

        /* create the symbol table instance */
        SymbolTable symtab = new SymbolTable();
        ParseTreeWalker walker = new ParseTreeWalker();

        /*--------------------------------------------------------------------*/
        /* information collection phase                                       */
        /*--------------------------------------------------------------------*/
        ScanPhase scan = new ScanPhase(symtab);
        walker.walk(scan, tree);
        if (scan.getErrCount() != 0) {
            return false;
        }

        /*--------------------------------------------------------------------*/
        /* semantic check phase                                               */
        /*--------------------------------------------------------------------*/
        DefPhase def = new DefPhase(symtab);
        walker.walk(def, tree);
        if (def.getErrCount() != 0) {
            return false;
        }

        /*--------------------------------------------------------------------*/
        /* translation phase                                                  */
        /*--------------------------------------------------------------------*/
        ParseTreeProperty<String> codes =
            new ParseTreeProperty<String>();

        TransPhase trans = new TransPhase(symtab.globals, def, def.scopes, def.values, codes);
        trans.setOutputFilename(oname);
        // The codes below are marked for easier testing
        /*if(fname != null) {
            String filename = new File(fname).getName();
            int pos = filename.lastIndexOf('.');
            if (pos > 0)
                trans.setOutputFilename(filename.substring(0, pos));
        }*/
        walker.walk(trans, tree);
        return true;
    }

    /* main function */
    public static void main(String[] args) {

        String fname = null;
        String oname = null;

        if (args.length == 1) {
            fname = args[0];
        } else if (args.length == 2) {
            fname = args[0];
            oname = args[1];
        }

        AdeleRunTime adele = new AdeleRunTime();

        try {
            if (adele.process(fname, oname)) {
                System.err.println("Compilation Completed.");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e);
            e.printStackTrace();
        }
    }
}
