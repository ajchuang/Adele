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

    public static final Type arithAddOp[][] = {
                    /*  USER,   BOOL,   CHAR,   INT,    FLOAT,  STRING, VOID,   GRAPH */
        /* USER */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* BOOL */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* CHAR */  {   null,   null,   _char,  _int,   _float, _string,null,   null    },
        /* INT  */  {   null,   null,   _int,   _int,   _float, _string,null,   null    },
        /* FLT  */  {   null,   null,   _float, _float, _float, _string,null,   null    },
        /* STR  */  {   null,   null,   _string,_string,_string,_string,null,   null    },
        /* VOID */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* GRP  */  {   null,   null,   null,   null,   null,   null,   null,   _graph  }
    };

    public static final Type arithMultiOp[][] = {
                    /*  USER,   BOOL,   CHAR,   INT,    FLOAT,  STRING, VOID,   GRAPH */
        /* USER */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* BOOL */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* CHAR */  {   null,   null,   _int,   _int,   _float, null,   null,   null    },
        /* INT  */  {   null,   null,   _int,   _int,   _float, null,   null,   null    },
        /* FLT  */  {   null,   null,   _float, _float, _float, null,   null,   null    },
        /* STR  */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* VOID */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* GRP  */  {   null,   null,   null,   null,   null,   null,   null,   _graph  }
    };

    public static final Type assignOp[][] = {
                    /*  USER,   BOOL,   CHAR,   INT,    FLOAT,  STRING, VOID,   GRAPH */
        /* USER */  {   null,   null,   null,   null,   null,   null,   null,   null    },
        /* BOOL */  {   null,   _boolean,null,  null,   null,   null,   null,   null    },
        /* CHAR */  {   null,   null,   _int,   _int,   _float, null,   null,   null    },
        /* INT  */  {   null,   null,   _int,   _int,   _float, null,   null,   null    },
        /* FLT  */  {   null,   null,   _float, _float, _float, null,   null,   null    },
        /* STR  */  {   null,   null,   null,   null,   null,   _string,null,   null    },
        /* VOID */  {   null,   null,   null,   null,   null,   null,   _void,  null    },
        /* GRP  */  {   null,   null,   null,   null,   null,   null,   null,   _graph  }
    };

    public static final boolean compOp[][] = {
                    /*  USER,   BOOL,   CHAR,   INT,    FLOAT,  STRING, VOID,   GRAPH */
        /* USER */  {   false,  false,  false,  false,  false,  false,  false,  false   },
        /* BOOL */  {   false,  true,   false,  false,  false,  false,  false,  false   },
        /* CHAR */  {   false,  false,  true,   true,   true,   false,  false,  false   },
        /* INT  */  {   false,  false,  true,   true,   true,   false,  false,  false   },
        /* FLT  */  {   false,  false,  true,   true,   true,   false,  false,  false   },
        /* STR  */  {   false,  false,  false,  false,  false,  true,   false,  false   },                   
        /* VOID */  {   false,  false,  false,  false,  false,  false,  true,   false   },
        /* GRP  */  {   false,  false,  false,  false,  false,  false,  false,  true    }
    };

    GlobalScope globals = new GlobalScope();

    public final FunctionSymbol _str2graph =
        new FunctionSymbol("function str2graph", _graph, globals, 0);
    public final FunctionSymbol _int2str =
        new FunctionSymbol("function int2str", _string, globals, 0);
    public final FunctionSymbol _draw =
        new FunctionSymbol("function draw", _void, globals, 0);
    public final FunctionSymbol _load =
        new FunctionSymbol("function load", _graph, globals, 0);
    public final FunctionSymbol _sleep =
        new FunctionSymbol("function sleep", _void, globals, 0);
    public final FunctionSymbol _flush =
        new FunctionSymbol("function flush", _void, globals, 0);
    public final FunctionSymbol _random =
        new FunctionSymbol("function random", _int, globals, 0);
    public final FunctionSymbol _consoleLog =
        new FunctionSymbol("function consoleLog", _void, globals, 0);
    
    public final FunctionSymbol[] builtInFunctions = {
        _str2graph, _draw, _load, _sleep, _flush, _random, _consoleLog, _int2str
    };

    /* static initialization */
    {
        /* initializa global function symbols */
        VariableSymbol v1 = new VariableSymbol ("str", _string);
        _str2graph.defineParam_def (v1);
        
        VariableSymbol v2 = new VariableSymbol ("str", _string);
        _load.defineParam_def (v2);

        VariableSymbol v3 = new VariableSymbol ("ms", _int);
        _sleep.defineParam_def (v3);
        
        VariableSymbol v4 = new VariableSymbol ("max", _int);
        _random.defineParam_def (v4);
        
        VariableSymbol v5 = new VariableSymbol ("str", _string);
        _consoleLog.defineParam_def (v5);

        VariableSymbol v6 = new VariableSymbol ("int", _int);
        _int2str.defineParam_def (v6);

    }

    public SymbolTable () {
        
        for (Type t : indexToType) {
            if (t != null)
                globals.define ((BuiltInTypeSymbol)t);
        }

        for (FunctionSymbol fs : builtInFunctions) {
            globals.define (fs);
        }
    }

    public String toString() { return globals.toString(); }
}
