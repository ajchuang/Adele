public interface Scope {
    public String getScopeName();

    /** Where to look next for symbols */
    public Scope getEnclosingScope();

    /** Define a symbol in the current scope */
    public boolean define(Symbol sym);

    /** Look up name in this scope or in enclosing scope if not here */
    public Symbol resolve(String name);
}
