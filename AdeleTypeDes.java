
public class AdeleTypeDes {

    int     m_type;
    String  m_typeName;
    
    Object  m_value;

    public AdeleTypeDes (int type, Object v) {
        m_type  = type;
        m_value = v;
    }

    public void setType (int t) {
        m_type = t;
    }

    public int getType () {
        return m_type;
    }

    public void setValue (Object v) {
        m_value = v;
    }

    public Object getValue () {
        return m_value;
    }

    public void setTypeName (String typeName) {
        m_typeName = typeName;
    }
    
    public String getTypeName () {
        return m_typeName;
    }
}

