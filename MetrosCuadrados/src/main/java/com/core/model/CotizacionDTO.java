package com.core.model;

import java.util.Map;

public class CotizacionDTO {
    private Double totalMetrosCuadrados;
    private Double precioCasa;
    private HabitacionDTO habitacionMasGrande;
    private Map<String, Double> metrosCuadradosPorHabitacion;


    public Double getTotalMetrosCuadrados() {
        return totalMetrosCuadrados;
    }

    public void setTotalMetrosCuadrados(Double totalMetrosCuadrados) {
        this.totalMetrosCuadrados = totalMetrosCuadrados;
    }

    public Double getPrecioCasa() {
        return precioCasa;
    }

    public void setPrecioCasa(Double precioCasa) {
        this.precioCasa = precioCasa;
    }

    public HabitacionDTO getHabitacionMasGrande() {
        return habitacionMasGrande;
    }

    public void setHabitacionMasGrande(HabitacionDTO habitacionMasGrande) {
        this.habitacionMasGrande = habitacionMasGrande;
    }

    public Map<String, Double> getMetrosCuadradosPorHabitacion() {
        return metrosCuadradosPorHabitacion;
    }

    public void setMetrosCuadradosPorHabitacion(Map<String, Double> metrosCuadradosPorHabitacion) {
        this.metrosCuadradosPorHabitacion = metrosCuadradosPorHabitacion;
    }
}
