var f = require('../build/output.js');


var cmparr = function(a1, a2) {
  var l1 = a1.length, l2 = a2.length;
  if (l1!=l2) return false;
  for (var i=0; i < l1; i++) {
    if (a1[i]!=a2[i]) return false;
  }
  return true;
};

var copyarr = function(A, Ac) {
  for (var i=0; i<A.length; i++) {
    A[i] = Ac[i];
  }
};

exports.testQsort = function(test) {
  var A = [11, 26, 33, 7, 28, 16, 20, 22, 33, 39, 18, 36, 17, 30, 33, 9, 7, 20, 8, 38, 17, 25, 17, 22, 11, 37, 29, 11, 9, 32];
  //f.A = f.clone(A);
  copyarr(f.A, A);
  f.qsort(0, 29);
  A.sort(function(a,b){return a-b;});
  //console.log(f.A);
  //console.log(A);

  test.ok(cmparr(f.A, A), "qsort error!");
  test.done();
}

exports.testBbsort = function(test) {
  var A = [11, 26, 33, 7, 28, 16, 20, 22, 33, 39, 18, 36, 17, 30, 33, 9, 7, 20, 8, 38, 17, 25, 17, 22, 11, 37, 29, 11, 9, 32];
  copyarr(f.A, A);
  f.bbsort(30);
  A.sort(function(a,b){return a-b;});
  test.ok(cmparr(f.A, A), "qsort error!");
  test.done();
}