for FILE in fail_*.adele
do
  echo $FILE `sed -n '1p' $FILE`
done
