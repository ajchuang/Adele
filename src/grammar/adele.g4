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
            (TYPE ID SEMICOLON)+?
            END
        ;

/* function and its parameters */
/******************************************************************************/
func:   
            ( TYPE | GROUP ID ) ID LPAREN plist RPAREN 
            stmts
            END 
        ;

plist:  
        |   ( ((TYPE) | (GROUP ID)) ID COMMA )* ( TYPE ID | GROUP ID ID ) 
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
            GROUP ID ID
        |   TYPE ID 
        |   TYPE ID EQUAL expr
        ;

/******************************************************************************/
/* expressions -                                                              */
/*  1.  the order matters -                                                   */
/*      it is the actual order of precedence. (left-associative)              */
/*  2.  we allow int operation at this moment (todo: other types)             */
/******************************************************************************/
expr:        
            LPAREN expr RPAREN                      /* parenthesis */
        |   ID LPAREN func_plist RPAREN             /* function call */
        |   expr MULTI_OP    expr                   /* multiplication & division */
        |   expr ADDITIVE_OP expr                   /* addition */
        |   expr COMPARE_OP  expr                   /* compare equal */
        |   ID OVERLAY ID AT LPAREN NUM COMMA NUM RPAREN /* @lfred: to fix - lame overlay */
        |   ID EQUAL expr                           /* assignment */
        |   ID  
        |   NUM
        |   STR
        ; 

func_plist:  
        |   ( fpitem COMMA )* fpitem
        ;

fpitem:     
            expr
        ;


