var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var Fiber = require('fibers');
var extend = require('extend');

var canvas;


server.listen(8888);

app.get('/', function(req, res){
  res.sendFile(__dirname + '/client.html');
});


io.on('connection', function (socket) {
  canvas = new Canvas({
    w: 40,
    h: 30,
    g: 20,
  });
  canvas.init();
  socket.on('keypress', function(data){
    Fiber(keypress).run(data.key);
  });
  Canvas.prototype.draw = function(){
    socket.emit('draw', this.pixel);
    //console.log('draw!',new Date().getTime());
  };
  Fiber(main).run();
});

var clone = function (a) {
   return JSON.parse(JSON.stringify(a));
};

var Pixel = function() {
  this.chr = '';
  this.color = 'red';
  this.backgroundColor = '#FFC';
  this.font = 'Monaco';
};

function initArray(dimens) {
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

function makeStruct(names) {
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
        bg.pixel[i+r][j+c].chr = this.pixel[i][j].chr;
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


// a general log function
var consoleLog = function (str) {
    console.log (str);
};
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

var sleep = function (ms) {
  var fiber = Fiber.current;
  setTimeout(function() {
    fiber.run();
  }, ms);
  Fiber.yield();
};


var draw = function() {
  canvas.draw();
};

var flush = function() {
  canvas.flush();
};

var random = function(max) {
  return Math.floor(Math.random()*max);
};


//target program


map=initArray([25, 40, ]);;
var h = 25;
var w = 40;
var px = 0;
var py = 0;
var count = 0;
var gen_map = function() {
    var i = 1;
    while (i<h) {
        var j = 1;
        while (j<w) {
            map[i][j]=random(2)==1;
            j = j+1;
        }
        i = i+1;
    }
};
var draw_map = function() {
    var ob = str2graph("*");
    var person = str2graph("@");
    var i = 0;
    while (i<h) {
        var j = 0;
        while (j<w) {
            if (map[i][j]) {
                ob.at(i,j);
            }
            j = j+1;
        }
        i = i+1;
    }
    person.at(py,px);
    var c = str2graph(int2str(count));
    c.at(27,10);
    draw();
};
var main = function() {
    gen_map();
    draw_map();
};
var keypress = function(key) {
    if (key==97) {
        px = px-1;
    }
    if (key==100) {
        px = px+1;
    }
    if (key==115) {
        py = py+1;
    }
    if (key==119) {
        py = py-1;
    }
    if (px>=w) {
        px = w-1;
    }
    if (px<0) {
        px = 0;
    }
    if (py>=h) {
        py = h-1;
    }
    if (py<0) {
        py = 0;
    }
    if (map[py][px]) {
        map[py][px]=0;
        count = count+1;
    }
    flush();
    draw_map();
};
/***** End of source codes semantics *****/

