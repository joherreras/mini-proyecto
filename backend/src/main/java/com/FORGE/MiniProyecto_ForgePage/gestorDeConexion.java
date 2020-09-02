package com.FORGE.MiniProyecto_ForgePage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class gestorDeConexion {
    private static  Connection conexion = null;
    private static String connectionString = "jdbc:sqlserver://localhost:1433; databasename=miniproyecto; " +
            "user=SA; password=<YourStrong@Passw0rd>";
    public static Connection ObtenerConexion() throws SQLException {
        if(conexion ==null){
            conexion = DriverManager.getConnection(connectionString);
        }
        return conexion;
    }
}