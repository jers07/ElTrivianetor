package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.integration.database.ConexionDatabase;

import co.com.sofkau.util.CommonOperacion.HistorialUtil;
import co.com.sofkau.util.CommonOperacion.MenuUtils;

import java.sql.SQLException;


import static co.com.sofkau.Dialogo.ConstantesDialogo.*;
import static co.com.sofkau.Dialogo.RazonTerminoJuego.*;

public class MenuJuegoTerminado {

    public static void juegoGanado(int premioNumero, String premioTexto) throws SQLException {
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_FINAL_1);
        System.out.println(MSN_FINAL_2 + premioNumero + MSN_FINAL_3 + premioTexto);
        HistorialUtil.TerminarSubirHistorial(premioNumero, TIPO_UNO.getvalue());
        mostrarOpciones();
    }


    public static void jugadorRetirado(int premioNumero) throws SQLException {
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_FINAL_4);
        System.out.println(MSN_FINAL_5);
        System.out.println(MSN_FINAL_2 + premioNumero + MSN_FINAL_10);
        HistorialUtil.TerminarSubirHistorial(premioNumero, TIPO_DOS.getvalue());
        mostrarOpciones();
    }

    public static void jugadorPerdio() throws SQLException {
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_UTIL_1);
        System.out.println(MSN_FINAL_6);
        System.out.println(MSN_FINAL_7);
        HistorialUtil.TerminarSubirHistorial(0, TIPO_TRES.getvalue());
        mostrarOpciones();
    }

    private static void mostrarOpciones() throws SQLException {

        System.out.println(MSN_FINAL_9);
        System.out.println(MSN_FINAL_8);
        System.out.println(MSN_PRINCIPAL_2);

        int opcion = MenuUtils.preguntarNumeroUsuario(false, -1);
        switch (opcion) {
            case 1:
                MenuPrincipal.iniciarJuego();
                break;
            case 0:
                System.out.println(MSN_PRINCIPAL_3);
                ConexionDatabase.closeConnection();
                System.exit(0);
                break;
            default:
                System.out.println(MSN_INFORMACION_4);
                mostrarOpciones();
        }
    }
}
