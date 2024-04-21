package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.util.CommonOperacion.MenuUtils;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;

import java.sql.SQLException;
import java.util.*;

public class MenuRonda {


    private static int numRonda = 1;
    private static HashMap<Integer, String> dificultadMap = PreguntasUtil.registrarDificultadesDisponibles();


    public static void presentarPregunta(String premioRonda) throws SQLException {

        HashMap<Integer, Preguntas> preguntas = PreguntasRepositorio.consultarPreguntas();
        String nivelDificultad = PreguntasUtil.SeleccionarDificultad(numRonda, dificultadMap);
        Map<String, List<Preguntas>> preguntasFiltradas = PreguntasUtil.filtrarPorDificultad(preguntas, nivelDificultad);


        if (preguntasFiltradas.containsKey(nivelDificultad)) {

            List<Preguntas> preguntasDificultadActual = preguntasFiltradas.get(nivelDificultad);
            Preguntas preguntaSeleccionada = preguntasDificultadActual.get((int) (Math.random() * preguntasDificultadActual.size()));
            List<String> opciones = PreguntasUtil.mezclarOpciones(preguntaSeleccionada);

            System.out.println("Pregunta:");
            System.out.println(preguntaSeleccionada.getTextoPregunta());
            System.out.println("Opciones:");

            PreguntasUtil.imprimirOpciones(opciones);

            int respuestaUsuario = MenuUtils.preguntarNumeroUsuario();
            int premioRondaIntegerSumado = MenuPrincipal.historialActual.getPuntajeFinal() + MenuUtils.textoInteger(premioRonda);
            PreguntasUtil.checarRespuestaCorrectaIncorrecta(respuestaUsuario, preguntaSeleccionada, opciones);

            if (respuestaUsuario == PreguntasUtil.checarRespuestaCorrectaIncorrecta(respuestaUsuario, preguntaSeleccionada, opciones)) {
                System.out.println("¡Respuesta correcta!");
                if (MenuUtils.textoInteger(premioRonda) != 0) {
                    MenuPrincipal.historialActual.setPuntajeFinal(premioRondaIntegerSumado);
                }
                if (numRonda < 5) {
                    numRonda++;
                }
                else {
                    MenuJuegoTerminado.juegoGanado(premioRondaIntegerSumado, premioRonda);
                }
                MenuContinuar.continuarJuego(numRonda);
            } else {
                System.out.println("Respuesta incorrecta. ¡Has perdido!");
                MenuJuegoTerminado.jugadorPerdio();
            }
        }
    }
}