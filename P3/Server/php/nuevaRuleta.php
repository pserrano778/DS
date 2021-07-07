<?php

  include("bd.php");

  if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $resultado = array();

    conectaABaseDeDatos();
    $resultado = nuevaRuleta();
    desconectaDeBaseDeDatos();

    $myJSON = json_encode($resultado, JSON_FORCE_OBJECT);

    echo ($myJSON);
  }
?>
