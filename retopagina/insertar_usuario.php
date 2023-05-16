<?php

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Datos del formulario
    $nombre = $_POST['username'];
    $correo = $_POST['email'];
    $contra = $_POST['password'];

    $hashedPassword = hash('sha256',$contra);
    // Configuración de conexión a MongoDB
    $mongoConfig = new \MongoDB\Driver\Manager("mongodb://172.17.0.2:27017");

    // Crear documento
    $documento = [
        'nombre' => $nombre,
        'correo' => $correo,
        'contra' => $hashedPassword,
    ];

    // Insertar documento en la colección "Usuarios"
    $bulkWrite = new \MongoDB\Driver\BulkWrite;
    $bulkWrite->insert($documento);

    try {
        $resultado = $mongoConfig->executeBulkWrite('JuegoOnline.Usuarios', $bulkWrite);
        echo "Registro insertado correctamente.";
    } catch (\MongoDB\Driver\Exception\Exception $e) {
        echo "Error al insertar el registro: " . $e->getMessage();
    }
}
?>

<button onclick="window.location.href='login-reto.html'">Volver</button>
