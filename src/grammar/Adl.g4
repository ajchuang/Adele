/******************************************************************************/
/* Grammar Name: adele_test                                                   */
/******************************************************************************/
grammar Adl;
import adelelex;

/******************************************************************************/
/* generating matching rules                                                  */
/******************************************************************************/
prog:                                       /* empty programs       */
        |   (
                func                        /* functions            */
        |       (declaration SEMICOLON)     /* declarations         */

            )*
        ;

/* function and its parameters */
/******************************************************************************/
func:   type ID LPAREN RPAREN
        stmts
        END ;

type:   'int' | 'void';

/* statments: if, while, declarations */
/******************************************************************************/
stmts:  stmt* ;
stmt:       expr SEMICOLON
        |   declaration SEMICOLON
        |   RETURN expr SEMICOLON
        ;

declaration:    type ID
            |   type ID EQUAL expr
            ;

/******************************************************************************/
/* expressions -                                                              */
/*  1.  the order matters -                                                   */
/*      it is the actual order of precedence. (left-associative)              */
/*  2.  we allow int operation at this moment (todo: other types)             */
/******************************************************************************/
expr:       ID      EQUAL   expr        #assign
        |   NUM                         #num
        ;
