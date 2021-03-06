# POMODORO

Reto que corresponde al mes de abril de la serie de deasfios que esta proponiendo Mouredev en su
proyecto de retos de creación mensual de aplicaciones de la comunidad MoureDev en base a requisitos,
llamdado App Monthly Challenge 2022. Requisitos para la app de marzo

POMODORO: Crea un "Pomodoro" configurable que guarde todo tu historial de tareas.

La técnica "pomodoro" es un método para mejorar la administración del tiempo dedicado a una
actividad e incrementar tu productividad.

NOTA: Si se trata de una App Android o Web, agradecería crear un readme con un enlace de descarga o
ejecución de la app. Gracias!

Requisitos:

    - Poseerá un campo de texto para introducir el nombre de la tarea que se está llevando a cabo. 
      Cada vez que se cambia la tarea, el pomodoro comienza de cero. Sólo se puede cambiar la tarea si 
      el pomodoro se detiene completamente (en caso contrario no será editable). El pomodoro no puede iniciarse 
      si no se ha definido una tarea.

    - Deberá implementar botones para iniciar el pomodoro, pausarlo, pararlo y pasar al siguiente ciclo del pomodoro.

    - El pomodoro medirá intervalos formados por 4 bloques de trabajo de 25 minutos con 5 minutos de descanso entre ellos. 
      Cada tres bloques de descanso de 5 minutos, el cuarto bloque será de 15 minutos o 30 minutos (también configurable
      y guardando la selección de forma persistente).

    - Si la aplicación está en segundo plano deberá seguir funcionando. O por lo menos seguir teniendo en cuenta el 
      estado actual del pomodoro.

    - Cada vez que acaba un bloque (de trabajo o de descanso) se notificará al usuario con una alerta (si está en 
      primer plano e incluso con sonido) o con una notificación (si está en segundo plano) que ha finalizado ese
      bloque de tiempo y ha comenzado el siguiente.

    - Se guardará un historial agrupado por día con fecha de inicio y fin del bloque/s de trabajo junto con el texto de 
      la tarea realizada. Tiempo total contando descanso y trabajo. Se guarda cada vez que se detiente el pomodoro. 
      El historial puede estar en una patalla individual. Se mostará primero el registro más reciente.

    - Esta es un tipo de aplicación con la que podemos practicar diseños de UI más elaborados. Intenta 
      hacerla bonita y con animaciones!
      
# Timer Pager
      
![mainscreen](https://user-images.githubusercontent.com/73857138/177652613-c2fd78b9-9925-460b-8ea4-df328bff9305.jpg)
      
      
# Pager History
![pager_log](https://user-images.githubusercontent.com/73857138/177652746-bb1f9887-8fb4-4e26-af94-6f4aa76be76d.jpg)


### Tecnologies: 
 


<p>
<a href="https://kotlinlang.org/" target="_blank">Kotlin</a>
 </p>
 <p>
<a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel" target="_blank">MVVM</a>
 </p>
 <p>
<a href="https://developer.android.com/jetpack/compose?hl=es-419" target="_blank">Jetpack Compose</a>
 </p>
 <p >
<a href="https://dagger.dev/hilt/" target="_blank">Dagger Hilt</a>
 </p>
 <p >
<a href="https://developer.android.com/training/data-storage/room" target="_blank">Room</a>
 </p>
 <p>
<a href="https://developer.android.com/kotlin/coroutines?hl=es-419" target="_blank">Coroutines</a>
 </p>

