
public class ArrayType extends Symbol implements Type {

    Type    elementType;
    int     dimension;

    public ArrayType(Type elementType, int dimension) {
        super(elementType.getName() + " array");
        this.elementType = elementType;
        this.dimension = dimension;
    }

    public Type getElmType() {
        return elementType;
    }

    public int  getDimension() {
        return dimension;
    }

    public int  getTypeIndex() {
        return 0;
    }
}
