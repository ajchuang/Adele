import java.util.LinkedHashMap;
import java.util.Map;

class GroupSymbol extends ScopedSymbol implements Type, Scope {

    /* field name, type id */
    Map<String, Symbol> fields = new LinkedHashMap<String, Symbol>();

    public GroupSymbol(String name, Scope parent) {
        super(name, parent);
    }

    // public boolean addField (String type, String name) {

        /* TODO: fix compile errors */
        /*
        // is the type declared
        if (isValidType (type) == false)
            return false;

        // if duplicated field name exists
        if (fields.containsKey (name))
            return false;

        // add to the field
        fields.put (name, getTypeId (type));
        */

    //     return true;
    // }
    /******************/

    public int getTypeIndex() {
        return 0;
    } //return SymbolTable.tUSER; }

    public Symbol resolveMember(String name) {
        return fields.get(name);
    }

    public Map<String, Symbol> getMembers() {
        return fields;
    }

    @Override
    public String toString() {
        // name is inherited from Symbol
        String str = new String(this.name
            + "(" + fields.values().toString() + ")");
        return str;
    }
}
