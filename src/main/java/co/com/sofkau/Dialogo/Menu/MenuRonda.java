package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.util.CommonOperacion.HistorialUtil;
import co.com.sofkau.util.CommonOperacion.MenuUtils;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;
import co.com.sofkau.util.CommonOperacion.RondaUtils;

import java.sql.SQLException;
import java.util.*;

import static co.com.sofkau.Dialogo.ConstantesDialogo.*;

public class MenuRonda {


    public static void presentarPregunta(String premioRonda) throws SQLException {

        Map<String, List<Preguntas>> preguntasFiltradas = PreguntasUtil.filtrarPorDificultad(PreguntasUtil.preguntas, RondaUtils.nivelDificultad);

        if (preguntasFiltradas.containsKey(RondaUtils.nivelDificultad)) {

            List<Preguntas> preguntasDificultadActual = preguntasFiltradas.get(RondaUtils.nivelDificultad);
            Preguntas preguntaSeleccionada = preguntasDificultadActual.get((int) (Math.random() * preguntasDificultadActual.size()));
            List<String> opciones = PreguntasUtil.mezclarOpciones(preguntaSeleccionada);

            System.out.println(MSN_UTIL_1);
            System.out.println(MSN_RONDA_1);
            System.out.println(preguntaSeleccionada.getTextoPregunta());
            System.out.println(MSN_RONDA_2);

            PreguntasUtil.imprimirOpciones(opciones);

            int respuestaUsuario = MenuUtils.preguntarNumeroUsuario(false,0);

            int premioRondaIntegerSumado = HistorialUtil.historialActual.getPuntajeFinal() + MenuUtils.textoInteger(premioRonda);
            PreguntasUtil.checarRespuestaCorrectaIncorrecta(respuestaUsuario, preguntaSeleccionada, opciones);

            if (respuestaUsuario == PreguntasUtil.checarRespuestaCorrectaIncorrecta(respuestaUsuario, preguntaSeleccionada, opciones)) {
                System.out.println(MSN_RONDA_3);
                if (MenuUtils.textoInteger(premioRonda) != 0) {
                    HistorialUtil.historialActual.setPuntajeFinal(premioRondaIntegerSumado);
                }
                if (RondaUtils.numRonda < 5) {
                    RondaUtils.numRonda++;
                }
                else {
                    MenuJuegoTerminado.juegoGanado(premioRondaIntegerSumado, premioRonda);
                }
                MenuContinuar.continuarJuego(RondaUtils.numRonda);
            } else {
                System.out.println(MSN_RONDA_4);
                MenuJuegoTerminado.jugadorPerdio();
            }
        }
    }
}