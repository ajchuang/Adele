%{ 
    int n_w = 0, n_n = 0, n_l = 0;
    
    /* definitions of manifest constants */
    #define IF      1
    #define ELSE    2
%}

ADD         [\+]
SUB         [-]
MUL         [\*]
DIV         [\/]
OVERLAY     [\/\/]
AT          [@]

WS          [ \t]
DELIM       {WS}+
NAME        [_A-Za-z][_A-Za-z0-9]*
INT         [\+\-]?[1-9][0-9]*
COMMENT     ^[ \t]*#.*
    /*
        translation rules
    */
%%
{WS}        { }
{COMMENT}   {
                printf ("comment: %s @ ln %d\n", yytext, n_l);
            }
if          {   printf ("if @ ln %d\n", n_l); /* return (IF); */    }
else        {   printf ("if @ ln %d\n", n_l); /* return (ELSE); */  } 
{NAME}      {
                ++n_w; 
                printf ("word: %s @ ln %d\n", yytext, n_l); 
            }
{INT}       {
                ++n_n;
                printf ("int: %s @ ln %d\n", yytext, n_l);
            }
\n          { ++n_l; }
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
