package com.paradigmas.tpfinalventas.dominio;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    private static Connection conn = null;
    private static Dotenv dotenv;

    static {
        try {
            dotenv = Dotenv.load(); 
        } catch (Exception e) {
            System.err.println("Advertencia: No se pudo cargar el archivo .env");
        }
    }

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        String URL = null;
        String USER = null;
        String PASS = null;

        try {
            String POSTGRES_HOST = dotenv.get("POSTGRES_HOST");
            String POSTGRES_PORT = dotenv.get("POSTGRES_PORT");
            String POSTGRES_DB = dotenv.get("POSTGRES_DB");
            USER = dotenv.get("POSTGRES_USER");
            PASS = dotenv.get("POSTGRES_PASSWORD");

            URL = "jdbc:postgresql://"+POSTGRES_HOST+":"+POSTGRES_PORT+"/"+POSTGRES_DB;
            
            Class.forName(JDBC_DRIVER);
      
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion exitosa a la base de datos.");

        } catch (SQLException ex) {
            System.err.println("Error al conectar a la DB (URL: " + URL + ", User: " + USER + ")");
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver JDBC no encontrado: " + ex.getMessage());
            throw new ClassCastException(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
   
    public static void cerrar() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}

