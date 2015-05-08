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
