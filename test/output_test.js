var clone = function (a) {
   return JSON.parse(JSON.stringify(a));
};

var Pixel = function() {
  this.chr = '';
};

var Graph = function(cfg) {
  this.width = cfg.w;
  this.height = cfg.h;
  this.buffer = [];
  for (var i = 0; i < this.height; i++) {
    this.buffer[i] = [];
    for (var j = 0; j < this.width; j++) {
      this.buffer[i][j] = new Pixel();
    }
  }
  this.overlay = function(bg, r, c) {
    for (var i = 0; i <this.height; i++) {
      for (var j = 0; j < this.width; j++) {
        bg.buffer[i+r][j+c].chr = this.buffer[i][j].chr;
      }
    }
  }
  this.at = function(r,c) {
    this.overlay(canvas, r, c);
  }
};

var Canvas = function(cfg) {
  this.width = cfg.w;
  this.height = cfg.h;
  this.grid = cfg.g;
  this.buffer = [];
  this.screen = [];
  this.init = function () {

    for (var i = 0; i < this.height; i++) {
      this.buffer[i] = [];
      this.screen[i] = [];
      for (var j = 0; j < this.width; j++) {
        var p = new Pixel();
        this.buffer[i][j] = p;
        this.screen[i][j] = clone(p);
      }
    }
    this.draw();
  };
  this.draw = function () {
    for (var i = 0; i < this.height; i++) {
      for (var j = 0; j < this.width; j++) {
        var p = this.buffer[i][j];
        this.screen[i][j] = clone(p);
      }
    }
  };
};

var canvas = new Canvas({
  w: 40,
  h: 30,
  g: 20,
});

canvas.init();


//Convert string to graph
var str2graph = function (str) {
  str = String(str);
  var height = 1;
  var width = 0;
  var cw = 0;
  for (i in str) {
    if (str[i]=="\n") {
      height++;
      if (cw>width) width = cw;
      cw = 0;
    } else {
      cw++;
    }
  }
  if (cw>width) width = cw;

  var g = new Graph({w: width, h: height});
  var cr = 0, cc = 0;
  for (i in str) {
    if (str[i]=="\n") {
      cr++;
      cc = 0;
    } else {
      g.buffer[cr][cc].chr = str[i];
      cc++;
    }
  }
  return g;
};

var draw = function() {
  canvas.draw();
};


var x;
var flag;

var gengraph = function(fg,bg) {
    fg.overlay(bg,0,0);
    return 0;
};
var print_str = function(r,c,s) {
    var g = str2graph(s);
    g.at(r,c);
    draw();
};
var main = function() {
    var x = 10;
    var y = 3;
    print_str(x,y,"Hello World!");
    print_str(20,y,"No kidding");
    if (x) {
        print_str(0,0,"Test if statement");
    }
    while (y) {
        var z = 5;
        print_str(1,z,"Test while statement");
        y = 0;
    }
    var bg = str2graph("Test\nBackground Graph");
    var fg = str2graph("Test Foreground");
    flag = gengraph(fg,bg);
    bg.at(10,x*2+y);
    draw();
};
exports.canvas = canvas;
exports.gengraph = gengraph;
exports.print_str = print_str;
exports.main = main;
exports.Graph = Graph;
exports.str2graph = str2graph;