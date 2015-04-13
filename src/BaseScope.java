import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {
    Scope enclosingScope;
    // null if global (outermost) scope
    Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

    public BaseScope(Scope enclosingScope) { this.enclosingScope = enclosingScope;  }

    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing scope
        if ( enclosingScope != null ) return enclosingScope.resolve(name);
        return null; // not found
    }

    public boolean define(Symbol sym) {
        if (symbols.containsKey(sym.name)) {
            // String symType;
            // if (sym instanceof VariableSymbol)
            //     symType = "variable";
            // else if (sym instanceof GroupSymbol)
            //     symType = "group";
            // else
            //     symType = "function";

            // System.err.println(symType + " "+sym.name
            //     + " is already defined in current scopes");
            return false;
        } else {
            symbols.put(sym.name, sym);
            sym.scope = this; // track the scope in each symbol
            return true;
        }
    }

    public Scope getEnclosingScope() { return enclosingScope; }

    public String toString() { return getScopeName()+":"+symbols.keySet().toString(); }
}
