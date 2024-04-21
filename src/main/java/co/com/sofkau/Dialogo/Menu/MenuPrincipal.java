package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Historial;
import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.integration.database.Repositorios.JugadorRepositorio;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;
import co.com.sofkau.util.CommonOperacion.JugadorUtil;
import co.com.sofkau.util.CommonOperacion.MenuUtils;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;

import java.sql.SQLException;
import java.util.Scanner;

import static co.com.sofkau.Dialogo.ConstantesDialogo.*;

public class MenuPrincipal {

    public static Jugador jugadorActual = new Jugador();
    public static Historial historialActual = new Historial();
    public static void iniciarJuego() throws SQLException {

        int exit = -1;

        while (exit == -1) {
            System.out.println(MSN_UNO);
            System.out.println(MSN_DOS);
            System.out.println(MSN_PRINCIPAL_2);

            int option = MenuUtils.preguntarNumeroUsuario();

            switch (option) {
                case 1:
                    System.out.print(MSN_INFORMACION_2);
                    String nombreJugador = MenuUtils.preguntarStringAlUsuario(MSN_INFORMACION_1);
                    String correo = MenuUtils.preguntarStringAlUsuario(MSN_INFORMACION_3);

                    jugadorActual.setNombreJugador(nombreJugador);
                    jugadorActual.setCorreo(correo);
                    JugadorRepositorio.crearJugador(jugadorActual);

                    int idJugador = JugadorUtil.buscarJugadorPorCorreo(JugadorRepositorio.consultarJugadores(), correo).getIdJugador();

                    historialActual.setNombreJugador(nombreJugador);
                    historialActual.setJugadorIdJugador(idJugador);

                    System.out.println("Iniciando el juego...");
                    RondaRepositorio.consultarRondas();

                    String respuestaUsuario = "";
                    System.out.println("Tu respuesta fue: " + respuestaUsuario);
                    MenuContinuar.continuarJuego(1);
                    break;
                case 0:
                    exit = 0;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        }
    }
}