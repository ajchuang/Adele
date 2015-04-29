var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var Fiber = require('fibers');

server.listen(8888);

app.get('/', function(req, res){
  res.sendFile(__dirname + '/client.html');
});


io.on('connection', function (socket) {
  Canvas.prototype.draw = function(){
    socket.emit('draw', this.pixel);
    console.log('draw!',new Date().getTime());
  };
  canvas = new Canvas({
    w: 40,
    h: 30,
    g: 20,
  });
  canvas.init();
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
var drawhist = function(pivot) {
    flush();
    var g = str2graph("#");
    var gp = str2graph("@");
    var i = 0;
    while (i<30) {
        var j = 0;
        while (j<A[i]) {
            if (pivot==i) {
                gp.at(i,j);
            }
            if (pivot!=i) {
                g.at(i,j);
            }
            j = j+1;
        }
        i = i+1;
    }
    draw();
    sleep(120);
};
var qsort = function(left,right) {
    var i = left;
    var j = right;
    var tmp;
    var pivot = A[i];
    while (i<=j) {
        while (A[i]<pivot) {
            i = i+1;
        }
        while (A[j]>pivot) {
            j = j-1;
        }
        if (i<=j) {
            tmp = A[i];
            A[i]=A[j];
            A[j]=tmp;
            i = i+1;
            j = j-1;
        }
    }
    drawhist(pivot);
    if (left<j) {
        qsort(left,j);
    }
    if (right>i) {
        qsort(i,right);
    }
};
var bbsort = function(len) {
    var i = 0;
    while (i<len-1) {
        var j = i+1;
        while (j<len) {
            if (A[i]>A[j]) {
                var tmp = A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
            j = j+1;
            drawhist(j);
        }
        i = i+1;
    }
};
var main = function() {
    draw_str("Qsort demo!");
    sleep(1000);
    var t = 30;
    B=initArray([30, ]);;
    while (t) {
        A[30-t]=random(39)+1;
        B[30-t]=A[30-t];
        t = t-1;
    }
    qsort(0,29);
    draw_str("Done");
    sleep(1000);
    t = 30;
    while (t) {
        A[30-t]=B[30-t];
        t = t-1;
    }
    draw_str("Select Sort demo!");
    sleep(1000);
    bbsort(30);
    draw_str("Done");
};

