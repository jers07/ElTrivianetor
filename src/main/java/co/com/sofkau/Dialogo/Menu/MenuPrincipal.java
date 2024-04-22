package co.com.sofkau.Dialogo.Menu;

import co.com.sofkau.integration.database.ConexionDatabase;
import co.com.sofkau.integration.database.Repositorios.RondaRepositorio;
import co.com.sofkau.util.CommonOperacion.JugadorUtil;
import co.com.sofkau.util.CommonOperacion.MenuUtils;


import java.sql.SQLException;


import static co.com.sofkau.Dialogo.ConstantesDialogo.*;

public class MenuPrincipal {


    public static void iniciarJuego() throws SQLException {
        ConexionDatabase.openConnection();

        int exit = -1;
        Boolean entadaValida = false;

        while (exit == -1) {
            System.out.println(MSN_UNO);
            System.out.println(MSN_DOS);
            System.out.println(MSN_PRINCIPAL_2);

            int option = MenuUtils.preguntarNumeroUsuario(entadaValida, exit);

            switch (option) {
                case 1:
                    System.out.print(MSN_INFORMACION_2);

                    MenuUtils.solicitarInfoJugadorActual();
                    JugadorUtil.registrarJugador();
                    JugadorUtil.setJugadorActualId();

                    System.out.println(MSN_TRES);
                    RondaRepositorio.consultarRondas();

                    MenuContinuar.continuarJuego(1);
                    break;
                case 0:
                    exit = 0;
                    System.out.println(MSN_PRINCIPAL_3);
                    ConexionDatabase.closeConnection();
                    break;
                default:
                    System.out.println(MSN_INFORMACION_4);
            }
        }
    }
}