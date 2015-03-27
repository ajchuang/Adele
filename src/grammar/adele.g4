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
            (type ID SEMICOLON)+?
            END
        ;

/* function and its parameters */
/******************************************************************************/
func:
            ( type | GROUP gid=ID ) id=ID LPAREN plist RPAREN
            stmts
            END
        ;

plist:
        |   ( ((type) | (GROUP ID)) ID COMMA )* ( type ID | GROUP ID ID )
        ;

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:
            SEMICOLON
        |   if_stmt
        |   while_stmt
        |   expr SEMICOLON
        |   declaration SEMICOLON
        |   RETURN expr SEMICOLON
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
            GROUP ID ID         #groupDecl
        |   type ID             #varDecl
        |   type ID EQUAL expr  #varDeclAssign
        ;

/******************************************************************************/
/* expressions -                                                              */
/*  1.  the order matters -                                                   */
/*      it is the actual order of precedence. (left-associative)              */
/*  2.  we allow int operation at this moment (todo: other types)             */
/******************************************************************************/
expr:
            LPAREN expr RPAREN              #parenExpr      /* parenthesis */
        |   ID LPAREN func_plist RPAREN     #funcCall       /* function call */
        |   expr MULTI_OP    expr           #mult           /* multiplication & division */
        |   expr ADDITIVE_OP expr           #add            /* addition */
        |   expr COMPARE_OP  expr           #compare        /* compare equal */
        |   ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN #overlay/* @lfred: to fix - lame overlay */
        |   ID EQUAL expr                   #assign         /* assignment */
        |   ID      #var
        |   NUM     #num
        |   STR     #string
        ;

func_plist:
                                            #empty_fpis
        |   ( fpitem COMMA )* fpitem        #fpis
        ;

fpitem:
            expr                          
        ;

type:   'int' | 'float' | 'char' | 'bool' | 'void' | 'string';


