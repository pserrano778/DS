<?php

  include("bd.php");

  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $exito = false;
    $json = file_get_contents('php://input');

    // Converts it into a PHP object
    $data = json_decode($json,true);

    if (isset($data['usuario'])) {
      conectaABaseDeDatos();
      $ruleta = getRuletaActual($data['usuario']);
      $decode = json_decode($ruleta, true);
      $ruletaCompleta = getRuletaConDefiniciones($decode);
      desconectaDeBaseDeDatos();
    }

    $myJSON = json_encode($ruletaCompleta);

    echo ($myJSON);
  }
