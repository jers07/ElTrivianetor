package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Modelos.Ronda;

import java.util.HashMap;

public class RondaUtils {

    public static Ronda buscarRondaPorNumRonda(int numRonda, HashMap<Integer, Ronda> rondas) {

        for (Ronda ronda : rondas.values()) {
            if (ronda.getNumRonda() == numRonda) {
                return ronda;
            }
        }
        return null;
    }
}
