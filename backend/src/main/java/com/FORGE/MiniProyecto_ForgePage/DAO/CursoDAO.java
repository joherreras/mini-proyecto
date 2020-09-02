package com.FORGE.MiniProyecto_ForgePage.DAO;

import com.FORGE.MiniProyecto_ForgePage.DTO.Curso;
import com.FORGE.MiniProyecto_ForgePage.gestorDeConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection conn;

    public CursoDAO() throws SQLException{
        conn = gestorDeConexion.ObtenerConexion();
    }


    public Curso obtenerCurso(int id) throws SQLException {
    String sql="select * from cursos where id= ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Curso curso = null;
        while(rs.next()) {
            curso = new Curso(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("anho"));
        }
    return curso;
    }

    public List<Curso> obtenerCursos() throws SQLException {
    String sql="select * from cursos";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    Curso temp = null;
    List<Curso> cursos = new ArrayList<>();
    while(rs.next()){
        temp = new Curso(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("anho"));

        cursos.add(temp);
    }
    return cursos;
    }
}
