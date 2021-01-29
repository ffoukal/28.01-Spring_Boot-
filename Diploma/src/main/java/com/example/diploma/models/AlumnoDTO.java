package com.example.diploma.models;

import java.util.List;

public class AlumnoDTO {
    private String nombre;
    private List<AsignaturaDTO> asignaturas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AsignaturaDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
