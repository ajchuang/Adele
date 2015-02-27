import org.antlr.v4.runtime.*;

public class AdeleRT {
    public static void main (String[] args) throws Exception {
        
        if (args.length == 0)
            return;
                
        ANTLRFileStream in = new ANTLRFileStream (args[0]);
        adeleLexer lexer = new adeleLexer (in);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        adeleParser parser = new adeleParser (tokens);
        parser.prog ();
        //System.out.println (parser.eval());                                              
    }
}
