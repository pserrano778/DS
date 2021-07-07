var http = require("http");
var mysql = require('mysql');
var url = require("url");
var fs = require("fs");
var path = require("path");
var socketio = require("socket.io");
var MySQLEvents = require("mysql-events");

var mimeTypes = { "html": "text/html",
 "jpeg": "image/jpeg",
 "jpg": "image/jpeg",
 "png": "image/png",
 "js": "text/javascript",
 "css": "text/css",
 "swf": "application/x-shockwave-flash",
 "ico": "image/x-icon"
};

//Credenciales BD
var con = mysql.createConnection({
  host: "localhost",
  user: "ds_p3",
  password: "ds_p3",
  database: "ruletapalabras"
});

var dsn = {
  host: "localhost",
  user: "ds_p3",
  password: "ds_p3",
};
var mysqlEventWatcher = MySQLEvents(dsn);

var httpServer = http.createServer(function (request, response) {
  var pathname = url.parse(request.url).pathname;
  var ext = path.extname(pathname);
    if(ext){
        if(ext === '.css'){
            response.writeHead(200, {'Content-Type': 'text/css'});
        }
        else if(ext === '.js'){
            response.writeHead(200, {'Content-Type': 'text/javascript'});
        }
        else if(ext === '.ico'){
          //No hacemosnada con el favicon
          response.writeHead(200, {'Content-Type': 'image/x-icon'});
        }

        response.write(fs.readFileSync(__dirname + pathname, 'utf8'));
    }
    else{
          response.writeHead(200, {'Content-Type': 'text/html'});
          response.write(fs.readFileSync('html/principal.html', 'utf8'));
    }
  response.end();
}).listen(8080);

var io = socketio.listen(httpServer);

io.sockets.on('connection', function(client){
  
  //Conectar con la BD
  client.on('usuario', function(user){
      console.log("Connected!");
      var usuario = user;

      //Hacer la consulta
      con.query("SELECT * FROM estadisticas WHERE usuario = ?", [user], function (error, result, fields) {
        if (error) throw error;
        client.emit('obtener', result);
        console.log("Datos enviados");
      });
      //Credenciales BD
      var watcher = mysqlEventWatcher.add(
        'ruletapalabras.estadisticas',
        function (oldRow, newRow, event) {
           //row updated
          if (oldRow !== null && newRow !== null) {
            if (oldRow.fields.usuario == usuario){
            con.query("SELECT * FROM estadisticas WHERE usuario = ?", [usuario], function (error, result, fields) {
              if (error) throw error;
              client.emit('obtener', result);
              });
            } 
          }
        },
      );
  });

});

// Console will print the message
console.log('Server running at http://127.0.0.1:8080/');
