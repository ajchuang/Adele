BASE=..
BUILD=$(BASE)/build
SRC=$(BASE)/src
LIB=$(BASE)/lib
GRAMMAR=$(SRC)/grammar

ANTLR=$(LIB)/antlr-4.5-complete.jar
ST=$(LIB)/ST-4.0.8.jar

.PHONY: clean grammar compiler

.DEFAULT: compiler

compiler:
	@make -C $(GRAMMAR)
	@make -C $(SRC) define
	@javac -cp $(ANTLR):. adele*.java
	@make -C $(SRC)

grammar:
	@make -C $(GRAMMAR)

clean:
	@rm -f *.tokens
	@rm -f *.java
	@rm -f *.class
