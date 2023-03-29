package com.example.reservasfx;

import java.time.LocalDate;

public class Reserva {
    private Aula aula;
    private LocalDate fecha;
    private  String hora;
    private String profesor;

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Reserva(Aula aula, LocalDate fecha, String hora, String profesor) {
        this.aula = aula;
        this.fecha = fecha;
        this.hora = hora;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Información de la resrva:" + "\n" +
                 aula + "\n" +
                " - Fecha: " + fecha + "\n" +
                " - Hora: " + hora + "\n" +
                " - Profesor: " + profesor + "\n";

    }
}
