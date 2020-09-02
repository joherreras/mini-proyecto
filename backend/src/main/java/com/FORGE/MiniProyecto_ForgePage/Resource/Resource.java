package com.FORGE.MiniProyecto_ForgePage.Resource;


import com.FORGE.MiniProyecto_ForgePage.DAO.CursoDAO;
import com.FORGE.MiniProyecto_ForgePage.DAO.EstudianteDAO;
import com.FORGE.MiniProyecto_ForgePage.DAO.NotasDAO;
import com.FORGE.MiniProyecto_ForgePage.DTO.Curso;
import com.FORGE.MiniProyecto_ForgePage.DTO.Estudiante;
import com.FORGE.MiniProyecto_ForgePage.DTO.Notas;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Resource {
    private EstudianteDAO temp = new EstudianteDAO();

    public Resource() throws SQLException {
    }

    //RESORCE DE ESTUDIANTE
    @RequestMapping(method = RequestMethod.POST, value = "/estudiante")
    public void createEstudiante(@RequestBody Estudiante estudiante){
        try{
            this.temp.crearEstudiante(estudiante);
        }catch (SQLServerException x){
            System.out.println(x.toString());
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"EL CORREO Y EXISTE EN LA BDD");
        }catch (SQLException e){
            System.out.println(e.toString());

        }
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/estudiante")
    public String createEmpleado(@RequestBody Estudiante estudiante) throws SQLException {
          String crear = new EstudianteDAO().crearEstudiante(estudiante);

          return "AGREGADO!";
    }*/
    @RequestMapping (method = RequestMethod.GET, value="/estudiantes")
    public List<Estudiante> ObtenerEstudiantes() throws SQLException {
        List<Estudiante> matricula = new EstudianteDAO().obtenerEstudiantes();
        return matricula;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/estudiante/{rut}")
    public Estudiante obtenerEstudiante(@PathVariable("rut") String rut) throws SQLException {
        Estudiante estudiante = new EstudianteDAO().obtenerEstudiante(rut);
        return estudiante;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/estudiante/{rut}")
    public String modificarEmpleado(@PathVariable("rut") String rut, @RequestBody Estudiante estudiante) throws SQLException {
        String modificarEstudiante = new EstudianteDAO().modificarEstudiante(rut, estudiante);
        return modificarEstudiante;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/estudiante/{rut}")
    public String eliminarEstudiante(@PathVariable("rut") String rut) throws SQLException {
        String eliminar = new EstudianteDAO().eliminarEstudiante(rut);
        return eliminar;
    }

   /* @RequestMapping (method = RequestMethod.GET, value ="/estudiantes/correo")
    public List<String> correo() throws SQLException{

    }*/


    //RESOURCE DE NOTAS

    @RequestMapping(method = RequestMethod.GET, value = "/notas/{rut}")
    public List<Notas> obtenerNotasEstudiante(@PathVariable("rut") String rut) throws SQLException {
        List<Notas> notas = new NotasDAO().obtenerNotas(rut);
        return notas;
    }


    //ROSOURCE DE CURSOS

    @RequestMapping (method = RequestMethod.GET, value="/curso/")
    public List<Curso> ObtenerCursos() throws SQLException {
        List<Curso> cursos = new CursoDAO().obtenerCursos();
        return cursos;
    }
    @RequestMapping (method = RequestMethod.GET, value="/curso/{id}")
    public Curso ObtenerCurso(@PathVariable("id") int id ) throws SQLException {
        Curso curso = new CursoDAO().obtenerCurso(id);
        return curso;
    }

}
