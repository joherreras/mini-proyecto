package com.FORGE.MiniProyecto_ForgePage.DTO;

public class Curso {

    private int id;
    private String nombre;
    private int anho;

    public Curso(int id, String nombre, int anho) {
        this.id = id;
        this.nombre = nombre;
        this.anho = anho;
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

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anho=" + anho +
                '}';
    }
}

