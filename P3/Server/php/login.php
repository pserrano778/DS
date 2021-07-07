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
      $exito = comprobarUsuario($data['usuario'], $data['clave']);
      
      if ($exito){
        $resultado['exito'] = 1; 
        $resultado['hayRuleta'] = poseeRuletaActiva($data['usuario']);
      } 
      desconectaDeBaseDeDatos();
    } 
    if(!$exito) {
      $resultado['exito'] = 0;
    }

    $myJSON = json_encode($resultado);

    echo ($myJSON);
  }
?>