package starlight;

import javazoom.jl.decoder.JavaLayerException; // Importar la excepción específica de JavaLayer
import javazoom.jl.player.advanced.AdvancedPlayer; // Importar la clase AdvancedPlayer de JavaLayer
import javazoom.jl.player.advanced.PlaybackEvent; // Importa lar clase PlaybackEvent de JavaLayer
import javazoom.jl.player.advanced.PlaybackListener; // Importar la clase PlaybackListener de JavaLayer

import java.io.FileInputStream; // Importar la clase FileInputStream para leer archivos
import java.io.FileNotFoundException; // Importar la excepción para manejar archivos no encontrados
import java.io.InputStream; // Importar la clase InputStream

public class ReproducirMusica {

    private String rutaArchivo; // guardar la ruta del archivo MP3
    private AdvancedPlayer reproductor; //variable para reproducir el archivo MP3
    private Thread hiloReproductor; // Hilo para manejar la reproducción en segundo plano
    private boolean enBucle = true; // variable para colocar la musica en bucle
    private boolean isRunning = false; // Variable booleana para verificar si la canción está en ejecución

    public ReproducirMusica(String rutaArchivo) { // Constructor que toma la ruta del archivo MP3
        this.rutaArchivo = rutaArchivo; // Asigna la ruta del archivo a la variable de instancia
    }

    public void iniciar() { // Método para iniciar la reproducción
        isRunning = true;
        hiloReproductor = new Thread(() -> { // nuevo hilo para la reproducción
            while (enBucle) { //Se va a ejecutar cuando el bucle sea true (variable bolleana)
                InputStream is = null; // variable InputStream
                try {
                    is = new FileInputStream(rutaArchivo); // Inicializar el InputStream con la ruta del archivo
                    reproductor = new AdvancedPlayer(is); // Inicializar el AdvancedPlayer con el InputStream
                    reproductor.setPlayBackListener(new PlaybackListener() { // Establecer un PlaybackListener
                        @Override
                        public void playbackFinished(PlaybackEvent evt) { // Método que se llama cuando la reproducción termina
                            //Este override por el momento no nos va a servir de nada
                        }
                    });
                    reproductor.play(); // Inicia la reproducción del archivo de música
                } catch (FileNotFoundException | JavaLayerException e) { // Captura excepciones si ocurren
                    e.printStackTrace(); // Imprimir la traza del error
                    enBucle = false; // Salir del bucle si hay un error
                    isRunning = false;
                } finally {
                    if (is != null) { // Si el InputStream no es nulo va a ejecutar la opcion de cerrar
                        try {
                            is.close(); // Cerrar el InputStream
                        } catch (Exception e) { // capturar cualquier excepción al cerrar el InputStream
                            e.printStackTrace(); // Imprimir la traza del error
                        }
                    }
                }
            }
        });
        hiloReproductor.start(); // Iniciar el hilo de reproducción
    }

    public void detener() { // Método para detener la reproducción
        enBucle = false; // Esto detiene el bucle de reproducción
        if (reproductor != null) { // Si el reproductor no es nulo va a ejecutar el cierre
            reproductor.close(); // Cerrar el reproductor
            hiloReproductor.interrupt(); // Interrumpir el hilo de reproducción para que se termine la músicca
        }
        isRunning = false; // Actualizar la variable isRunning a false cuando la canción se detiene
    }

    public boolean isRunning() {
        return isRunning;
    }

}
