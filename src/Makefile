BUILD=../build
ANTLR=../lib/antlr-4.5-complete.jar
ST=../lib/ST-4.0.8.jar

.PHONY: compiler

compiler:
	@javac -cp $(ANTLR):$(ST):$(BUILD) -d $(BUILD) *.java
