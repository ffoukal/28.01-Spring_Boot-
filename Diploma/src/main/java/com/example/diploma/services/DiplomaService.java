package com.example.diploma.services;

import com.example.diploma.models.AlumnoDTO;
import com.example.diploma.models.DiplomaDTO;

public class DiplomaService {

    public static DiplomaDTO getDiploma(AlumnoDTO alumno){
        DiplomaDTO diploma = new DiplomaDTO();

        Double promedio = alumno.getAsignaturas()
                .stream()
                .mapToDouble(num -> Double.valueOf(num.getNota()))
                .average()
                .orElse(Double.NaN);

        String mensaje = null;

        if(promedio >= 9)  mensaje = "Extendemos nuestras felicitaciones por su excelente desempenio";

        diploma.setAlumno(alumno);
        diploma.setPromedio(promedio);
        diploma.setMensaje(mensaje);

        return diploma;
    }
}
