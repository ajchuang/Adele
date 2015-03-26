#make
#java -cp ../lib/antlr-4.5-complete.jar:. org.antlr.v4.runtime.misc.TestRig adele prog -gui
#java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:. AdeleRT ../samples/test_simple.adele
java -cp ../lib/antlr-4.5-complete.jar:../lib/ST-4.0.8.jar:. AdeleRT ../samples/codes/sample.adele
#> sample_out.html
# open sample_out.html
