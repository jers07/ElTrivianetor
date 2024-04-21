package co.com.sofkau.util.CommonOperacion;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.sofkau.Dialogo.ConstantesDialogo.MSN_PRINCIPAL_1;


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

    public static int preguntarNumeroUsuario() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MSN_PRINCIPAL_1);
        int option;
        try {
            option = scanner.nextInt();
        } catch (Exception e) {
            option = 0;
            System.out.println("Ingrese un número válido");
            return -1; // Regresar -1 para indicar que se debe volver al menú principal
        }
        return option;
    }

    public static int textoInteger(String texto) {
        // Patrón de expresión regular para buscar un número en la cadena
        Pattern pattern = Pattern.compile("\\d+");

        // Crear un objeto Matcher para buscar coincidencias con el patrón en la cadena
        Matcher matcher = pattern.matcher(texto);

        // Verificar si se encontró un número en la cadena
        if (matcher.find()) {
            // Obtener el número encontrado como una cadena de texto
            String numeroComoTexto = matcher.group();

            // Convertir la cadena de texto a un entero
            return Integer.parseInt(numeroComoTexto);
        } else {
            // En caso de no encontrar un número, retornar 0 o lanzar una excepción según lo requieras
            // Aquí simplemente retornamos 0 como valor por defecto
            return 0;
        }
    }



}
