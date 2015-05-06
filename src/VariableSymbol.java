public class VariableSymbol extends Symbol {
  boolean initialized = false;

  public void setInitialized() {
    initialized = true;
  }

  public boolean isInitialized() {
    return initialized;
  }

  public VariableSymbol(String name, Type type) {
    super(name, type);
  }
}
