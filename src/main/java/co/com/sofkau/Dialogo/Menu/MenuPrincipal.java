package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Jugador;
import co.com.sofkau.integration.database.Repositorios.PreguntasRepositorio;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;
import co.com.sofkau.util.CommonOperacion.MenuUtils;
import co.com.sofkau.util.CommonOperacion.PreguntasUtil;

import java.sql.SQLException;
import java.util.Scanner;

import static co.com.sofkau.Dialogo.ConstantesDialogo.*;

public class MenuPrincipal {

    public static Jugador jugadorActual = new Jugador();

    public static void iniciarJuego() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int exit = -1;

        while (exit == -1) {
            System.out.println(MSN_UNO);
            System.out.println(MSN_DOS);
            System.out.println(MSN_PRINCIPAL_2);

            int option = MenuUtils.preguntarNumeroUsuario();

            switch (option) {
                case 1:
                    System.out.print(MSN_INFORMACION_2);
                    jugadorActual.setNombreJugador(MenuUtils.preguntarStringAlUsuario(MSN_INFORMACION_1));

                    System.out.println("Iniciando el juego...");
                    RondaRepositorio.consultarRondas();

                    String respuestaUsuario = "";
                    System.out.println("Tu respuesta fue: " + respuestaUsuario);
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