#!/bin/bash
rm *.tokens
rm *.java 
rm *.class

java  -cp ../libs/antlr-4.5-complete.jar:./ org.antlr.v4.Tool ./adele.g4
javac -cp ../libs/antlr-4.5-complete.jar:./  adele*.java