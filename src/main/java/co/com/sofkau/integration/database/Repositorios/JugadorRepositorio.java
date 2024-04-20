package co.com.sofkau.integration.database.Repositorios;

import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.mysql.MySqlOperation;
import co.com.sofkau.util.CommonOperacion.IngresoQuery;

public class JugadorRepositorio {

    private static MySqlOperation mySqlOperation = ConexionDatabase.getMySqlOperation();

    public static void crearJugador(Jugador jugador) {
        String query = String.format("INSERT INTO jugador (nombreJugador) VALUES ('%s')",
                jugador.getNombreJugador());
        IngresoQuery.ejecutarIngresoQuery(query);
    }
}
