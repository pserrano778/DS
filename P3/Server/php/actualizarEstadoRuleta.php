<?php

  include("bd.php");

  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $exito = false;
    $resultado = array();
    $json = file_get_contents('php://input');

    // Converts it into a PHP object
    $jsonUTF = utf8_encode($json);
    $data = json_decode($jsonUTF,true);

    if (isset($data['usuario']) and isset($data['ruleta'])) {
      $ruletaJSON = json_encode($data['ruleta']);
      conectaABaseDeDatos();
      $exito = actualizarEstadoRuleta($data['usuario'], $ruletaJSON);
      desconectaDeBaseDeDatos();

      if ($exito){
        $resultado['exito'] = 1;
      }
    }

    if(!$exito) {
      $resultado['exito'] = 0;
    }

    $myJSON = json_encode($resultado);

    echo $myJSON;
  }
?>
