var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var Fiber = require('fibers');

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
    if (data.key==97) {
      person.x = person.x > 0 ? person.x-1:0;
    }
    if (data.key==100) {
      person.x = person.x < canvas.width-1 ? person.x+1:canvas.width-1;
    }
    if (data.key==119) {
      person.y = person.y >0 ? person.y-1:0;
    }
    if (data.key==115) {
      person.y = person.y < canvas.height-1 ? person.y+1:canvas.height-1;
    }
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
            curDimen.push(jQuery.extend(true, [], nextDimen));
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
  this.sleep = function(time) {
    var stop = new Date().getTime();
    while(new Date().getTime() < stop + time) {
        ;
    }
  };

};

var canvas;

// a general log function
var consoleLog = function (str) {
    console.log (str);
}

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


var x = 1;
var flag;
var gengraph = function(fg,bg) {
    fg.overlay(bg,0,0);
    return 0;
};
var scope = function() {
    var x = 2;
    return x;
};
var print_str = function(r,c,s) {
    var g = str2graph(s);
    g.at(r,c);
    draw();
};



A=initArray([30, ]);;
var kl = 30;
var draw_str = function(x) {
    consoleLog("draw_str: "+x);
    var g;
    g = str2graph(x);
    g.at(2,15);
    draw();
};

var person = {x: 0, y: 0, g:str2graph('@')};

var main = function() {
  while(true) {
    flush();
    person.g.at(person.y, person.x);
    draw();
    sleep(100);
  }
};

