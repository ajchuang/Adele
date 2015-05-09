#!/bin/bash
java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:../build/ AdeleRunTime $1 2>tmp.txt 1>trans_phase_output.txt

err_line=$(grep -n err $1 | cut -d: -f1 | sort -n -u)  # err line number in test file
line_detected=$(grep line tmp.txt| cut -d: -f1 | cut -d" " -f3 | sort -n -u)  # err line number reported
pass=0

if [[ $err_line == $line_detected ]]
then
    pass=1
else
    echo error detected: $line_detected, expected: $err_line
fi

if [[ -n $(grep Exception tmp.txt) ]]
then
    echo ">>" java runtime exception
    pass=0
fi

if [[ $pass -eq 1 ]]
then
    echo pass static test
else
    echo "--------------------"
    cat tmp.txt
fi
