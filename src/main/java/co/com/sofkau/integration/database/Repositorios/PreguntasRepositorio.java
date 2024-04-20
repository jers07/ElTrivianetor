package co.com.sofkau.integration.database.Repositorios;

import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.mysql.MySqlOperation;
import co.com.sofkau.util.CommonOperacion.IngresoQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PreguntasRepositorio {

    private static MySqlOperation mySqlOperation = ConexionDatabase.getMySqlOperation();

    public static HashMap<Integer, Preguntas> consultarPreguntas() {
        HashMap<Integer, Preguntas> preguntasHashMap = new HashMap<>();
        String query = "SELECT * FROM pregunta";

        IngresoQuery.ejecutarConsultaQuery(query);
        ResultSet resultSet = mySqlOperation.getResulset();

        try {
            while (resultSet.next()) {

                int idPregunta = resultSet.getInt("idPregunta");
                String nivelDificultad = resultSet.getString("nivelDificultad");
                String categoria = resultSet.getString("categoria");
                String textoPregunta = resultSet.getString("textoPregunta");
                int valorPuntos = resultSet.getInt("valorPuntos");
                String opcion1 = resultSet.getString("opcion1");
                String opcion2 = resultSet.getString("opcion2");
                String opcion3 = resultSet.getString("opcion3");
                String opcionCorrecta = resultSet.getString("opcionCorrecta");

                Preguntas pregunta = new Preguntas(idPregunta,nivelDificultad,categoria,textoPregunta,valorPuntos,opcion1,opcion2,opcion3,opcionCorrecta);


                preguntasHashMap.put(idPregunta, pregunta); // Utilizamos el título como clave del mapa
            }
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }

        return preguntasHashMap;
    }


}
