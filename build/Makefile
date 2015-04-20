BASE=..
BUILD=$(BASE)/build
SRC=$(BASE)/src
LIB=$(BASE)/lib
TEST_DIR=$(BASE)/test_static
GRAMMAR=$(SRC)/grammar

ANTLR=$(LIB)/antlr-4.5-complete.jar
ST=$(LIB)/ST-4.0.8.jar

.PHONY: clean grammar compiler

compiler:
	@echo '------------------------------------------------------------'
	@echo '|             ADELECC Compilation Starts                   |'
	@echo '------------------------------------------------------------'
	@echo '[Phase 1] Compiling grammar'
	@make -C $(GRAMMAR)
	
	@echo '[Phase 2] Compiling ANTLR source codes'
	@javac -cp $(ANTLR):. *.java
	
	@echo '[Phase 3] Compiling compiler source codes' 
	@make -C $(SRC)
	
	@echo '[Phase 4] Running static tests ...'
	@echo '------------------------------------------------------------'
	@echo 'static test results: '
	@cd $(TEST_DIR) && ./run_fail.sh
	@echo '------------------------------------------------------------'
	@echo '|                 Compilation Completed                    |'
	@echo '------------------------------------------------------------'

grammar:
	@make -C $(GRAMMAR)

clean:
	@rm -f *.tokens
	@rm -f *.java
	@rm -f *.class
	@rm -f *.html
	@rm -f *.js

