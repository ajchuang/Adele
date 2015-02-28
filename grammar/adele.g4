/******************************************************************************/
/* Grammar Name: adele                                                        */
/******************************************************************************/
grammar adele;

/******************************************************************************/
/* Adele runtime                                                              */
/******************************************************************************/
@header {
    import java.util.*;
}

@members {

    /* constant */
    final int F_TYPE_INT    = 1;
    final int F_TYPE_CHAR   = 2;
    final int F_TYPE_CUSTOM = 3;
    
    final int F_BOOL_TRUE   = 1;
    final int F_BOOL_FALSE  = 0;

    /* Map variable name to Integer object holding value */
    Stack<Hashtable<String, AdeleTypeDes>> m_scope; 
    
    /* global symbols */
    Hashtable<String, Object> m_funTbl;
    Hashtable<String, AdeleTypeDes> m_glbVar;

    /* user defined type */
    int m_curUserTypeId = 0x5566;
    Hashtable<String, Integer> m_userType;
}


/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog                                       
    @init {
        m_scope     = new Stack<Hashtable<String, AdeleTypeDes>> (); 
        m_funTbl    = new Hashtable<String, Object> ();
        m_glbVar    = new Hashtable<String, AdeleTypeDes> ();
        m_userType  = new Hashtable<String, Integer> ();

        /* put the global scope in the bottom of the stack */
        m_scope.push (m_glbVar);
    }
        :
                                            /* empty programs       */ 
        |   ( 
                func                        /* functions            */
        |       type_declaration            /* user defined types   */ 
        |       (declaration SEMICOLON)     /* declarations         */

            )*              
        ;
        
/* type declarations */
/******************************************************************************/
type_declaration:
        GROUP tid=ID 
        (TYPE ID SEMICOLON)* 
        END
            {
                if (m_userType.containsKey ($tid.text)) {
                    System.err.println ("Error: group " + $tid.text + " re-defined.");
                } else {
                    m_userType.put (new String ($tid.text), m_curUserTypeId++);
                }
            }
        ;

/* function and its parameters */
/******************************************************************************/
func:   (TYPE | GROUP ID) ID LPAREN plist RPAREN 
            {
                /* insert into the function table */
                m_funTbl.put ($ID.text, new Integer (0));
                m_scope.push (new Hashtable<String, AdeleTypeDes> ());
            }
        stmts
            {
                m_scope.pop ();
            }
        END ;

plist:  
        |   ( (TYPE ID COMMA) | (GROUP ID ID) )* (TYPE ID | GROUP ID ID) 
        ;

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:       SEMICOLON       
        |   if_stmt       
        |   while_stmt      
        |   expr SEMICOLON  
        |   declaration SEMICOLON
        ;

if_stmt:        IF LPAREN e1=expr RPAREN 
                    {
                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
                    } 
                stmts 
                    {
                        m_scope.pop ();
                    } 
                END ;

while_stmt:     WHILE LPAREN expr RPAREN 
                    {
                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
                    } 
                stmts 
                    {
                        m_scope.pop ();
                    } 
                END ;
declaration:   

                GROUP type=ID name=ID
                    {
                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
                        
                        if (scp.containsKey ($name.text)) {
                            System.err.println ("Duplicate decalration of variable: " + $name.text);
                        } else {
                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_CUSTOM, null);
                            id.setTypeName ($type.text);
                            scp.put ($name.text, id);
                        }
                    }
            |   TYPE ID 
                    {
                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
                        
                        if (scp.containsKey ($ID.text)) {
                            System.err.println ("Duplicate decalration of variable: " + $ID.text);
                        } else {
                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_INT, new Integer (0));
                            scp.put ($ID.text, id);
                        }

                        System.err.println ("declare var: " + $ID.text); 
                    } 
            |   TYPE ID EQUAL expr
                    {
                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
                        
                        if (scp.containsKey ($ID.text)) {
                            System.err.println ("Duplicate decalration of variable: " + $ID.text);
                        } else {
                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_INT, new Integer ($expr.value));
                            scp.put ($ID.text, id);
                        }

                        System.err.println ("declare var: " + $ID.text); 
                    }
            ;

/******************************************************************************/
/* expressions -                                                              */
/*  1.  the order matters -                                                   */
/*      it is the actual order of precedence. (left-associative)              */
/*  2.  we allow int operation at this moment (todo: other types)             */
/******************************************************************************/
expr returns [int value]:
            
            LPAREN  expr    RPAREN            /* parenthesis */
                { 
                    $value = $expr.value; 
                }
        |   ID LPAREN func_plist RPAREN       /* function call */
                { 
                    //System.out.println ("func: " + $ID.text + " is called"); 
                    
                    /* brute force */
                    if ($ID.text.equals ("print")) {
                        System.out.println ($func_plist.text);
                    }
                }
        |   e1=expr    ADDITIVE_OP     e2=expr        /* addition */
                {
                    int e1 = $e1.value;
                    int e2 = $e2.value;

                    if ("+".equals ($ADDITIVE_OP.text))                    
                        $value = e1 + e2;
                    else
                        $value = e1 - e2;
                    
                    System.err.println (
                        "ADD: " + $ADDITIVE_OP.text + ":"  + 
                        $value + ":" + e1 + ":" + e2);
                }
        |   e1=expr    MULTIPLICATIVE_OP   e2=expr        /* multiplication & division */
                {
                    if ("*".equals ($MULTIPLICATIVE_OP.text))
                        $value = $e1.value * $e2.value;
                    else
                        $value = $e1.value / $e2.value;
                }
        |   e1=expr    GT      e2=expr        /* less than */
                {
                    if ($e1.value - $e2.value > 0)
                        $value = F_BOOL_TRUE;
                    else
                        $value = F_BOOL_FALSE;;
                }
        |   e1=expr    LT      e2=expr        /* less than */
                {
                    if ($e1.value - $e2.value < 0)
                        $value = F_BOOL_TRUE;
                    else
                        $value = F_BOOL_FALSE;;
                }
        |   e1=expr    GET     e2=expr        /* less than */
                {
                    if ($e1.value - $e2.value >= 0)
                        $value = F_BOOL_TRUE;
                    else
                        $value = F_BOOL_FALSE;
                }
        |   e1=expr    LET     e2=expr        /* less than */
                {
                    if ($e1.value - $e2.value <= 0)
                        $value = F_BOOL_TRUE;
                    else
                        $value = F_BOOL_FALSE;
                }
        |   ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN /* @lfred: to fix - lame overlay */
        |   ID      EQUAL   e1=expr        /* assignment */
                {
                    int v = $e1.value;

                    /* find the right scope */
                    Hashtable<String, AdeleTypeDes> sc = null;
                    boolean found = false;

                    for (int i = m_scope.size () - 1; i >= 0; --i) {
                        
                        sc = m_scope.elementAt (i);

                        if (sc.containsKey ($ID.text)) {
                            AdeleTypeDes atd = sc.get ($ID.text);
                            atd.setValue (new Integer ($e1.value));
                            $value = v;
                            found = true;
                            break;
                        }
                    }

                    if (found == false)
                        System.err.println ("Error: undefined variable " + $ID.text);
                } 
        |   RETURN expr
                {
                    $value = $expr.value;
                }
        |   ID  
                { 
                    /* find the right scope */
                    Hashtable<String, AdeleTypeDes> sc = null;
                    boolean found = false;

                    for (int i = m_scope.size () - 1; i >= 0; --i) {
                        
                        sc = m_scope.elementAt (i);

                        if (sc.containsKey ($ID.text)) {
                            AdeleTypeDes atd = sc.get ($ID.text);
                            Integer x = (Integer)atd.getValue ();
                            $value = x.intValue ();
                            found = true;
                            break;
                        }
                    }

                    if (found == false)
                        System.err.println ("Error: undefined variable " + $ID.text);
                }
        |   NUM
                {
                    $value = Integer.parseInt ($NUM.text);
                }
        ; 

func_plist:  | ( fpitem COMMA )* fpitem;
fpitem:     ID | NUM | STR ;

/******************************************************************************/
/* tokens                                                                     */
/******************************************************************************/

/* keywords */
IF:     'if'        ;
END:    'end'       ;
WHILE:  'while'     ;
RETURN: 'return'    ;
GROUP:  'group'     ;

/* symbols */
fragment ADD:        '+'  ;
fragment SUB:        '-'  ;
fragment MULTI:      '*'  ;
fragment DIV:        '/'  ;
LPAREN:     '('  ;
RPAREN:     ')'  ;
COMMA:      ','  ;
SEMICOLON:  ';'  ;
EQUAL:      '='  ;
OVERLAY:    '//' ;
AT:         '@'  ;
GT:         '>'  ;
LT:         '<'  ;
GET:        '>=' ;
LET:        '<=' ;

ADDITIVE_OP:    ADD | SUB ;
MULTIPLICATIVE_OP:  MULTI | DIV ;

/* types */
fragment INT:       'int'   ;
fragment FLOAT:     'float' ;
fragment CHAR:      'char'  ;
fragment VOID:      'void'  ;
fragment BOOL:      'bool'  ;
fragment STRING:    'string';
TYPE:   INT | FLOAT | CHAR | BOOL | VOID | STRING;

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
fragment FLOAT_NUM:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
fragment INT_NUM:    [-]?[1-9]+[0-9]* | [0] ;    // integers
fragment CHR:        [A-Za-z0-9_] ;
//NUM:    FLOAT_NUM | INT_NUM ;
NUM:    INT_NUM ;
STR:    '"' CHR* '"' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
