import java.util.*;

class GroupSymbol extends ScopedSymbol implements Type, Scope {

    /* field name, type id */
    Map<String, Symbol> m_fields = new LinkedHashMap<String, Symbol>();

    public GroupSymbol (String name, Scope parent) {
        super (name, parent);
    }

    /*********by alfred*********/
    public boolean addField (String type, String name) {

        /* TODO: fix compile errors */
        /*
        // is the type declared
        if (isValidType (type) == false)
            return false;

        // if duplicated field name exists
        if (m_fields.containsKey (name))
            return false;

        // add to the field
        m_fields.put (name, getTypeId (type));
        */
        
        return true;
    }
    /******************/

    public int getTypeIndex() { return 0; } //return SymbolTable.tUSER; }
    public Symbol resolveMember(String name) { return m_fields.get(name); }
    public Map<String, Symbol> getMembers() { return m_fields; }


    @Override
    public String toString () {
        //String s = new String (m_typeName + ": " + m_fields);
        //return s;
        return "";
    }
}
