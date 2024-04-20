package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;


public class PreguntasUtil {

    public static Map<String, List<Preguntas>> filtrarPorDificultad(HashMap<Integer, Preguntas> preguntas, String dificultad) {

        Map<String, List<Preguntas>> preguntasPorDificultad = preguntas.values().stream()
                .filter(pregunta -> pregunta.getNivelDificultad().equals(dificultad))
                .collect(Collectors.groupingBy(Preguntas::getNivelDificultad));

        return preguntasPorDificultad;
    }

    public static void registrarDificultadesDisponibles(HashMap<Integer, Preguntas> preguntas) {
        int orden = 1;

        for (Map.Entry<Integer, Preguntas> entry : preguntas.entrySet()) {
            Preguntas pregunta = entry.getValue();
            String dificultad = pregunta.getNivelDificultad();

            if (Preguntas.dificultadMap.containsValue(dificultad)) {
                Preguntas.dificultadMap.put(orden, dificultad);
                orden++;
            }
        }
    }




}
