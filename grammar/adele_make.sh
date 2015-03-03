#!/bin/bash
rm *.class

java  -cp ../libs/antlr-4.5-complete.jar:../libs/ST-4.0.8.jar:./  org.antlr.v4.Tool ./adele.g4
javac -cp ../libs/antlr-4.5-complete.jar:../libs/ST-4.0.8.jar:./  adele*.java
javac -cp ../libs/antlr-4.5-complete.jar:../libs/ST-4.0.8.jar:./  Adele*.java
