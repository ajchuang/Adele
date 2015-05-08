import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FunctionSymbol extends ScopedSymbol {

    static HashMap<String, Integer> funcTable = new HashMap<String, Integer>() ;

    ArrayList<Symbol> params;
    Map<String, Symbol> locals;

    /*------------------------------------------------------------------------*/
    /* Static utilities                                                       */
    /*------------------------------------------------------------------------*/
    static int funcLine(String fname) {
        if (funcTable.containsKey(fname) == false) {
            return -1;
        }

        return funcTable.get(fname).intValue();
    }

    static Set<String> getFuncs() {
        return funcTable.keySet();
    }

    /*------------------------------------------------------------------------*/
    /* Class members                                                          */
    /*------------------------------------------------------------------------*/
    public FunctionSymbol(String name, Type retType, Scope enclosingScope, int ln) {
        super(name, retType, enclosingScope);
        params = new ArrayList<Symbol>();
        locals = new LinkedHashMap<String, Symbol>();

        funcTable.put(name, ln);
    }

    public boolean defineParam(Scope curScope, Symbol param) {

        Iterator<Symbol> it = params.iterator();
        String name = param.getName();

        while (it.hasNext()) {
            Symbol sym = it.next();

            if (sym.getName().equals(name)) {
                return false;
            }
        }

        if (curScope.define(param)) {
            params.add(param);
            return true;
        }

        return false;
    }

    public void defineParam_def(Symbol param) {
        params.add(param);
    }

    public ArrayList<Symbol> getParams() {
        return params;
    }

    @Override
    public Map<String, Symbol> getMembers() {
        return locals;
    }
}

