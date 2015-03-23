import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.*;

public class AdeleRT {
    public static void main (String[] args) throws Exception {
        if (args.length == 0)
            return;

        AdeleRT adele = new AdeleRT();

        ANTLRFileStream in = new ANTLRFileStream (args[0]);
        adeleLexer lexer = new adeleLexer (in);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        adeleParser parser = new adeleParser (tokens);
        parser.addParseListener (new adeleListenerImpl ());
        ParseTree pt = parser.prog ();
        System.out.println("test: " + pt.toString());

        /* do the string template things */
        adele.walkParseTree(pt);
    }

    public void walkParseTree(ParseTree pt) {
        STGroupFile stg = new STGroupFile("../src/template/group.stg");
        ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", "a");
        decl.add("value", "0");
        ST func = stg.getInstanceOf("funcdef");
        func.add("fname", "main");
        func.add("body", decl.render());
        System.out.println(func.render());
    }
}
