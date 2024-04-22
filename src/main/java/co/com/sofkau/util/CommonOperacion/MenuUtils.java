package co.com.sofkau.util.CommonOperacion;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.sofkau.Dialogo.ConstantesDialogo.*;


public class MenuUtils {

    public static String preguntarStringAlUsuario(String mensaje) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(mensaje);
            return scanner.nextLine();
        }catch (Exception e) {
            System.out.println("error debido a " + e);
        }
        return "null";
    }

    public static int preguntarNumeroUsuario(boolean entradaValida, int opcion) {
        Scanner scanner = new Scanner(System.in);
        while (!entradaValida) {
            try {
                System.out.print("Ingresa un número entero: ");
                opcion = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Yo sabia que ibas a testear esto juan c; .");
                scanner.next();
            }
        }
        return opcion;
    }

    public static int textoInteger(String texto) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            String numeroComoTexto = matcher.group();

            return Integer.parseInt(numeroComoTexto);
        } else {

            return 0;
        }
    }

    public static void solicitarInfoJugadorActual() throws SQLException {
        String nombreJugador = MenuUtils.preguntarStringAlUsuario(MSN_INFORMACION_1);
        String correo = MenuUtils.preguntarStringAlUsuario(MSN_INFORMACION_3);
        JugadorUtil.jugadorActual.setNombreJugador(nombreJugador);
        JugadorUtil.jugadorActual.setCorreo(correo);
    }
}
