<?php

include("bd.php");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  $exito = false;
  $resultado = array();
  $resultado['exito'] = 0;
  $json = file_get_contents('php://input');

  // Converts it into a PHP object
  $jsonUTF = utf8_encode($json);
  $data = json_decode($jsonUTF,true);


  if (isset($data['usuario']) and isset($data['aciertos']) and isset($data['sin_responder']) and isset($data['errores'])) {
    conectaABaseDeDatos();
    $exito = actualizarEstadisticas($data['usuario'], $data['aciertos'], $data['sin_responder'], $data['errores']);
    desconectaDeBaseDeDatos();

    $resultado['exito'] = 1;
  }

  $myJSON = json_encode($resultado);

  echo $myJSON;
}
?>