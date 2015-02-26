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
stmts:  stmt* ;
stmt:   SEMICOLON       |
        if_stmt         |
        while_stmt      |
        expr SEMICOLON  |
        declaration     ;

if_stmt:    IF LPAREN expr RPAREN expr END ;
while_stmt: WHILE LPAREN expr RPAREN stmts END ;

/* declare a variable */
/******************************************************************************/
declaration: TYPE ID | TYPE ID EQUAL expr ;

/* expressions */
/******************************************************************************/
expr:                               |   /* empty expression */
        ID EQUAL expr               |   /* assignment */
        expr ( MULTI | DIV ) expr   |   /* multiplication, division */
        expr ( ADD | SUB) expr      |   /* addition, substraction */
        LPAREN expr RPAREN          |   /* parenthesis */
        ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN |  /* @lfred: to fix - lame overlay */
        ID LPAREN func_plist RPAREN |   /* function call */
        ID                          |
        NUM; 

func_plist:  | fpitem | fpitem COMMA func_plist_non_empty ;
func_plist_non_empty: fpitem | fpitem COMMA func_plist_non_empty;
fpitem:     ID | NUM | STR ;

/******************************************************************************/
/* tokens                                                                     */
/******************************************************************************/

/* keywords */
IF:     'if'    ;
END:    'end'   ;
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

/* types */
PTYPE:  INT | FLOAT | CHAR ;  // primitive type supported.
ATYPE:  PTYPE'[' ']' ;              // array type
TYPE:   PTYPE | ATYPE | VOID ;
INT:    'int'   ;
FLOAT:  'float' ;
CHAR:   'char'  ;
VOID:   'void'  ;

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
FLOAT_NUM:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
INT_NUM:    [-]?[1-9]+[0-9]* | [0] ;    // integers
NUM:    FLOAT_NUM | INT_NUM ;
CHR:    [A-Za-z0-9_] ;
STR:    '"' CHR* '"' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
