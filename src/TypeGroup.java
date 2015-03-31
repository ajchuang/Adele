import java.util.*;

class UserType extends TypeBase {
    
    /* field name, type id */
    HashMap<String, Integer> m_fields;
        
    public UserType (String name) throws Exception {
        super (name);
        m_fields = new HashMap<String, Integer> (); 
    }

    public boolean addField (String type, String name) {
    
        /* is the type declared */
        if (isValidType (type) == false)
            return false;
        
        /* if duplicated field name exists */
        if (m_fields.containsKey (name))
            return false;

        /* add to the field */
        m_fields.put (type, getTypeId (type));  

        return true;
    }
}
