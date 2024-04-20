package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Ronda;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;
import co.com.sofkau.util.CommonOperacion.RondaUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuContinuar {


    public static void continuarJuego(int numRonda) {
        Ronda ronda = new Ronda();

        Scanner scanner = new Scanner(System.in);

        Ronda siguienteRonda = RondaUtils.buscarRondaPorNumRonda(numRonda, ronda.rondaHashMap);

        System.out.println(siguienteRonda);

        if (siguienteRonda.getNumRonda() == numRonda) {

            String premioProximaRonda = siguienteRonda.getPremioConseguir();

            System.out.println("El premio a conseguir en la próxima ronda es: " + premioProximaRonda);

            // Dar opción al usuario de continuar o retirarse
            System.out.println("¿Deseas continuar con el juego o retirarte con los premios acumulados?");
            System.out.println("1. Continuar juego");
            System.out.println("2. Retirarse con premios");
            System.out.print("Ingrese el número de la opción deseada: ");

            int opcion = scanner.nextInt();
            if (opcion == 1) {
                // Continuar juego
                // Llamar a la función que presente la próxima pregunta
                // Por ejemplo: MenuRonda.presentarPregunta(numRonda + 1);
            } else if (opcion == 2) {
                // Retirarse con premios
                // Llamar a la función que muestre el mensaje de retiro y el premio acumulado
                // Por ejemplo: MenuJuegoTerminado.mostrarMensajeRetiro(premioAcumulado);
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 1 para continuar o 2 para retirarse.");
            }
        } else {
            System.out.println("¡Felicidades! Has completado todas las rondas del juego.");
            // Aquí puedes hacer cualquier acción adicional que desees al completar todas las rondas
        }
    }
}
