var f = require('./output_test.js');

exports.testInit = function(test) {
  test.ok(f.canvas.width == 40 && f.canvas.height == 30, "Test canvas init w & h error");
  test.ok(f.canvas.buffer.length == 30 && f.canvas.buffer[0].length==40, "Test canvas init buffer error");

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

exports.testDraw = function(test) {
  var dn = f.canvas.timeline.length;
  f.draw();
  var f1 = (++dn) == f.canvas.timeline.length;
  var g = f.str2graph("HaHa\ng1");
  g.at(3, 4);
  f.draw();
  var f2 = (++dn) == f.canvas.timeline.length;
  test.ok(f1 && f2, "Test Draw Error, timeline work inproper");
  test.done();
}
