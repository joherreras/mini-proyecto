package com.FORGE.MiniProyecto_ForgePage.DTO;

public class Notas {

    private int id;
    private String nombre;
    private String fecha;
    private int calificacion;
    private String idEst;
    private int idCurso;

    public Notas(int id, String nombre, String fecha, int calificacion, String idEst, int idCurso) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.idEst = idEst;
        this.idCurso = idCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getIdEst() {
        return idEst;
    }

    public void setIdEst(String idEst) {
        this.idEst = idEst;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String

    toString() {
        return "Notas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", calificacion=" + calificacion +
                ", idEst='" + idEst + '\'' +
                ", idCurso=" + idCurso +
                '}';
    }
}