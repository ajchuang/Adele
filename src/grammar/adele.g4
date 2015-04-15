/******************************************************************************/
/* Grammar Name: adele                                                        */
/******************************************************************************/
grammar adele;
import adelelex;

/******************************************************************************/
/* Adele runtime                                                              */
/******************************************************************************/

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:
        (
                func                        /* functions            */
        |       type_declaration            /* user defined types   */
        |       declaration SEMICOLON       /* declarations         */

        )+?
        ;

/* type declarations */
/******************************************************************************/
type_declaration:
            GROUP ID
            (type_dec_item SEMICOLON)+?
            END
        ;

type_dec_item:
            type ID;

/* function and its parameters */
/******************************************************************************/
func:
            type ID LPAREN plist RPAREN
            stmts
            END
        ;

plist:
        |   (pitem COMMA)* pitem
        ;

pitem:  type ID;

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:
            SEMICOLON               #stm_empty
        |   if_stmt                 #stm_if
        |   while_stmt              #stm_while
        |   expr SEMICOLON          #stm_expr
        |   declaration SEMICOLON   #stm_dec
        |   RETURN expr SEMICOLON   #stm_ret
        ;

if_stmt:
            IF LPAREN expr RPAREN
            stmts
            END
        ;

while_stmt:
            WHILE LPAREN expr RPAREN
            stmts
            END
        ;

declaration:
            type ID (EQUAL expr)?                   #varDecl
        |   type ID (array_dimen)+                  #arrayDecl
        ;

array_dimen:
            LSB NUM RSB;

/******************************************************************************/
/* expressions -                                                              */
/*  1.  the order matters -                                                   */
/*      it is the actual order of precedence. (left-associative)              */
/*  2.  we allow int operation at this moment (todo: other types)             */
/******************************************************************************/
expr:
            LPAREN expr RPAREN              #parenExpr      /* parenthesis */
        |   ID LPAREN func_plist RPAREN     #funcCall       /* function call */
        |   ID (array_access)+              #arrayAccess
        |   ID (member_access)+             #memberVar
        |   expr MULTI_OP    expr           #mult           /* multiplication & division */
        |   expr ADDITIVE_OP expr           #add            /* addition */
        |   expr COMPARE_OP  expr           #compare        /* compare equal */
        |   ID OVERLAY ID AT LPAREN expr COMMA expr RPAREN #overlay   /* @lfred: to fix - lame overlay */
        |   ID AT LPAREN expr COMMA expr RPAREN #atexpr   /* @xiuhan: shortcut overlay at canvas */
        |   ID EQUAL expr                   #assign         /* assignment */
        |   ID (array_access)+ EQUAL expr   #arrayAssign
        |   ID      #var
        |   NUM     #num
        |   STR     #string
        ;

array_access:
            LSB expr RSB;

member_access:
            DOT ID;

func_plist:
                                            #empty_fpis
        |   ( fpitem COMMA )* fpitem        #fpis
        ;

fpitem:
            expr
        ;

type:       'int' | 'float' | 'char' | 'bool' | 'void' | 'string' | 'graph'
        |   GROUP ID
        ;


