import java.util.*;

/* base class for types */
class TypeBase {

    /* constants */
    final static public int M_TYPE_INT       = 1;
    final static public int M_TYPE_FLOAT     = 2;
    final static public int M_TYPE_STRING    = 3;
    final static public int M_TYPE_VOID      = 4;

    static int m_typeCounter;
    static HashMap<String, Integer> m_typeMap;
    
    /* data member for each type */
    int m_typeId;
    String m_typeName;

    static {
        m_typeCounter = 6;
        m_typeMap = new HashMap <String, Integer> ();
        m_typeMap.put ("int",       M_TYPE_INT);
        m_typeMap.put ("float",     M_TYPE_FLOAT);
        m_typeMap.put ("string",    M_TYPE_STRING);
        m_typeMap.put ("void",      M_TYPE_VOID);
    }

    static public boolean isValidType (String tName) {
        return m_typeMap.containsKey (tName);
    }

    static public int getTypeId (String tName) {
        return m_typeMap.get (tName);
    }

    public TypeBase (String tName) throws Exception {
        
        /* check duplication */
        if (m_typeMap.containsKey (tName) == true)
           throw new Exception ("Type " + tName + " has been defined.");

        m_typeMap.put (tName, m_typeCounter);
        m_typeId = m_typeCounter;
        m_typeName = tName;
        m_typeCounter++;
    }

    int getTypeId () {
        return m_typeId; 
    }

    String getTypeName () {
        return m_typeName; 
    }
}
