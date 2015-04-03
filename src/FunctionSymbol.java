import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends ScopedSymbol {

    Map<String, Symbol> arguments = new LinkedHashMap<String, Symbol>();

    public FunctionSymbol(String name, Type retType, Scope enclosingScope) {
        super(name, retType, enclosingScope);
    }

    public Map<String, Symbol> getMembers() { return arguments; }

    public String toString() {
        return "function "+name+"("+
            arguments.keySet().toString()+")";
    }
}

