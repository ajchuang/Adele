#set -x
#make clean
#make
#java -cp ../lib/antlr-4.5-complete.jar:. org.antlr.v4.runtime.misc.TestRig adele prog -gui
src=../samples/codes/qsort.adele
dst=./output.html

if [ -f "$1" ]; then
	src=$1

    if [ -f "$2" ]; then
        dst=$2
    fi
fi

java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:. AdeleRT $src $dst

if [ -f $dst ]; then
    open $dst
fi
