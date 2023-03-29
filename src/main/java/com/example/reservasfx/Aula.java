package com.example.reservasfx;

public class Aula {

    //Atributos
    private String nombre;
    private int capacidad;
    private String proyector;
    private String ordenador;
    private String observaciones;

    //Getter y setter
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getProyector() {
        return proyector;
    }

    public void setProyector(String proyector) {
        this.proyector = proyector;
    }

    public String getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(String ordenador) {
        this.ordenador = ordenador;
    }

    //Constructores

    public Aula(String nombre, int capacidad, String proyector, String ordenador) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.proyector = proyector;
        this.ordenador = ordenador;
    }

    public Aula(String nombre, int capacidad, String proyector, String ordenador, String observaciones) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.proyector = proyector;
        this.ordenador = ordenador;
        this.observaciones = observaciones;
    }
    //Metodo toString()

    @Override
    public String toString() {
        return "El " +
                 nombre + " tiene capacidad para " +
                 capacidad + " alumnos, y dispone de: \n" +
                " - Proyector: " + proyector + '\n' +
                " - Ordenador: " + ordenador + "\n" +
                " - Observaciones: " + observaciones;

    }
}
