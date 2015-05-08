
var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var Fiber = require('fibers');
var extend = require('extend');

var canvas;

if (require.main === module) {
  server.listen(8888);

  app.get('/', function(req, res){
    res.sendFile(__dirname + '/semantic.html');
  });


  var visited = false;
  io.on('connection', function (socket) {
    if (!visited) {
      visited = true;
    } else {
      console.log('Multiple connection => server closing');
      process.exit();
    }
    socket.on('disconnect', function(){
      console.log('Client closed => server closing');
      process.exit();
    });
    socket.on('keypress', function(data){
      if (typeof keypress != "undefined")
      Fiber(keypress).run(data.key);
    });
    Canvas.prototype.draw = function(){
      socket.emit('draw', this.pixel);
      //console.log('draw!',new Date().getTime());
    };
    Fiber(main).run();
  });
}


var clone = function (a) {
   return JSON.parse(JSON.stringify(a));
};

var Pixel = function() {
  this.chr = '';
  this.color = 'red';
  this.backgroundColor = '#FFC';
  this.font = 'Monaco';
};

var initArray = function(dimens) {
    nextDimen = [];

    for (var j = dimens.length - 2; j >= 0; j--) {
        curDimen = [];
        var n = parseInt(dimens[j]);
        for (var k = 0; k < n; k++) {
            curDimen.push(extend(true, [], nextDimen));
        }
        nextDimen = curDimen;
    }

    return nextDimen;
}

var makeStruct = function(names) {
  var names = names.split(' ');
  var count = names.length;
  function constructor() {
    for (var i = 0; i < count; i++) {
      if (names[i].indexOf("[") != -1)
      {
          varName = names[i].substring(0, names[i].indexOf("["));
          tmp = names[i].substring(names[i].indexOf("[") + 1, names[i].length - 1);
          dimens = tmp.split("][");

          this[varName] = initArray(dimens);
      }
      else {
          this[names[i]] = null;
      }
    }
  }
  return constructor;
}

var Graph = function(cfg) {
  this.width = cfg.w;
  this.height = cfg.h;
  this.pixel = [];
  for (var i = 0; i < this.height; i++) {
    this.pixel[i] = [];
    for (var j = 0; j < this.width; j++) {
      this.pixel[i][j] = new Pixel();
    }
  }
  this.overlay = function(bg, r, c) {
    for (var i = 0; i <this.height; i++) {
      for (var j = 0; j < this.width; j++) {
        if (i+r>=bg.height || j+c>=bg.width) continue;
        bg.pixel[i+r][j+c] = clone(this.pixel[i][j]);
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
  this.pixel = [];

  this.init = function () {

    for (var i = 0; i < this.height; i++) {
      this.pixel[i] = [];
      for (var j = 0; j < this.width; j++) {
        var p = new Pixel();
        this.pixel[i][j] = p;
      }
    }
  };

  this.flush = function () {
    for (var i = 0; i < this.height; i++) {
      for (var j = 0; j < this.width; j++) {
        this.pixel[i][j] = new Pixel();
      }
    }
  };
};

canvas = new Canvas({
  w: 40,
  h: 30,
  g: 20,
});
canvas.init();

// a general log function
var consoleLog = function (str) {
    console.log (str);
}

//Convert anything to string

var int2str = function(anything) {
  return String(anything);
};

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
      g.pixel[cr][cc].chr = str[i];
      cc++;
    }
  }
  return g;
};

//Horizontally attach graphs
var graph_hattach = function(gl, gr) {
  var width = gl.width + gr.width;
  var height = Math.max(gl.height, gr.height);

  var g = new Graph({w: width, h: height});

  for (var i = 0; i < gl.height; i++) {
    for (var j = 0; j < gl.width; j++) {
      g.pixel[i][j] = clone(gl.pixel[i][j]);
    }
  }

  for (var i = 0; i < gr.height; i++) {
    for (var j = 0; j < gr.width; j++) {
      g.pixel[i][j+gl.width] = clone(gr.pixel[i][j]);
    }
  }

  return g;
};

//Vertically attach graphs
var graph_vattach = function(gu, gd) {
  var width = Math.max(gu.width, gd.width);
  var height = gu.height + gd.height;

  var g = new Graph({w: width, h: height});

  for (var i = 0; i < gu.height; i++) {
    for (var j = 0; j < gu.width; j++) {
      g.pixel[i][j] = clone(gu.pixel[i][j]);
    }
  }

  for (var i = 0; i < gd.height; i++) {
    for (var j = 0; j < gd.width; j++) {
      g.pixel[i+gu.height][j] = clone(gd.pixel[i][j]);
    }
  }

  return g;
};

var sleep = function (ms) {
  var fiber = Fiber.current;
  setTimeout(function() {
    fiber.run();
  }, ms);
  Fiber.yield();
};


/*
var print_str = function(r, c, str) {
  if (r==undefined || c==undefined || str==undefined) {
    r = 0; c = 0; str = "hello world";
  }
  var g = str2graph(str);
  g.at(r, c);
  canvas.draw();
};
*/

var draw = function() {
  canvas.draw();
};

var flush = function() {
  canvas.flush();
};

var random = function(max) {
  return Math.floor(Math.random()*max);
};

exports.canvas = canvas;
exports.Graph = Graph;
exports.str2graph = str2graph;
exports.draw = draw;
exports.clone = clone;

/***** Start of source codes semantics *****/
function __exceptionHandler__ ()  { 
 var __funcTable__ = {}; 
__funcTable__['function double_quote'] = 59;
__funcTable__['function load'] = 0;
__funcTable__['function str2graph'] = 0;
__funcTable__['function draw'] = 0;
__funcTable__['function backslash'] = 43;
__funcTable__['function flush'] = 0;
__funcTable__['function int2str'] = 0;
__funcTable__['function add'] = 4;
__funcTable__['function fsub'] = 26;
__funcTable__['function sub'] = 8;
__funcTable__['function fadd'] = 22;
__funcTable__['function fmul'] = 30;
__funcTable__['function hor_tab'] = 47;
__funcTable__['function mul'] = 12;
__funcTable__['function consoleLog'] = 0;
__funcTable__['function single_quote'] = 51;
__funcTable__['function div'] = 16;
__funcTable__['function fdiv'] = 34;
__funcTable__['function random'] = 0;
__funcTable__['function newline'] = 39;
__funcTable__['function backspace'] = 55;
__funcTable__['function sleep'] = 0;
} 

var add = function(a,b) {
    return a+b;
};
var sub = function(a,b) {
    return a-b;
};
var mul = function(a,b) {
    return ((a*b)|0);
};
var div = function(a,b) {
    return ((a/b)|0);
};
var fadd = function(a,b) {
    return a+b;
};
var fsub = function(a,b) {
    return a-b;
};
var fmul = function(a,b) {
    return a*b;
};
var fdiv = function(a,b) {
    return a/b;
};
var newline = function() {
    return "\n";
};
var backslash = function() {
    return "\\";
};
var hor_tab = function() {
    return "\t";
};
var single_quote = function() {
    return "\'";
};
var backspace = function() {
    return "\b";
};
var double_quote = function() {
    return "\"";
};
/***** End of source codes semantics *****/

exports.add = add;
exports.sub = sub;
exports.mul = mul;
exports.div = div;
exports.fadd = fadd;
exports.fsub = fsub;
exports.fmul = fmul;
exports.fdiv = fdiv;
exports.newline = newline;
exports.backslash = backslash;
exports.hor_tab = hor_tab;
exports.single_quote = single_quote;
exports.backspace = backspace;
exports.double_quote = double_quote;
