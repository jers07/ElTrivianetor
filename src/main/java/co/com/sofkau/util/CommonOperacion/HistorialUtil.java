package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Dialogo.Menu.MenuPrincipal;
import co.com.sofkau.Modelos.Historial;
import co.com.sofkau.integration.database.Repositorios.HistorialRepositorio;

import java.awt.*;

public class HistorialUtil {

    public static Historial historialActual = new Historial();

    public static void TerminarSubirHistorial(int premioNumero, String razonTerminoJuego) {
        historialActual.setPuntajeFinal(premioNumero);
        historialActual.setRazonTerminoJuego(razonTerminoJuego);
        historialActual.setNombreJugador(JugadorUtil.jugadorActual.getNombreJugador());
        historialActual.setJugadorIdJugador(JugadorUtil.jugadorActual.getIdJugador());
        HistorialRepositorio.crearHistorial(historialActual);
    }
}
