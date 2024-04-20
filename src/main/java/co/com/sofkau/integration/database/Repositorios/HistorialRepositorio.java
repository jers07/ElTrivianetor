package co.com.sofkau.integration.database.Repositorios;

import co.com.sofkau.Modelos.Historial;
import co.com.sofkau.util.CommonOperacion.IngresoQuery;

public class HistorialRepositorio {


    public static void crearHistorial(Historial historial) {
        String query = String.format("INSERT INTO historial (idHistorial, jugador_idJugador, nombreJugador, puntajeFinal, RazonTerminoJuego) VALUES (%d, %d, '%s', %d, '%s')",
                historial.getIdHistorial(),
                historial.getJugadorIdJugador(),
                historial.getNombreJugador(),
                historial.getPuntajeFinal(),
                historial.getRazonTerminoJuego());
        IngresoQuery.ejecutarIngresoQuery(query);
    }
}
