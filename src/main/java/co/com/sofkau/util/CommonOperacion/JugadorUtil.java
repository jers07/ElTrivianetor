package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Dialogo.Menu.MenuPrincipal;
import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.integration.database.Repositorios.JugadorRepositorio;

import java.util.HashMap;

public class JugadorUtil {

    public static Jugador jugadorActual = new Jugador();

    public static Jugador buscarJugadorPorCorreo(HashMap<String, Jugador> jugadorHashMap, String correo) {
        return jugadorHashMap.get(correo);
    }

    public static void registrarJugador() {
        JugadorRepositorio.crearJugador(jugadorActual);
    }

    public static void setJugadorActualId() {
        int idJugador = JugadorUtil.buscarJugadorPorCorreo(JugadorRepositorio.consultarJugadores(), jugadorActual.getCorreo()).getIdJugador();
        jugadorActual.setIdJugador(idJugador);
    }

}
