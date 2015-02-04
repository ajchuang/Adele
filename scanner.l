%{  
    This is the lex file for Adele.
%}

%{  
    declaration
    1. global variables
    2. shorthand REs
%}
int n_w = 0, n_n = 0, n_l = 0;
word    [A-Za-z]+
num     [1-9]+[0-9]*

%{  
    translation rules
%}
%%
{word}  {++n_w;}
{num}   {++n_n;}
\n      {++n_l;}
.       {}

%{  
    aux functions
%}                                                                                        
%%
    int main (void) {
        yylex ();
        printf ("%d\n", n_w);
        return 0;
    }
