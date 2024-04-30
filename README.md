# A Componentes Botones Dinamicos
# AA Descripción
Los 2 componentes "Botón con particulas" y "Botón flecha" son componentes del tipo Java.Swing para que puedas tenerlos en tu paleta de componentes para así agregarlos con facilidad a tu ``Jframe`` o ``JDialog``

### BotónConParticulas:
1. Botón de acción especial: Puedes usar este botón en lugar de un botón estándar para realizar una acción especial en tu interfaz de usuario. Por ejemplo, puedes usarlo para desencadenar una animación de partículas cada vez que se hace clic en él, lo que proporciona retroalimentación visual al usuario sobre la acción realizada.
2. Elemento decorativo: Este botón también puede usarse como un elemento decorativo en tu interfaz de usuario. Por ejemplo, podrías agregarlo como un botón de estilo personalizado en una barra de herramientas o en algún otro lugar de tu aplicación para agregar un toque visual interesante.
3. Indicador de evento: Puedes usar este botón como un indicador visual para eventos específicos. Por ejemplo, podrías activar la animación de partículas cuando ocurra un evento importante en tu aplicación, como recibir un mensaje nuevo o completar una tarea.
4. Botón de efecto especial: Este botón puede ser útil para crear botones con efectos especiales en tu aplicación, por ejemplo, para hacer que ciertos botones tengan una apariencia más dinámica y atractiva.
### BotonFlecha:
1. Botón de navegación: Este botón puede utilizarse como un botón de navegación en una interfaz de usuario, especialmente para retroceder en una secuencia de pasos o páginas.
2. Botón de retorno: Puede servir como un botón de "regresar" en tu aplicación, permitiendo al usuario volver a la pantalla anterior o a una ubicación previa dentro de la aplicación.
3. Control de la interfaz de usuario: Este botón puede utilizarse como un control para realizar acciones específicas dentro de tu aplicación, como volver a una pantalla anterior o deshacer una acción.
4. Botón de animación personalizado: Además de su función principal como botón de navegación, también puede utilizarse como un ejemplo de cómo crear botones con animaciones personalizadas en Java Swing, lo que puede inspirar el diseño de otros elementos de la interfaz de usuario.

## Características 

+ Fácil integración con cualquier componente Swing (JFrame, JDialog).
+ Interfaz de arrastrar y soltar para una fácil manipulación en interfaces gráficas.

## Requisitos
+ JDK 21 o superior
+ IDE con soporte para Swing si se desea visualizar el componente gráficamente (por ejemplo, NetBeans o IntelliJ IDEA).

### API

## BotonConParticulas
### Propiedades configurables:
colorFondo: Color de fondo del botón. (Tipo: java.awt.Color)
### Métodos:
getColorFondo(): Devuelve el color de fondo actual del botón. (Tipo de retorno: java.awt.Color)
setColorFondo(Color color): Establece el color de fondo del botón. (Parámetro: color de tipo java.awt.Color)
### Descripción:
Este botón crea un efecto de partículas al ser clicado. Las partículas son representadas por objetos de la clase Particle, que se mueven aleatoriamente en la pantalla.

## BotonFlecha
### Métodos:
startAnimation(): Inicia la animación de desplazamiento de la flecha. (No hay parámetros ni retorno)
stopAnimation(): Detiene la animación de desplazamiento de la flecha. (No hay parámetros ni retorno)
### Descripción:
Este botón muestra una flecha y, al ser clicado, realiza una animación desplazando la flecha hacia la izquierda. La animación es controlada por un temporizador (Timer) que mueve gradualmente la posición de la flecha.
# Repositorio
## Link del repositorio: https://github.com/ArtoriasKnight9/Botones_Dinamicos_Animados.git 
# AA Funcionamiento
Puedes ver un ejemplo de como funcionan estos componentes en el 
siguiente enalce ----> https://youtu.be/0ew4C4-hZe8
