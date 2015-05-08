import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SimpleErrorListener extends BaseErrorListener {

    public static SimpleErrorListener _INST = new SimpleErrorListener();
    int errCount = 0;

    @Override
    public void syntaxError(
        Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int line,
        int charPositionInLine,
        String msg,
        RecognitionException exception) {

        System.err.println("[ERROR] line " + line + ":"
            + charPositionInLine + ": " + msg);
        errCount++;
    }

    public int getErrCount() {
        return errCount;
    }
}
