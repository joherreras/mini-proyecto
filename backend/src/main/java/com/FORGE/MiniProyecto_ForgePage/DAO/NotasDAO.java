package com.FORGE.MiniProyecto_ForgePage.DAO;

import com.FORGE.MiniProyecto_ForgePage.DTO.Notas;
import com.FORGE.MiniProyecto_ForgePage.gestorDeConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotasDAO {
    private Connection conn;

    public NotasDAO() throws SQLException{
        conn = gestorDeConexion.ObtenerConexion();
    }


    public List<Notas> obtenerNotas(String rut) throws SQLException {
        String sql="select * from notas where idEst = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,rut);
        ResultSet rs = ps.executeQuery();
        List<Notas> notasEst = new ArrayList<>();
        Notas temp = null;
        while (rs.next()){
            temp= new Notas(rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("fecha"),
                            rs.getInt("calificacion"),
                            rs.getString("idEst"),
                            rs.getInt("idCurso"));

            notasEst.add(temp);
        }
        return notasEst;
    }
}
