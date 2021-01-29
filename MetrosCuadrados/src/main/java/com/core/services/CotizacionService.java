package com.core.services;

import com.core.model.CasaDTO;
import com.core.model.CotizacionDTO;
import com.core.model.HabitacionDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CotizacionService {

    public static CotizacionDTO getCotizacion(CasaDTO casa){
        CotizacionDTO cotizacion = new CotizacionDTO();
        List<HabitacionDTO> listaHabitaciones = casa.getHabitaciones();
        Map<String, Double> mtsPorHabitacion = new HashMap<>();
        Double totalMetrosCuadrados  = 0.0;
        Double max = 0.0;
        HabitacionDTO habMax = null;

        for(HabitacionDTO hab : listaHabitaciones){
            Double metrosCuadradosHabitacion = hab.getAncho() * hab.getLargo();
            if(metrosCuadradosHabitacion > max){
                max = metrosCuadradosHabitacion;
                habMax = hab;
            }
            totalMetrosCuadrados += metrosCuadradosHabitacion;
            mtsPorHabitacion.put(hab.getNombre(), metrosCuadradosHabitacion);
        }

        cotizacion.setTotalMetrosCuadrados(totalMetrosCuadrados);
        cotizacion.setPrecioCasa(totalMetrosCuadrados * 800);
        cotizacion.setHabitacionMasGrande(habMax);
        cotizacion.setMetrosCuadradosPorHabitacion(mtsPorHabitacion);

        return cotizacion;
    }
}
