#!/bin/bash
pass=0
tot=0

> fail_output.txt  # empty the file

for file in fail_*.adele
do
    > tmp.txt
    echo $file >> fail_output.txt
    java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:../build/ AdeleRunTime $file 2>> tmp.txt 1>> trans_phase_output.txt

    err_line=$(grep -n err $file | cut -d: -f1 | sort -n -u)  # err line number in test file
    line_detected=$(grep ERROR tmp.txt| grep line | cut -d: -f1 | cut -d" " -f3 | sort -n -u)  # err line number reported

    if [[ $err_line == $line_detected ]]
    then
        pass=$((pass+1))
    else
        echo $file: error detected: $line_detected, expected: $err_line
        if [[ -n $(grep Exception tmp.txt) ]]
        then
            echo ">>>" $file: java runtime exception
        fi
        echo "--------------------"
        cat tmp.txt
        echo "===================="
    fi

    cat tmp.txt >> fail_output.txt
    tot=$((tot+1))

    echo -ne 'Processing test No.' $tot\\r
done

echo -e ">>> tests passed: "$pass'/'$tot