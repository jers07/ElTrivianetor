package co.com.sofkau.integration.database;


import co.com.sofkau.integration.database.mysql.MySqlOperation;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDatabase {


    //Instanciar objeto que me permite leer desde archivo .env
    //static Dotenv dotenv = Dotenv.configure().load();

    private static final String server = "localhost";
    private static final String databaseName = "eltrivianeitor3000";
    private static final String user = "root";
    private static final String password = "123456";

    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public ConexionDatabase() {

    }

    public static void openConnection(){
        mySqlOperation.setServer(server);
        mySqlOperation.setDataBaseName(databaseName);
        mySqlOperation.setUser(user);
        mySqlOperation.setPassword(password);
    }

    public static Connection getConnection (){
        return mySqlOperation.getConnection();
    }

    public static MySqlOperation getMySqlOperation(){
        return mySqlOperation;
    }
    public static void closeConnection() throws SQLException {
        mySqlOperation.close();
    }

}

