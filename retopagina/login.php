<?php

session_start();

if(isset($_POST["username"]) && isset($_POST["password"])){
    $email = "carmelo@gmail.com";
    $password = "carmelo";
    $username = "carmelo";
    
    // Obtener datos del formulario
    $input_email = $_POST['email'];
    $input_password = $_POST['password'];
    $input_username = $_POST['username'];

    // Validar credenciales
    if($input_email === $email && $input_password === $password && $input_username === $username) {
    
      // Iniciar sesión
        $_SESSION['usuario'] = $username;
        // Redirigir a juegoRETO.php
        header("Location: juegoRETO.php");
        exit();
    } else {
        echo "Credenciales incorrectas";
    }
} else {
    echo "No se han recibido los datos del formulario";
}
?>

