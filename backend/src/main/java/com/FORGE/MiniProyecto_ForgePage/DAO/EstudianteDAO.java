package com.FORGE.MiniProyecto_ForgePage.DAO;

import com.FORGE.MiniProyecto_ForgePage.DTO.Estudiante;
import com.FORGE.MiniProyecto_ForgePage.gestorDeConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    private Connection conn;

    public EstudianteDAO() throws SQLException {
        conn = gestorDeConexion.ObtenerConexion();
    }

    public void crearEstudiante(Estudiante estudiante) throws SQLException {
        String sql="INSERT INTO estudiantes(rut,nombres,apellidos,correo,contrasenha,idCurso) values (?,?,?,?,?,?) ";
        PreparedStatement ps= conn.prepareStatement(sql);
        ps.setString(1, estudiante.getRut());
        ps.setString(2, estudiante.getNombres());
        ps.setString(3, estudiante.getApellidos());
        ps.setString(4, estudiante.getCorreo());
        ps.setString(5, estudiante.getContrasenha());
        ps.setString(6, estudiante.getIdCurso());
        ps.executeUpdate();
    }


    public Estudiante obtenerEstudiante(String rut) throws SQLException {
        String sql="select * from estudiantes where rut = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,rut);
        Estudiante temp = null;
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            temp= new Estudiante(rs.getString("rut"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getString("idCurso"));
        }
        return temp;
    }

    public String modificarEstudiante(String rut, Estudiante estudiante) throws SQLException {
        String sql="update estudiantes set rut = ?, nombres = ?, apellidos= ?, correo = ?, idCurso = ? " +
                " where rut = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,estudiante.getRut());
        ps.setString(2,estudiante.getNombres());
        ps.setString(3,estudiante.getApellidos());
        ps.setString(4,estudiante.getCorreo());
        ps.setString(5,estudiante.getIdCurso());
        ps.setString(6,rut);
        ps.executeUpdate();
        return "Modificacion realizada exitosamente";
    }

    public String eliminarEstudiante(String rut) throws SQLException {
        String sql="delete from estudiantes where rut = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,rut);
        ps.executeUpdate();
        return "Estudiante eliminado exitosamente";
    }


    public List<Estudiante> obtenerEstudiantes() throws SQLException {
        String sql="SELECT * from estudiantes";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Estudiante> matricula = new ArrayList<>();
        Estudiante temp = null;
        while(rs.next()){
            temp = new Estudiante(rs.getString("rut"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getString("idCurso"));

            matricula.add(temp);
        }
        return matricula;
    }
}
