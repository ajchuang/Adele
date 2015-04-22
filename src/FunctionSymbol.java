import java.util.*;

public class FunctionSymbol extends ScopedSymbol {

    static HashMap<String, Integer> m_funcTable = new HashMap<String, Integer>() ;

    ArrayList<Symbol> m_params;
    Map<String, Symbol> m_locals;

    /*------------------------------------------------------------------------*/
    /* Static utilities                                                       */
    /*------------------------------------------------------------------------*/
    static int funcLine (String fname) {
        if (m_funcTable.containsKey (fname) == false)
            return -1;

        return m_funcTable.get (fname).intValue ();
    }

    static Set<String> getFuncs () {
        return m_funcTable.keySet ();
    }

    /*------------------------------------------------------------------------*/
    /* Class members                                                          */
    /*------------------------------------------------------------------------*/
    public FunctionSymbol (String name, Type retType, Scope enclosingScope, int ln) {
        super (name, retType, enclosingScope);
        m_params = new ArrayList<Symbol> ();
        m_locals = new LinkedHashMap<String, Symbol>();

        m_funcTable.put (name, ln);
    }

    public boolean defineParam (Scope curScope, Symbol param) {
        
        Iterator<Symbol> it = m_params.iterator ();
        String p_name = param.getName ();
        
        while (it.hasNext ()) {
            Symbol s = it.next ();

            if (s.getName ().equals (p_name))
                return false;
        }

        if (curScope.define (param)) {
            m_params.add (param);
            return true;
        } 
        
        return false;
    }

    public void defineParam_def (Symbol param) {
        m_params.add (param);
    }

    public ArrayList<Symbol> getParams () {
        return m_params;
    }

    @Override
    public Map<String, Symbol> getMembers () {
        return m_locals; 
    }
    
    @Override
    public String toString () {
        /* name contains 'function ' */
        return name;
    }
}

