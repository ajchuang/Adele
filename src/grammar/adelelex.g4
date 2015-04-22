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
fragment MULTI:      '*'  ;
fragment DIV:        '/'  ;
fragment HASH:       '#'  ;
fragment GT:         '>'  ;
fragment LT:         '<'  ;
fragment GET:        '>=' ;
fragment LET:        '<=' ;
fragment NE:         '!=' ;
fragment EQ:         '==' ;


LPAREN:     '('  ;
RPAREN:     ')'  ;
COMMA:      ','  ;
SEMICOLON:  ';'  ;
EQUAL:      '='  ;
OVERLAY:    '//' ;
AT:         '@'  ;
LSB:		    '['  ;
RSB:		    ']'  ;
LBRACE:		  '{'  ;
RBRACE:		  '}'  ;
DOT:			    '.'  ;

ADD:        '+'  ;
SUB:        '-'  ;

MULTI_OP:       MULTI   | DIV ;
COMPARE_OP:     NE | GT | LT | GET | LET | EQ ;

/* types */
/*
fragment INT:       'int'   ;
fragment FLOAT:     'float' ;
fragment CHAR:      'char'  ;
fragment VOID:      'void'  ;
fragment BOOL:      'bool'  ;
fragment STRING:    'string';
*/

/* identifiers */
ID:     [_a-zA-Z]+[_0-9a-zA-Z]* ;                   // match lower-case identifiers

/* primitive types */
fragment INT_NUM:    [1-9]+[0-9]* | [0] ;       // integers
fragment FLOAT_NUM: INT_NUM '.' [0-9]+;             // is it better?
fragment CHR:        [A-Za-z0-9_] ;
NUM:    FLOAT_NUM | INT_NUM ;
STR:    '"' .*? '"' ;


/* spaces, tabs.. */
WS:     [ \t\r\n]+ -> skip ;        // skip spaces, tabs, newlines
LINE_COMMENT:   HASH ~[\r\n]* -> channel(HIDDEN) ;
