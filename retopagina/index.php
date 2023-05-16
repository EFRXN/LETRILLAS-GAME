<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/estilos.css">
  <link href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300;400;500;600;700&family=Mulish:ital,wght@0,700;1,400&family=Space+Grotesk:wght@300;400;500;600;700&display=swap" rel="stylesheet">

  
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
    integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
 
 <title>LETRILLAS©</title>
 <link rel="icon" type="image/x-icon" href="multimedia/letra-l.png"> 
</head>
<body>
 
  
<!---------------------------------navbar lateral------------------------------------------->  
  <nav class="navbar-Lateral">
    <button class="btn-developers">Desarrolladores</button>
    <ul class="developers-list">
      <li>Carmelo Mbomio</li>
      <li>Efren Ojeda</li>
      <li>Iker Morales</li>
      <li>Ignacio Herrera</li>
    </ul>
  </nav>
  
<!----------------------navbar------------------------> 
  <nav class="navbar">
    <div class="logo">
      <a href="index.php">
        <span class="green">LE</span><span class="black">TRILLAS©</span>
      </a>
    </div>
    <ul class="nav-links">
      <li><a href="index.php">INICIO</a></li>
      <li><a href="funcionamiento.html">FUNCIONAMIENTO</a></li>
      <li><a href="login-reto.html">LOGIN</a></li>
    </ul>
  </nav>
 <!--------------------------BANNER------------------------------------>

  <div class="banner">
    <video src="multimedia/video.mp4" autoplay loop muted></video>
    <div class="banner-text">
      <h1> <span= class="black"> Bienvenido a</span=>  <spam= class="green" > LETRILLAS© </spam=> </h1>
      <p>Nuestro juego, letras e inspiración.</p>
    </div>
  </div>

<?php
//conexion

$mongodb = new MongoDB\Driver\Manager("mongodb://172.17.0.2:27017");


// Consulta todos los documentos en la colecci

$query = new MongoDB\Driver\Query([], ['sort' => ['puntuacion' => -1]]);

$cursor = $mongodb->executeQuery("JuegoOnline.Estadisticas", $query);


//almacenar resultados en un array
$resultados = [];
$puesto = 1;
foreach ($cursor as $document) {
    $resultados[] = [
        'nombre' => $document->nombre,
        'puntuacion' => $document->puntuacion,
        'tiempo' => $document->tiempo,
        'fecha' => $document->fecha
    ];
}

?>
<div class="table-container">
 
<table>
    <thead>
        <tr>
	    <th>Puesto</th>
            <th>Nombre</th>
            <th>Puntos</th>
            <th>Tiempo Total</th>
            <th>Fecha</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($resultados as $resultado): ?>
        <tr>
	    <td><?php echo $puesto++; ?></td>
            <td><?php echo $resultado['nombre']; ?></td>
            <td><?php echo $resultado['puntuacion']; ?></td>
            <td><?php echo $resultado['tiempo']; ?></td>
            <td><?php echo $resultado['fecha']; ?></td>
        </tr>
        <?php endforeach; ?>
    </tbody>
</table>

</div>



<!---------------------------FOOTHER--------------------------------->

<footer class="footer">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <h3>LETRILLAS©</h3>
        <p>Letras y inspiración.</p>
      </div>
      <div class="col-md-4">
        <h3>Navegación</h3>
        <ul>
          <li><a href="#">Inicio</a></li>
          <li><a href="#">Servicios</a></li>
          <li><a href="#">Contacto</a></li>
        </ul>
      </div>
      <div class="col-md-4">
        <h3>Contacto</h3>
        <ul>
          <li><i class="fas fa-map-marker-alt"></i> 27 Av. Anorga, 20018, Donostia.</li>
          <li><i class="fas fa-phone"></i> 943 22 52 22 </li>
	  <li><i class="fas fa-email"></i> gipsyinformatic@gmail.com </li>
        </ul>
      </div>
    </div>
  </div>
  <div class="credits">
    <p> 2023 LETRILLAS©.</p>
  </div>
</footer>
  <script src="java.js"></script>


<button>
  <div></div>
</button>

</body>
</html>

