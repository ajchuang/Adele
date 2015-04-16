pass=0
tot=0

for FILE in pass_*.adele
do
  java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:../build/ AdeleRT $FILE 2> tmp.txt
  tot=$((tot+1))
  if [[ -z $(grep 'error' tmp.txt) ]] # if no error is reported
  then
    pass=$((pass+1))
  else
    echo $FILE: $(grep 'line' tmp.txt)  # print the error msg
  fi
done

echo "==========="
echo "tests passed:" $pass"/"$tot
