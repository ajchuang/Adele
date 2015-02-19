grammar adele;

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:   expr ';';

func:   TYPE ID '(' plist ')' 
        expr 
        END;
        
plist:  ID | ID plist;
   
expr:   expr ('*' | '/') expr   |
        expr ('+' | '-') expr   |
        NUM                     |
        ID ;

/******************************************************************************/
/* tokens                                                                     */
/******************************************************************************/

/* types */
PTYPE:  'int' | 'fload' | 'char' ;        // primitive type supported.
ATYPE:  PTYPE'[' ']' ;              // array type
TYPE:   PTYPE | ATYPE;

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
FLOAT:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
INT:    [-]?[1-9]+[0-9]* | [0] ;    // integers
NUM:    FLOAT | INT ;

/* keywords */
END:    'end' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
