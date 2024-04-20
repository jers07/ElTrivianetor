package co.com.sofkau.integration.database.Repositorios;

import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.Modelos.Ronda;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.mysql.MySqlOperation;
import co.com.sofkau.util.CommonOperacion.IngresoQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RondaRepositorio {
    private static MySqlOperation mySqlOperation = ConexionDatabase.getMySqlOperation();

    public static HashMap<Integer, Ronda> consultarRondas() {
        HashMap<Integer, Ronda> rondaHashMap = new HashMap<>();
        String query = "SELECT * FROM ronda";

        IngresoQuery.ejecutarConsultaQuery(query);
        ResultSet resultSet = mySqlOperation.getResulset();

        try {
            while (resultSet.next()) {

                int idRonda = resultSet.getInt("idRonda");
                String premioConseguir = resultSet.getString("premioConseguir");
                int numRonda = resultSet.getInt("numRonda");


                Ronda ronda = new Ronda(idRonda,premioConseguir,numRonda);


                rondaHashMap.put(idRonda, ronda);
            }
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }

        return rondaHashMap;
    }
}
