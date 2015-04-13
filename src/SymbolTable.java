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
    final static public int M_TYPE_GRAPH     = 7;

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
    public static final BuiltInTypeSymbol _graph =
        new BuiltInTypeSymbol("graph", M_TYPE_GRAPH);


    public static final Type[] indexToType = {
        null, _boolean, _char, _int, _float, _string, _void, _graph
    };

    GlobalScope globals = new GlobalScope();

    public final FunctionSymbol _str2graph =
        new FunctionSymbol("function str2graph", _graph, globals);
    public final FunctionSymbol _draw =
        new FunctionSymbol("function draw", _void, globals);
    public final FunctionSymbol _load =
        new FunctionSymbol("function load", _graph, globals);
    public final FunctionSymbol _sleep =
        new FunctionSymbol("function sleep", _void, globals);
    public final FunctionSymbol _flush =
        new FunctionSymbol("function flush", _void, globals);
    public final FunctionSymbol _random =
        new FunctionSymbol("function random", _int, globals);
    public final FunctionSymbol[] builtInFunctions = {
        _str2graph, _draw, _load, _sleep, _flush, _random
    };

    public SymbolTable() {
        for (Type t : indexToType) {
            if (t != null)
                globals.define((BuiltInTypeSymbol)t);
        }

        for (FunctionSymbol fs: builtInFunctions) {
            globals.define(fs);
        }
    }

    public String toString() { return globals.toString(); }
}
