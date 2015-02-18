#!/bin/bash
rm *.tokens
rm *.java 
java -cp ../libs/antlr-4.5-complete.jar:./ org.antlr.v4.Tool ./adele.g4
