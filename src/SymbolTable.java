/* Symbol table stores symbols declared/builtin that can be
** used as type
*/
import java.util.List;

public class SymbolTable {
      /* constants */
    final static public int M_TYPE_USER      = 0; // user-defined type
    final static public int M_TYPE_BOOLEAN   = 1;
    final static public int M_TYPE_CHAR      = 2;
    final static public int M_TYPE_INT       = 3;
    final static public int M_TYPE_FLOAT     = 4;
    final static public int M_TYPE_STRING    = 5;
    final static public int M_TYPE_VOID      = 6;

    public static final BuiltInTypeSymbol _boolean =
        new BuiltInTypeSymbol("bool", M_TYPE_BOOLEAN);
    public static final BuiltInTypeSymbol _char =
        new BuiltInTypeSymbol("char", M_TYPE_CHAR);
    public static final BuiltInTypeSymbol _int =
        new BuiltInTypeSymbol("int", M_TYPE_INT);
    public static final BuiltInTypeSymbol _float =
        new BuiltInTypeSymbol("float", M_TYPE_FLOAT);
    public static final BuiltInTypeSymbol _string =
        new BuiltInTypeSymbol("string", M_TYPE_STRING);
    public static final BuiltInTypeSymbol _void =
        new BuiltInTypeSymbol("void", M_TYPE_VOID);

    public static final Type[] indexToType = {
        null, _boolean, _char, _int, _float, _string, _void
    };

    GlobalScope globals = new GlobalScope();

    public SymbolTable() {
        for (Type t : indexToType) {
            if (t != null)
                globals.define((BuiltInTypeSymbol)t);
        }
    }

    public String toString() { return globals.toString(); }
}
