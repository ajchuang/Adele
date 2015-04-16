import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

public class AdeleRT {

    public void process (String fname) throws Exception {

        InputStream is;

        if (fname != null)
            is = new FileInputStream (fname);
        else
            is = System.in;

        /* read file and create the parse tree */
        ANTLRInputStream input = new ANTLRInputStream (is);
        adeleLexer lexer = new adeleLexer (input);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        adeleParser parser = new adeleParser (tokens);
        parser.setBuildParseTree (true);

        /* start parsing */
        ParseTree tree = parser.prog ();
        ParseTreeWalker walker = new ParseTreeWalker ();

        /* create the symbol table instance */
        SymbolTable symtab = new SymbolTable();
        
        /**********************************************************************/
        /* information collection phase                                       */
        /**********************************************************************/
        ScanPhase scan = new ScanPhase (symtab);
        walker.walk (scan, tree);

        /**********************************************************************/
        /* semantic check phase                                               */
        /**********************************************************************/
        DefPhase def = new DefPhase (symtab);
        walker.walk (def, tree);

        /**********************************************************************/
        /* translation phase                                                  */
        /**********************************************************************/
        ParseTreeProperty<String> codes =
            new ParseTreeProperty<String>();

        TransPhase trans = new TransPhase (symtab.globals, def.scopes, def.values, codes);
        // The codes below are marked for easier testing
        /*if (fname != null) {
            String filename = new File(fname).getName();
            int pos = filename.lastIndexOf('.');
            if (pos > 0)
                trans.setOutputFilename(filename.substring(0, pos));
        }*/
        walker.walk (trans, tree);
    }

    public static void main (String[] args) {

        String fname = null;

        if (args.length == 1)
            fname = args[0];

        AdeleRT adele = new AdeleRT ();

        try {
            adele.process (fname);
        } catch (Exception e) {
            System.err.println ("Exception: " + e);
            e.printStackTrace ();
        }
    }
}
