grammar adele;

// generating matching rules
r  : 'main' ID ;                // match keyword hello followed by an identifier


// generating tokens
ID : [a-zA-Z]+[_0-9a-zA-Z]* ;   // match lower-case identifiers
INT: [-]?[1-9]+[0-9]* ;         // integers
WS : [ \t\r\n]+ -> skip ;       // skip spaces, tabs, newlines
