import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestAdl {
    public static Symbol.Type getType(int tokenType) {
        switch ( tokenType ) {
            case AdlParser.K_INT :   return Symbol.Type.tINT;
            case AdlParser.K_VOID :   return Symbol.Type.tVOID;
        }
        return Symbol.Type.tINVALID;
    }

    public void process(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        AdlLexer lexer = new AdlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AdlParser parser = new AdlParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.prog();
        // show tree in text form
        // System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk(def, tree);
        // create next phase and feed symbol table info from def to trans phase
        TransPhase trans = new TransPhase(def.globals, def.scopes, def.values);
        walker.walk(trans, tree);
    }

    public static void main(String[] args) throws Exception {
        new TestAdl().process(args);
    }

}
