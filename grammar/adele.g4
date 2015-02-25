grammar adele;

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:   func ;       /* @lfred: to fix */

/* function and its parameters */
/******************************************************************************/
func:   TYPE ID LPAREN plist RPAREN stmts END ;
plist:  | TYPE ID | TYPE ID COMMA plist_non_empty ;
plist_non_empty: TYPE ID | TYPE ID COMMA plist_non_empty ;

/* statments: if, while, declarations */
/******************************************************************************/
if_stmt:    IF LPAREN expr RPAREN expr END ;
while_stmt: WHILE LPAREN expr RPAREN stmts END ;
 
stmts:  if_stmt         |
        while_stmt      |
        expr SEMICOLON  |
        declaration     ;      

/* declare a variable */
/******************************************************************************/
declaration: TYPE ID | TYPE ID EQUAL expr ;

/* expressions */
/******************************************************************************/
expr:   ID EQUAL expr               |   /* assignment */
        expr ( MULTI | DIV ) expr   |   /* multiplication, division */
        expr ( ADD | SUB) expr      |   /* addition, substraction */
        LPAREN expr RPAREN          |   /* parenthesis */
        ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN |  /* @lfred: to fix - lame overlay */
        ID LPAREN func_plist RPAREN |   /* function call */ 
        NUM                         |   
        ID                          ;
        
func_plist:         | ID | NUM | STR | ID COMMA func_plist_non_empty ;
func_plist_non_empty: ID | NUM | STR ;

/******************************************************************************/
/* tokens                                                                     */
/******************************************************************************/

/* types */
PTYPE:  'int' | 'fload' | 'char' ;  // primitive type supported.
ATYPE:  PTYPE'[' ']' ;              // array type
TYPE:   PTYPE | ATYPE | 'void' ;

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
FLOAT:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
INT:    [-]?[1-9]+[0-9]* | [0] ;    // integers
NUM:    FLOAT | INT ;
CHAR:   [A-Za-z0-9_] ;
STR:    '"' CHAR* '"' ;

/* keywords */
IF:     'if' ;
END:    'end' ;
WHILE:  'while' ;

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

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
