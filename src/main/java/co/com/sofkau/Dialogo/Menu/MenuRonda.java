package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuRonda {


    private static int dificultadActual = 1; // Inicializar la dificultad actual en 1


    public static void presentarPregunta() {

        HashMap<Integer, Preguntas> preguntas = PreguntasRepositorio.consultarPreguntas();

        String nivelDificultad = String.valueOf(dificultadActual);
        Map<String, List<Preguntas>> preguntasFiltradas = PreguntasUtil.filtrarPorDificultad(preguntas, nivelDificultad);

        // Verificar si hay preguntas disponibles para la dificultad actual
        if (preguntasFiltradas.containsKey(nivelDificultad)) {
            // Seleccionar una pregunta aleatoria de las preguntas filtradas
            List<Preguntas> preguntasDificultadActual = preguntasFiltradas.get(nivelDificultad);
            Preguntas preguntaSeleccionada = preguntasDificultadActual.get((int) (Math.random() * preguntasDificultadActual.size()));

            // Presentar la pregunta al usuario
            System.out.println("Pregunta:");
            System.out.println(preguntaSeleccionada.getTextoPregunta());
            System.out.println("Opciones:");
            System.out.println("1. " + preguntaSeleccionada.getOpcion1());
            System.out.println("2. " + preguntaSeleccionada.getOpcion2());
            System.out.println("3. " + preguntaSeleccionada.getOpcion3());

            // Solicitar al usuario que ingrese su respuesta
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa tu respuesta: ");
            String respuestaUsuario = scanner.nextLine();

            // Verificar si la respuesta del usuario es correcta
            if (respuestaUsuario.equals(preguntaSeleccionada.getOpcionCorrecta())) {
                System.out.println("¡Respuesta correcta!");
                // Incrementar la dificultad actual
                if (dificultadActual < 5) {
                    dificultadActual++;
                }
            } else {
                System.out.println("Respuesta incorrecta. ¡Has perdido!");
                // Llamar a la clase MenuJuegoTerminado
                //MenuJuegoTerminado.mostrarMensajeJuegoTerminado();
            }
        } else {
            System.out.println("No hay preguntas disponibles para la dificultad actual.");
        }
    }
}
