<?php

  include("bd.php");

  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $exito = false;
    $json = file_get_contents('php://input');
    $resultado = array();
    $resultado['exito'] = 0;

    // Converts it into a PHP object
    $data = json_decode($json,true);

    if (isset($data['usuario'])) {
      conectaABaseDeDatos();
      $exito = terminarRuletaActual($data['usuario']);
      desconectaDeBaseDeDatos();  

      $resultado['exito'] = 1;
    }
  }

  $myJSON = json_encode($resultado);

  echo $myJSON;
?>