# Letrillas

¡Bienvenido a Letrillas! El divertido juego de letras donde tendrás que adivinar palabras desordenadas. Cuantos menos fallos cometas, ¡más puntos obtendrás! Además, podrás competir con jugadores de todo el mundo y ver tu posición en el ranking global.

## Descripción del juego

Letrillas es un juego desarrollado en Java utilizando la librería Swing. El jugador deberá registrarse e iniciar sesión desde el juego o la página web para poder jugar. Una vez dentro, se presentarán palabras aleatorias en desorden, y el objetivo será adivinar la palabra correcta. Cuanto menos errores cometas, más puntos obtendrás.

## Base de datos

Para almacenar las estadísticas de los jugadores, utilizamos una base de datos MongoDB. Hemos creado una base de datos en nuestro servidor, el cual está ubicado físicamente en nuestra clase, ya que somos estudiantes de DAW. Todas las estadísticas de los jugadores se guardan en esta base de datos, permitiendo así consultar el ranking global desde el juego.

## Página web oficial

Además del juego, contamos con una página web oficial de Letrillas. En esta página, los jugadores pueden consultar el ranking global y, si han iniciado sesión, también pueden ver sus propias estadísticas de forma individualizada. También es posible registrarse como nuevo jugador desde la página web.

La página web, al igual que la base dedatos, están alojados en nuestro servidor. Hemos utilizado Docker para configurar Apache, PHP y MongoDB en el servidor, garantizando un entorno seguro y confiable para los usuarios.

## Cómo jugar

1. Clona el repositorio de Letrillas desde GitHub en tu dispositivo.
2. Abre el juego y regístrate como nuevo jugador si es tu primera vez, o inicia sesión con tu cuenta existente.
3. Una vez dentro del juego, se te presentarán palabras desordenadas en la pantalla. Tu objetivo es adivinar la palabra correcta.
4. Escribe la palabra en el campo de texto y presiona el botón de confirmación.
5. Si aciertas la palabra, ganarás puntos. Cuanto menos errores cometas, más puntos obtendrás.
6. El tiempo se guarda en las estadísticas, pero en esta versión, no influye en la puntuación.
7. Puedes consultar tu posición en el ranking global desde el juego, así como desde la página web ofilial de Letrillas.

Esperamos que disfrutes de Letrillas y te diviertas al máximo. ¡Buena suerte!
