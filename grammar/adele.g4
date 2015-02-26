grammar adele;

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:   func ;       /* @lfred: to fix */

/* function and its parameters */
/******************************************************************************/
func:   TYPE ID LPAREN plist RPAREN stmts END ;
plist:  | (TYPE ID COMMA)* TYPE ID ;

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:   SEMICOLON       |
        if_stmt         |
        while_stmt      |
        expr SEMICOLON  |
        declaration SEMICOLON ;

if_stmt:        IF LPAREN expr RPAREN expr END ;
while_stmt:     WHILE LPAREN expr RPAREN stmts END ;
declaration:    TYPE ID ;

/* expressions */
/******************************************************************************/
expr:                               |   /* empty expression */
        ID EQUAL expr               |   /* assignment */
        expr ( MULTI | DIV ) expr   |   /* multiplication, division */
        expr ( ADD   | SUB ) expr   |   /* addition, substraction */
        expr ( GT    | LT  ) expr   |   /* greater or less than */
        LPAREN expr RPAREN          |   /* parenthesis */
        ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN |  /* @lfred: to fix - lame overlay */
        ID LPAREN func_plist RPAREN |   /* function call */
        ID                          |
        NUM ; 

func_plist:  | (fpitem COMMA)* fpitem;
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
GT:         '>'  ;
LT:         '<'  ;


/* types */
fragment INT:   'int'   ;
fragment FLOAT: 'float' ;
fragment CHAR:  'char'  ;
fragment VOID:  'void'  ;
TYPE:   INT | FLOAT | CHAR | VOID ;

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
fragment FLOAT_NUM:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
fragment INT_NUM:    [-]?[1-9]+[0-9]* | [0] ;    // integers
fragment CHR:        [A-Za-z0-9_] ;
NUM:        FLOAT_NUM | INT_NUM ;
STR:        '"' CHR* '"' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
