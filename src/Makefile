BUILD=../build
ANTLR=../lib/antlr-4.5-complete.jar
ST=../lib/ST-4.0.8.jar

.PHONY: compiler define

.DEFAULT: compiler

compiler:
	@javac -cp $(ANTLR):$(ST):$(BUILD) -d $(BUILD) TestAdl.java *Phase.java *Scope.java *Symbol.java

define:
	#@javac -d $(BUILD) AdeleTypeDes.java
	#@javac -cp $(ANTLR):$(BUILD) -d $(BUILD) adeleListenerImpl.java
