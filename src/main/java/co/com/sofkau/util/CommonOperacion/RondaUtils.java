package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Modelos.Ronda;

import java.util.HashMap;

public class RondaUtils {

    public static int numRonda = 1;
    public static HashMap<Integer, String> dificultadMap = PreguntasUtil.registrarDificultadesDisponibles();
    public static String nivelDificultad = PreguntasUtil.SeleccionarDificultad(RondaUtils.numRonda, RondaUtils.dificultadMap);

    public static Ronda buscarRondaPorNumRonda(int numRonda, HashMap<Integer, Ronda> rondas) {

        for (Ronda ronda : rondas.values()) {
            if (ronda.getNumRonda() == numRonda) {
                return ronda;
            }
        }
        return null;
    }
}
