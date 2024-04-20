package co.com.sofkau;


import co.com.sofkau.Dialogo.Menu.MenuPrincipal;
import co.com.sofkau.Modelos.Historial;
import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.Modelos.Preguntas;
import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.Repositorios.HistorialRepositorio;
import co.com.sofkau.integration.database.Repositorios.JugadorRepositorio;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConexionDatabase.openConnection();
        MenuPrincipal.iniciarJuego();


    }
}