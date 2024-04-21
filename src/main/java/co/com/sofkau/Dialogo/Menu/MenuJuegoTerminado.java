package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.integration.database.Repositorios.HistorialRepositorio;
import co.com.sofkau.util.CommonOperacion.HistorialUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuJuegoTerminado {

    public static void juegoGanado(int premioNumero, String premioTexto) throws SQLException {
        System.out.println("¡Felicidades! Has completado todas las rondas y has ganado el juego.");
        System.out.println("tu resultado es " + premioNumero + "$ y claro no olvidemos tu flameante " + premioTexto);
        HistorialUtil.TerminarSubirHistorial(premioNumero, "Jugador Ganador");
        mostrarOpciones();
    }



    public static void jugadorRetirado(int premioNumero) throws SQLException {
        System.out.println("Has decidido retirarte y quedarte con tus premios. ¡Gracias por participar!");
        System.out.println("Has decidido el camino de los cobardes");
        System.out.println("tu resultado es " + premioNumero + "$");
        HistorialUtil.TerminarSubirHistorial(premioNumero, "Jugador Retirado");
        mostrarOpciones();
    }

    public static void jugadorPerdio() throws SQLException {
        System.out.println("Lo siento, has perdido todos tus premios al fallar una pregunta.");
        System.out.println("Es mejor haber tenido y perdido que no haber tenido nada ");
        System.out.println("                                                        --Ricardo Arjona");
        HistorialUtil.TerminarSubirHistorial(0, "Jugador Perdio");
        mostrarOpciones();
    }

    private static void mostrarOpciones() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Ir al menú principal");
        System.out.println("2. Cerrar el juego");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                MenuPrincipal.iniciarJuego();
                break;
            case 2:
                System.out.println("Gracias por jugar. ¡Hasta luego!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                mostrarOpciones();
        }
    }
}
