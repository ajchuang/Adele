var f = require('./semantic_test.js');

// Math
exports.testIntMath = function(test) {
  test.ok(f.add(1,2) == 3, "math: int add");
  test.ok(f.sub(1,2) == -1, "math: int sub");
  test.ok(f.mul(5,6) == 30, "math: int mul");
  test.ok(f.div(5,2) == 2, "math: int div");
  test.done();
};

exports.testFloatMath = function(test) {
  test.ok(f.fadd(1.5,2.0) == 3.5, "math: float add");
  // test.ok(f.fsub(5.1,2.0) == 3.1, "math: float sub");
  test.ok(f.fmul(1.5,2) == 3.0, "math: float mul");
  test.ok(f.fdiv(4.2,2) == 2.1, "math: float div");
  test.done();
};

// Special character
exports.testSpecialChar = function(test) {
  test.ok("str"+f.newline() == "str\n", "special char: newline");
  test.ok("str"+f.backslash() == "str\\", "special char: backslash");
  test.ok("str"+f.hor_tab() == "str\t", "special char: hor_tab");
  test.ok("str"+f.single_quote() == "str\'", "special char: single_quote");
  test.ok("str"+f.backspace() == "str\b", "special char: backspace");
  test.ok("str"+f.double_quote() == "str\"", "special char: double_quote");
  test.done();
}

exports.testIf = function(test) {
  test.ok(f.if_pos_int() == true, "if: evaluate pos int");
  test.ok(f.if_neg_int() == false, "if: evaluate neg int");
  test.done();
}

exports.testWhile = function(test) {
  test.ok(f.while_til_0() == 0, "while");
  test.done();
}

exports.testArray = function(test) {
  test.ok(f.array_access(10) == 10, "array access");
  test.done();
}





