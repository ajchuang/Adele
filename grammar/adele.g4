grammar adele;

/******************************************************************************/
/* Adele runtime                                                              */
/******************************************************************************/
@header {
    import java.util.*;
}

@members {

    /* constant */
    final int F_TYPE_INT = 1;

    /* globals */
    int m_curScope = 0;

    /* Map variable name to Integer object holding value */
    Hashtable<Integer, Object> m_scopeTable = new Hashtable<Integer, Object> (); 
    Hashtable<String, Object> symTyp = new Hashtable<String, Object> ();
    Hashtable<String, Object> symVal = new Hashtable<String, Object> ();
    
    /* global symbols */
    Hashtable<String, Object> m_funTbl = new Hashtable<String, Object> ();
    Hashtable<String, Object> m_glbTbl = new Hashtable<String, Object> ();
}

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:    
        |   func* 
        |   declaration*
        ;

/* function and its parameters */
/******************************************************************************/
func:   TYPE ID LPAREN plist RPAREN stmts END 
            {
                /* insert into the function table */
                // m_funTbl.put ($ID.text, null);
            } 
        ;
plist:  | ( TYPE ID COMMA )* TYPE ID ;

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:       SEMICOLON       
        |   if_stmt       
        |   while_stmt      
        |   expr SEMICOLON  
        |   declaration SEMICOLON
        ;

if_stmt:        IF LPAREN expr RPAREN expr END ;
while_stmt:     WHILE LPAREN expr RPAREN stmts END ;
declaration:    TYPE ID 
                {
                    symTyp.put ($ID.text, new Integer (F_TYPE_INT));
                    symVal.put ($ID.text, new Integer (0));
                    System.out.println ("declare var: " + $ID.text); 
                } ;

/* expressions */
/******************************************************************************/
expr returns [int value]:
            
            ID      EQUAL   e1=expr        /* assignment */
                {
                    int v = $e1.value;
                    System.out.println ("assignment: " + $ID.text + " = " + $e1.text + ":" + v);
                    symVal.put ($ID.text, new Integer (v));
                    $value = v;
                } 
        |   e1=expr    MULTI   e2=expr        /* multiplication */
                {
                    $value = $e1.value * $e2.value;
                }
        |   e1=expr    DIV     e2=expr        /* division */
                {
                    $value = $e1.value / $e2.value;
                }
        |   e1=expr    ADD     e2=expr        /* addition */
                {
                    $value = $e1.value + $e2.value;
                    System.out.println ("ADD: " + $value);
                }
        |   e1=expr    SUB     e2=expr        /* substraction */
                {
                    $value = $e1.value - $e2.value;
                }
        |   expr    GT      expr        /* less than */
        |   expr    LT      expr        /* less than */
        |   expr    GET     expr        /* less than */
        |   expr    LET     expr        /* less than */
        |   LPAREN  expr    RPAREN      /* parenthesis */
                { $value = $expr.value; }
        |   ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN /* @lfred: to fix - lame overlay */
        |   ID LPAREN func_plist RPAREN /* function call */
                { 
                    //System.out.println ("func: " + $ID.text + " is called"); 
                    
                    /* brute force */
                    if ($ID.text.equals ("print_str")) {
                        System.out.println ($func_plist.text);
                    }
                }
        |   RETURN expr
                {
                    $value = $expr.value;
                }
        |   ID  
                { 
                    String id = $ID.text;

                    if (symVal.containsKey (id)) {
                        Integer i = (Integer)symVal.get (id);
                        $value = i.intValue ();
                        System.out.println ("ID: " + $ID.text + ":" + $value);
                    } else {
                        $value = 0;
                        System.out.println ("UNKOWN ID: " + $ID.text + ":" + $value);
                    }
                }
        |   NUM
                {
                    $value = Integer.parseInt ($NUM.text);
                    System.out.println ("NUM: " + $NUM.text + ":" + $value);
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

/* symbols */
ADD:        '+'  ;
SUB:        '-'  ;
MULTI:      '*'  ;
DIV:        '/'  ;
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

/* types */
fragment INT:   'int'   ;
fragment FLOAT: 'float' ;
fragment CHAR:  'char'  ;
fragment VOID:  'void'  ;
fragment BOOL:  'bool'  ;
TYPE:   INT | FLOAT | CHAR | BOOL | VOID ;

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
