lexer grammar adelelex;

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
NE:         '!=' ;

ADDITIVE_OP:    ADD | SUB ;
MULTIPLICATIVE_OP:  MULTI | DIV ;

/* types */
K_INT:  'int';
K_VOID: 'void';
K_FLOAT: 'float'

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers

/* primitive types */
//fragment FLOAT_NUM:  [-]?[0-9]+ '.' [0-9]+ ;     // floating numbers
fragment FLOAT_NUM: INT_NUM '.' [0-9]+; // is it better?
fragment INT_NUM:    [-]?[1-9]+[0-9]* | [0] ;    // integers
fragment CHR:        [A-Za-z0-9_] ;
//NUM:    FLOAT_NUM | INT_NUM ;
NUM:    INT_NUM ;
STR:    '"' CHR* '"' ;

/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines

/* comments */
COMMENT: '#' .* ;
