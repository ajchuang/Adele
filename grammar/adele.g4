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

    /* Map variable name to Integer object holding value */
    Hashtable<String, Object> symTyp = new Hashtable<String, Object> ();
    Hashtable<String, Object> symVal = new Hashtable<String, Object> ();
}

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:   | ( func | declaration )* ;

/* function and its parameters */
/******************************************************************************/
func:   TYPE ID LPAREN plist RPAREN stmts END 
            { 
                //System.out.println ("func: " + $ID.text + " is implemented"); 
            } ;
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
                    symTyp.put ($ID.text, Integer.valueOf (F_TYPE_INT));
                    symVal.put ($ID.text, Integer.valueOf (0));
                    //System.out.println ("var: " + $ID.text + " is declared"); 
                } ;

/* expressions */
/******************************************************************************/
expr returns [int value]:
        |                               /* empty expression */
                { $value = 0; } 
        |   ID      EQUAL   expr        /* assignment */
                { 
                    symVal.put ($ID.text, Integer.valueOf ($expr.value));
                    $value = $expr.value;
                    //System.out.println ("assignment: " + $value);
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
                    $value = 0;
                    String id = $ID.text;

                    if (symVal.containsKey (id)) {
                        Integer i = (Integer)symVal.get (id);
                        $value = i.intValue ();
                    }
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
