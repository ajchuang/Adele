import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends ScopedSymbol {

    Map<String, Symbol> arguments = new LinkedHashMap<String, Symbol>();

    public FunctionSymbol(String name, Type retType, Scope enclosingScope) {
        super(name, retType, enclosingScope);
    }

    public Map<String, Symbol> getMembers() { return arguments; }

    // public boolean setParam (String name, Symbol param) {

    //     if (arguments.containsKey (name) == true) {
    //         System.err.println ("[ERROR] duplicate argument name, " + name);
    //         return false;
    //     }

    //     arguments.put (name, param);
    //     return true;
    // }

    public String toString() {
        /* name contains 'function ' */
        return name+
        "("+arguments.values().toString()+")";
    }
}

