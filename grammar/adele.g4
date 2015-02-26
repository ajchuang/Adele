grammar adele;

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:   | ( func | declaration )* ;

/* function and its parameters */
/******************************************************************************/
func:   TYPE ID LPAREN plist RPAREN stmts END { System.out.println ($ID.text + " is implemented"); } ;
plist:  | (TYPE ID COMMA)* TYPE ID ;

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
declaration:    TYPE ID { System.out.println ("var " + $ID.text + " is declared"); } ;

/* expressions */
/******************************************************************************/
expr:   |                               /* empty expression */
        |   ID EQUAL expr               /* assignment */
        |   expr MULTI expr             /* multiplication */
        |   expr DIV expr               /* division */
        |   expr ADD expr               /* addition */
        |   expr SUB expr               /* substraction */
        |   expr GT expr                /* less than */
        |   expr LT expr                /* less than */
        |   expr GET expr               /* less than */
        |   expr LET expr               /* less than */
        |   LPAREN expr RPAREN          /* parenthesis */
        |   ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN /* @lfred: to fix - lame overlay */
        |   ID LPAREN func_plist RPAREN /* function call */
                { System.out.println ($ID.text + " is called"); }
        |   RETURN expr
        |   ID                        
        |   NUM ; 

func_plist:  | (fpitem COMMA)* fpitem;
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
NUM:    FLOAT_NUM | INT_NUM ;
STR:    '"' CHR* '"' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
