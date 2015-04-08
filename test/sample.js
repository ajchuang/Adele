var f = require('./output_test.js');

exports.testInit = function(test) {
  test.ok(f.canvas.width == 40 && f.canvas.height == 30, "Test canvas init w & h");
  test.done();
};


exports.testGraph = function(test) {
  var testcase = [
    { g: f.str2graph("HaHa\ng1"), h: 2, w: 4 }
  , { g: f.str2graph("Another\ng2 test"), h: 2, w: 7}
  , { g: f.str2graph("Final one\nsecond line\nthird line ends"), h:3, w: 15}
  ];
  var flag = true;
  for (tci in testcase) {
    var tc = testcase[tci];
    if (tc.g.width!=tc.w || tc.g.height!=tc.h) {
      flag = false;
      console.log("Test Case "+tci+" Error");
    }
  }

  test.ok(flag, "Test graph");
  test.done();
};

