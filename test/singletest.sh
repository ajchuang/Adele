res=$(../test_static/debug.sh $1.adele)
echo "$res"

if [[ -z $(grep error <<< $res) ]]; then
  java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:../build AdeleRunTime ./$1.adele $1 1> trans_phase_output.txt 2> static_check_output.txt
  node_modules/.bin/nodeunit rt_$1.js
fi

