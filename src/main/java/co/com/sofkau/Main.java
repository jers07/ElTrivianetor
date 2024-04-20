package co.com.sofkau;


import co.com.sofkau.Modelos.Historial;
import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.Repositorios.HistorialRepositorio;
import co.com.sofkau.integration.database.Repositorios.JugadorRepositorio;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConexionDatabase.openConnection();
        Jugador jugador = new Jugador("Jorge");
        //JugadorRepositorio.crearJugador(jugador);

        Historial historial = new Historial(1, jugador.getNombreJugador(), 1000, "pregunta fallida ronda 1");
        HistorialRepositorio.crearHistorial(historial);

        System.out.println(PreguntasRepositorio.consultarPreguntas());
        System.out.println(RondaRepositorio.consultarRondas());
        ConexionDatabase.closeConnection();

    }
}