<?php

  include("bd.php");

  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $exito = false;
    $resultado = array();
    $json = file_get_contents('php://input');

    // Converts it into a PHP object
    $data = json_decode($json,true);

    if (isset($data['usuario']) and isset($data['clave'])) {
      conectaABaseDeDatos();
      $exito = registrarUsuario($data['usuario'], $data['clave']);
      desconectaDeBaseDeDatos();  
      if ($exito){
        $resultado['exito'] = 1;
        $resultado['hayRuleta'] = 0;
      }
    } 
    if(!$exito) {
      $resultado['exito'] = 0;
    }

    $myJSON = json_encode($resultado);

    echo ($myJSON);
  }
?>