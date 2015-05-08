
public class Symbol { // A generic programming language symbol

    String name;      // All symbols at least have a name
    Type type;
    Scope scope;      // All symbols know what scope contains them.

    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    /* TODO: to fix. buggy */
    // static public Type getType (String vname) { return null; }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        String str = "";
        if ( scope != null ) {
            str = scope.getScopeName() + ".";
        }
        if ( type != null ) {
            return '<' + str + getName() + ":" + type.getName() + '>';
        }
        return str + getName();
    }
}
