var f = require('./math_test.js');

exports.testIntMath = function(test) {
  test.ok(f.add(1,2) == 3, "err: int add");
  test.ok(f.sub(1,2) == -1, "err: int sub");
  test.ok(f.mul(5,6) == 30, "err: int mul");
  test.ok(f.div(5,2) == 2.5, "err: int div");
  test.done();
};



