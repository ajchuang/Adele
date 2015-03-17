BUILD=../build
INC=../include
ANTLR=../lib/antlr-4.5-complete.jar
ST=../lib/ST-4.0.8.jar

.PHONY: compiler

.DEFAULT: compiler

compiler:
	@javac -cp $(ANTLR):$(ST):$(INC):$(BUILD) -d $(BUILD) Adele*.java
