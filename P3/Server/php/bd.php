<?php
  function registrarUsuario($nombre, $pass){
    global $mysqli;
    $exito = false;
    $insertar = $mysqli->prepare("INSERT INTO usuario (nombreUsuario, password) VALUES (?, ?)");

    $passCodificada = password_hash($pass, PASSWORD_DEFAULT);
    $insertar->bind_param("ss",$nombre, $passCodificada);
    $exito = $insertar->execute();

    if ($exito){
      $insertar = $mysqli->prepare("INSERT INTO estadisticas (usuario, ruletasFinalizadas, totalAciertos, totalSinResponder, totalErrores) VALUES (?, '0', '0', '0', '0')");

      $insertar->bind_param("s",$nombre);

      $insertar->execute();
    }
    
    return $exito;
  }

  function comprobarUsuario($nombre, $pass){
    global $mysqli;
    $exito = false;
    $consulta = $mysqli->prepare("SELECT password FROM usuario WHERE nombreUsuario = ?");
    $consulta->bind_param("s", $nombre);
    $consulta->execute();
    $res = $consulta->get_result();

    if ($res->num_rows > 0) {
      if (password_verify($pass, $res->fetch_assoc()['password'])){
        $exito = true;
      }
    }
    return $exito;
  }

  function actualizarEstadoRuleta($usuario, $ruletaJSON){
    global $mysqli;
    $exito = false;
    $update = $mysqli->prepare("UPDATE usuario SET ruleta = ? WHERE usuario.nombreUsuario = ?");
    $update->bind_param("ss", $ruletaJSON, $usuario);

    return $update->execute();
  }

  function getRuletaActual($usuario){
    global $mysqli;
    $consulta = $mysqli->prepare("SELECT ruleta FROM usuario WHERE usuario.nombreUsuario = ?");
    $consulta->bind_param("s", $usuario);
    $consulta->execute();

    $ruleta = $consulta->get_result();

    return ($ruleta->fetch_assoc())['ruleta'];
  }

  function getRuletaConDefiniciones($ruleta){
    global $mysqli;
    $ruletaConDefiniciones = $ruleta;

    foreach ($ruletaConDefiniciones as &$item){
      if(!is_int($item)){
        $consulta = $mysqli->prepare("SELECT definicion FROM palabra WHERE palabra.palabra = ?");
        $consulta->bind_param("s", $item['palabra']);
        $consulta->execute();

        $res= $consulta->get_result();
        $def = $res->fetch_assoc();
        $item['definicion'] = $def['definicion'];
      }
    }

    return $ruletaConDefiniciones;
  }

  function terminarRuletaActual($usuario){
    global $mysqli;
    $consulta = $mysqli->prepare("UPDATE usuario SET ruleta = NULL WHERE usuario.nombreUsuario = ?");
    $consulta->bind_param("s", $usuario);

    return $consulta->execute();
  }

  function actualizarEstadisticas($usuario, $aciertos, $sin_responder, $errores){
    global $mysqli;

    $consulta = $mysqli->prepare("SELECT * FROM estadisticas WHERE estadisticas.usuario = ?");
    $consulta->bind_param("s", $usuario);
    $consulta->execute();

    $res= $consulta->get_result();
    $estadisticasUsuario = $res->fetch_assoc();

    $nuevasRuletasCompletadas = $estadisticasUsuario['ruletasFinalizadas'] + 1;
    $nuevosAciertos = $estadisticasUsuario['totalAciertos'] + $aciertos;
    $nuevosSinResponder = $estadisticasUsuario['totalSinResponder'] + $sin_responder;
    $nuevosErrores = $estadisticasUsuario['totalErrores'] + $errores;

    $actualizar = $mysqli->prepare("UPDATE estadisticas SET ruletasFinalizadas = ?, totalAciertos = ?, totalSinResponder = ?, totalErrores = ? WHERE estadisticas.usuario = ?");
    $actualizar->bind_param("iiiis", $nuevasRuletasCompletadas ,$nuevosAciertos, $nuevosSinResponder, $nuevosErrores, $usuario);
    $actualizar->execute();
  }

  function poseeRuletaActiva($usuario){
    global $mysqli;
    $exito = 0;
    $consulta = $mysqli->prepare("SELECT ruleta FROM usuario WHERE usuario.nombreUsuario = ?");
    $consulta->bind_param("s", $usuario);
    $consulta->execute();

    $ruleta = $consulta->get_result();

    $resultado = $ruleta->fetch_assoc();

    if (!is_null($resultado['ruleta'])){
      $exito = 1;
    }

    return $exito;
  }

  function conectaABaseDeDatos() {
    global $mysqli;
    $mysqli = new mysqli("localhost", "ds_p3", "ds_p3", "ruletapalabras");
    if ($mysqli->connect_errno) {
      echo ("Fallo al conectar: " . $mysqli->connect_error);
    }

    $mysqli->query('SET NAMES utf8');
  }

  function desconectaDeBaseDeDatos() {
    global $mysqli;
    $mysqli->close();
  }

  function nuevaRuleta(){
    global $mysqli;
    $exito = false;

    $a = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'a' ORDER BY RAND() LIMIT 1");
    $b = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'b' ORDER BY RAND() LIMIT 1");
    $c = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'c' ORDER BY RAND() LIMIT 1");
    $d = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'd' ORDER BY RAND() LIMIT 1");
    $e = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'e' ORDER BY RAND() LIMIT 1");
    $f = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'f' ORDER BY RAND() LIMIT 1");
    $g = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'g' ORDER BY RAND() LIMIT 1");
    $h = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'h' ORDER BY RAND() LIMIT 1");
    $i = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'i' ORDER BY RAND() LIMIT 1");
    $j = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'j' ORDER BY RAND() LIMIT 1");
    $l = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'l' ORDER BY RAND() LIMIT 1");
    $m = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'm' ORDER BY RAND() LIMIT 1");
    $n = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'n' ORDER BY RAND() LIMIT 1");
    $ni = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'ni' ORDER BY RAND() LIMIT 1"); //Ñ
    $o = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'o' ORDER BY RAND() LIMIT 1");
    $p = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'p' ORDER BY RAND() LIMIT 1");
    $q = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'q' ORDER BY RAND() LIMIT 1");
    $r = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'r' ORDER BY RAND() LIMIT 1");
    $s = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 's' ORDER BY RAND() LIMIT 1");
    $t = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 't' ORDER BY RAND() LIMIT 1");
    $u = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'u' ORDER BY RAND() LIMIT 1");
    $v = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'v' ORDER BY RAND() LIMIT 1");
    $x = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'x' ORDER BY RAND() LIMIT 1");
    $y = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'y' ORDER BY RAND() LIMIT 1");
    $z = $mysqli->query("SELECT * FROM palabra WHERE palabra.letra = 'z' ORDER BY RAND() LIMIT 1");

    $letraA = $a->fetch_assoc();
    $letraB = $b->fetch_assoc();
    $letraC = $c->fetch_assoc();
    $letraD = $d->fetch_assoc();
    $letraE = $e->fetch_assoc();
    $letraF = $f->fetch_assoc();
    $letraG = $g->fetch_assoc();
    $letraH = $h->fetch_assoc();
    $letraI = $i->fetch_assoc();
    $letraJ = $j->fetch_assoc();
    $letraL = $l->fetch_assoc();
    $letraM = $m->fetch_assoc();
    $letraN = $n->fetch_assoc();
    $letraNI = $ni->fetch_assoc();
    $letraO = $o->fetch_assoc();
    $letraP = $p->fetch_assoc();
    $letraQ = $q->fetch_assoc();
    $letraR = $r->fetch_assoc();
    $letraS = $s->fetch_assoc();
    $letraT = $t->fetch_assoc();
    $letraU = $u->fetch_assoc();
    $letraV = $v->fetch_assoc();
    $letraX = $x->fetch_assoc();
    $letraY = $y->fetch_assoc();
    $letraZ = $z->fetch_assoc();

    $ruleta = array('a' => array('letra' => $letraA['letra'], 'palabra' => $letraA['palabra'], 'definicion' => $letraA['definicion']),
                    'b' => array('letra' => $letraB['letra'], 'palabra' => $letraB['palabra'], 'definicion' => $letraB['definicion']),
                    'c' => array('letra' => $letraC['letra'], 'palabra' => $letraC['palabra'], 'definicion' => $letraC['definicion']),
                    'd' => array('letra' => $letraD['letra'], 'palabra' => $letraD['palabra'], 'definicion' => $letraD['definicion']),
                    'e' => array('letra' => $letraE['letra'], 'palabra' => $letraE['palabra'], 'definicion' => $letraE['definicion']),
                    'f' => array('letra' => $letraF['letra'], 'palabra' => $letraF['palabra'], 'definicion' => $letraF['definicion']),
                    'g' => array('letra' => $letraG['letra'], 'palabra' => $letraG['palabra'], 'definicion' => $letraG['definicion']),
                    'h' => array('letra' => $letraH['letra'], 'palabra' => $letraH['palabra'], 'definicion' => $letraH['definicion']),
                    'i' => array('letra' => $letraI['letra'], 'palabra' => $letraI['palabra'], 'definicion' => $letraI['definicion']),
                    'j' => array('letra' => $letraJ['letra'], 'palabra' => $letraJ['palabra'], 'definicion' => $letraJ['definicion']),
                    'l' => array('letra' => $letraL['letra'], 'palabra' => $letraL['palabra'], 'definicion' => $letraL['definicion']),
                    'm' => array('letra' => $letraM['letra'], 'palabra' => $letraM['palabra'], 'definicion' => $letraM['definicion']),
                    'n' => array('letra' => $letraN['letra'], 'palabra' => $letraN['palabra'], 'definicion' => $letraN['definicion']),
                    'ni' => array('letra' => $letraNI['letra'], 'palabra' => $letraNI['palabra'], 'definicion' => $letraNI['definicion']),
                    'o' => array('letra' => $letraO['letra'], 'palabra' => $letraO['palabra'], 'definicion' => $letraO['definicion']),
                    'p' => array('letra' => $letraP['letra'], 'palabra' => $letraP['palabra'], 'definicion' => $letraP['definicion']),
                    'q' => array('letra' => $letraQ['letra'], 'palabra' => $letraQ['palabra'], 'definicion' => $letraQ['definicion']),
                    'r' => array('letra' => $letraR['letra'], 'palabra' => $letraR['palabra'], 'definicion' => $letraR['definicion']),
                    's' => array('letra' => $letraS['letra'], 'palabra' => $letraS['palabra'], 'definicion' => $letraS['definicion']),
                    't' => array('letra' => $letraT['letra'], 'palabra' => $letraT['palabra'], 'definicion' => $letraT['definicion']),
                    'u' => array('letra' => $letraU['letra'], 'palabra' => $letraU['palabra'], 'definicion' => $letraU['definicion']),
                    'v' => array('letra' => $letraV['letra'], 'palabra' => $letraV['palabra'], 'definicion' => $letraV['definicion']),
                    'x' => array('letra' => $letraX['letra'], 'palabra' => $letraX['palabra'], 'definicion' => $letraX['definicion']),
                    'y' => array('letra' => $letraY['letra'], 'palabra' => $letraY['palabra'], 'definicion' => $letraY['definicion']),
                    'z' => array('letra' => $letraZ['letra'], 'palabra' => $letraZ['palabra'], 'definicion' => $letraZ['definicion']));

    return $ruleta;
  }
?>
