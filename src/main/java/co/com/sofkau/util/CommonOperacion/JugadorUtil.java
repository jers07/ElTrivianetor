package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Modelos.Jugador;

import java.util.HashMap;

public class JugadorUtil {

    public static Jugador buscarJugadorPorCorreo(HashMap<String, Jugador> jugadorHashMap, String correo) {

        return jugadorHashMap.get(correo);
    }
}
