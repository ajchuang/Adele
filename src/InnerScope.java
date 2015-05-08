/* Inner scope is used in a statement */
public class InnerScope extends BaseScope {

    public InnerScope(Scope enclosing) {
        super(enclosing);
    }

    @Override
    public String getScopeName() {
        return new String("InnerScope");
    }
}
