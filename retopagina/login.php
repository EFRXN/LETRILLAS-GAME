<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Datos del formulario
    $nombreUsuario = $_POST['usuario'];
    $password = $_POST['password'];

    // Configuración de conexión a MongoDB
    $mongoConfig = new \MongoDB\Driver\Manager("mongodb://172.17.0.2:27017");

    $hashedPassword = hash('sha256',$password);
    // Filtro para buscar el usuario
    $filtro = [
        'nombre' => $nombreUsuario,
        'contra' => $hashedPassword,
    ];

    // Consultar la colección "Usuarios"
    $consulta = new \MongoDB\Driver\Query($filtro);
    $resultado = $mongoConfig->executeQuery('JuegoOnline.Usuarios', $consulta);

    // Verificar si se encontró un usuario con el nombre y contraseña proporcionados
    $usuarioEncontrado = false;
    foreach ($resultado as $documento) {
        $usuarioEncontrado = true;
        // Realizar acciones adicionales después de iniciar sesión
        // ...
    }

    if ($usuarioEncontrado) {
        include 'datos_usuarios.php';
    } else {
        echo "Nombre de usuario o contraseña incorrectos.";
	    }
}
?>
<br>
<button onclick="window.location.href='login-reto.html'">Volver a iniciar sesion </button>
