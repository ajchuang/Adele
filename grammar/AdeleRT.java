import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.*;

public class AdeleRT {
    public static void main (String[] args) throws Exception {
        
        if (args.length == 0)
            return;
                
        ANTLRFileStream in = new ANTLRFileStream (args[0]);
        adeleLexer lexer = new adeleLexer (in);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        adeleParser parser = new adeleParser (tokens);
        parser.addParseListener (new adeleListenerImpl ());
        ParseTree pt = parser.prog ();
    
        /* do the string template things */
        STGroupFile stg = new STGroupFile ("./template/group.stg");
        stg.registerModelAdaptor (ParserRuleContext.class, new STModelAdaptor ());
        ST t = stg.getInstanceOf ("prog");
        t.add ("assign", pt);
        System.out.println (t.render ());
    
    }
}
