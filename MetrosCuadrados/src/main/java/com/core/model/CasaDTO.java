package com.core.model;

import java.util.List;

public class CasaDTO {
    private String nombre;
    private String direccion;
    private List<HabitacionDTO> habitaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<HabitacionDTO> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<HabitacionDTO> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
