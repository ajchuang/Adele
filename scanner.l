    /*  
        declaration:
            1. global variables
            2. shorthand REs
    */ 
    int n_w = 0, n_n = 0, n_l = 0;

SPACE   [ \t]
NAME    [_A-Za-z][_A-Za-z0-9]*
INT     [\+?\-?][1-9][0-9]*
COMMENT ^[ \t]*#.*$
    /*
        translation rules
    */
%%
{COMMENT}   {
                printf ("comment: %s\n", yytext);
            }
{NAME}      {
                ++n_w; 
                printf ("word: %s\n", yytext); 
            }
{INT}       {
                ++n_n;
                printf ("num: %s\n", yytext);
            }
\n          {++n_l;}
.           {
                printf ("char: %s\n", yytext);
            }
            
    /*
        aux functions
    */
%%
    int main (void) {
        yylex ();
        printf ("%d\n", n_w);
        return 0;
    }
