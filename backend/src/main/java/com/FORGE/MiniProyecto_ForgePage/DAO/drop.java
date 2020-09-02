package com.FORGE.MiniProyecto_ForgePage.DAO;

import com.FORGE.MiniProyecto_ForgePage.gestorDeConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class drop {

    public static void main(String[] args) throws SQLException {

        Connection conn;
        conn = gestorDeConexion.ObtenerConexion();


        String sql = "DROP TABLE cursos";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();


    }
}
