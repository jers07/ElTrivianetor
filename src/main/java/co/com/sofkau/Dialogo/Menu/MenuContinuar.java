package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.Modelos.Ronda;
import co.com.sofkau.util.CommonOperacion.HistorialUtil;
import co.com.sofkau.util.CommonOperacion.MenuUtils;
import co.com.sofkau.util.CommonOperacion.RondaUtils;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static co.com.sofkau.Dialogo.ConstantesDialogo.*;

public class MenuContinuar {


    public static void continuarJuego(int numRonda) throws SQLException {
        Ronda ronda = new Ronda();
        Ronda siguienteRonda = RondaUtils.buscarRondaPorNumRonda(numRonda, ronda.rondaHashMap);


        if (siguienteRonda.getNumRonda() == numRonda) {

            String premioProximaRonda = siguienteRonda.getPremioConseguir();

            System.out.println(MSN_UTIL_1);
            System.out.println(MSN_UTIL_1);

            System.out.println(MSN_CONTINUAR_2 + premioProximaRonda);

            System.out.println(MSN_CONTINUAR_3);
            System.out.println(MSN_CONTINUAR_4);
            System.out.println(MSN_CONTINUAR_5);

            System.out.println(MSN_UTIL_1);
            System.out.println(MSN_UTIL_1);


            int opcion = MenuUtils.preguntarNumeroUsuario(false, 0);

            if (opcion == 1) {
                MenuRonda.presentarPregunta(premioProximaRonda);

            } else if (opcion == 2) {
                RondaUtils.numRonda = 1;
                MenuJuegoTerminado.jugadorRetirado(HistorialUtil.historialActual.getPuntajeFinal());
            } else {
                System.out.println(MSN_INFORMACION_4);
            }
        }
    }

    private static int PreguntarNumero(boolean entradaValida, int opcion, Scanner scanner) {
        while (!entradaValida) {
            try {
                System.out.print("Ingresa un número entero: ");
                opcion = scanner.nextInt();
                entradaValida = true; // Si no se lanza ninguna excepción, la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número entero válido.");
                scanner.next(); // Limpiar el búfer del escáner para evitar un bucle infinito
            }
        }
        return opcion;
    }
}
