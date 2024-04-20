package co.com.sofkau.util.CommonOperacion;

import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;

import java.util.*;
import java.util.stream.Collectors;


public class PreguntasUtil {



    public static Map<String, List<Preguntas>> filtrarPorDificultad(HashMap<Integer, Preguntas> preguntas, String dificultad) {

        Map<String, List<Preguntas>> preguntasPorDificultad = preguntas.values().stream()
                .filter(pregunta -> pregunta.getNivelDificultad().equals(dificultad))
                .collect(Collectors.groupingBy(Preguntas::getNivelDificultad));

        return preguntasPorDificultad;
    }

    public static HashMap<Integer, String> registrarDificultadesDisponibles() {
        HashMap<Integer, String> dificultadMapUtils = new HashMap<>();

        dificultadMapUtils.put(1, "Muy Facil");
        dificultadMapUtils.put(2, "Facil");
        dificultadMapUtils.put(3, "Medio");
        dificultadMapUtils.put(4, "Dificil");
        dificultadMapUtils.put(5, "Muy Dificil");
        return dificultadMapUtils;
    }
    public static String SeleccionarDificultad(int DificultadActual, HashMap<Integer, String> dificultadMap) {
        for (Map.Entry<Integer, String> entry : dificultadMap.entrySet()) {
            if (entry.getKey() == DificultadActual) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static List<String> mezclarOpciones(Preguntas preguntaSeleccionada) {
        List<String> opciones = new ArrayList<>();
        opciones.add(preguntaSeleccionada.getOpcion1());
        opciones.add(preguntaSeleccionada.getOpcion2());
        opciones.add(preguntaSeleccionada.getOpcion3());
        opciones.add(preguntaSeleccionada.getOpcionCorrecta());
        Collections.shuffle(opciones);
        return opciones;
    }

    public static void imprimirOpciones(List<String> opciones) {
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    public static int checarRespuestaCorrectaIncorrecta(int respuestaUsuario, Preguntas preguntaSeleccionada, List<String> opciones) {
        if (respuestaUsuario >= 1 && respuestaUsuario <= 4) {
            String opcionCorrecta = preguntaSeleccionada.getOpcionCorrecta();
            int indiceRespuestaCorrecta = opciones.indexOf(opcionCorrecta) + 1;
            return indiceRespuestaCorrecta;
        }
        return 0;
    }

}
