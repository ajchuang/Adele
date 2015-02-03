/* declaration part */
    int n_w = 0, n_n = 0, n_l = 0;

word    [A-Za-z]+
num     [1-9]+[0-9]*

%%
{word}  {++n_w;}
{num}   {++n_n;}
\n      {++n_l;}
.       {}
                                                                                        
%%
    int main () {
        yylex ();
        printf ("%d\n", n_w);
        return 0;
    }
