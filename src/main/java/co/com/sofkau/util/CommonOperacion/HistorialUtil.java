package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Dialogo.Menu.MenuPrincipal;
import co.com.sofkau.integration.database.Repositorios.HistorialRepositorio;

public class HistorialUtil {
    public static void TerminarSubirHistorial(int premioNumero, String razonTerminoJuego) {
        MenuPrincipal.historialActual.setPuntajeFinal(premioNumero);
        MenuPrincipal.historialActual.setRazonTerminoJuego(razonTerminoJuego);
        HistorialRepositorio.crearHistorial(MenuPrincipal.historialActual);
    }
}
