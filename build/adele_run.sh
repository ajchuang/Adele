#set -x
#make clean
#make
#java -cp ../lib/antlr-4.5-complete.jar:. org.antlr.v4.runtime.misc.TestRig adele prog -gui
src=../samples/codes/sample.adele
if [ -f "$1" ]; then
	src=$1
fi
java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:. AdeleRT $src
open output.html
