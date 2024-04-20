package co.com.sofkau.integration.database.Repositorios;

import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.Modelos.Ronda;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.mysql.MySqlOperation;
import co.com.sofkau.util.CommonOperacion.IngresoQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class JugadorRepositorio {

    private static MySqlOperation mySqlOperation = ConexionDatabase.getMySqlOperation();

    public static void crearJugador(Jugador jugador) {
        String query = String.format("INSERT INTO jugador (nombreJugador) VALUES ('%s')",
                jugador.getNombreJugador());
        IngresoQuery.ejecutarIngresoQuery(query);
    }

    public static HashMap<Integer, Jugador> consultarJugadores() {
        HashMap<Integer, Jugador> jugadorHashMap = new HashMap<>();
        String query = "SELECT * FROM jugador";

        IngresoQuery.ejecutarConsultaQuery(query);
        ResultSet resultSet = mySqlOperation.getResulset();

        try {
            while (resultSet.next()) {

                int idJugador = resultSet.getInt("idjugador");
                String nombreJugador = resultSet.getString("nombreJugador");

                Jugador jugador = new Jugador(idJugador,nombreJugador);

                jugadorHashMap.put(idJugador, jugador);
            }
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }

        return jugadorHashMap;
    }
}
