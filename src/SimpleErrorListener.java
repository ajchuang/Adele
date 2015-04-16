import org.antlr.v4.runtime.*;

public class SimpleErrorListener extends BaseErrorListener {

    public static SimpleErrorListener _INST = new SimpleErrorListener ();
    int m_errCount = 0;

    public SimpleErrorListener () {
    }

    @Override
    public void syntaxError (
        Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int line,
        int charPositionInLine,
        String msg,
        RecognitionException e) {
    
        super.syntaxError (recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        m_errCount++;
    }

    public int getErrCount () {
        return m_errCount;
    }
}
