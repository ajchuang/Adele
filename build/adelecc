#set -x
#make clean
#make
#java -cp ../lib/antlr-4.5-complete.jar:. org.antlr.v4.runtime.misc.TestRig adele prog -gui
src=../samples/codes/qsort.adele
dst=./output
suf=.html
jvs=.js

if [ -f "$1" ]; then
	src=$1

    if [ -f "$2" ]; then
        dst=$2
    fi
fi

# clear the output file before compilation
if [ -f "$dst$suf" ]; then
    rm $dst$suf
fi

if [ -f "$dst$jvs" ]; then
    rm $dst$jvs
fi

# do compile
java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:. AdeleRT $src $dst

# open the output file
if [ -f "$dst$suf" ]; then
    open $dst$suf
fi
