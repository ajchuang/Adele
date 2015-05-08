var f = require('../build/output.js');


exports.testInit = function(test) {
  test.ok(f.canvas.width == 40 && f.canvas.height == 30, "Test canvas init w & h error");
  test.ok(f.canvas.pixel.length == 30 && f.canvas.pixel[0].length==40, "Test canvas init buffer error");

  test.done();
};


exports.testGraph = function(test) {
  var testcase = [
    { g: f.str2graph("HaHa\ng1"), h: 2, w: 4 }
  , { g: f.str2graph("Another\ng2 test"), h: 2, w: 7}
  , { g: f.str2graph("Final one\nsecond line\nthird line ends"), h:3, w: 15}
  ];
  var flag = true, wrong_case_number;
  for (tci in testcase) {
    var tc = testcase[tci];
    if (tc.g.width!=tc.w || tc.g.height!=tc.h) {
      flag = false;
      wrong_case_number = tci;
      break;
    }
  }

  test.ok(flag, "Test graph Error " + wrong_case_number);
  test.done();
};


exports.testScope = function(test) {
  test.ok(f.scope()==2, "Test scope error");
  test.done();
}

