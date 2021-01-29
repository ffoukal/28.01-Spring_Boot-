package com.edad;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class CalculoEdadController {
    
    @GetMapping(path = "/calcularEdad/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return Integer.toString(this.calculateAge(dia, mes, anio));
    }

    @GetMapping (value = "/calcularEdadJSON/{dia}/{mes}/{anio}")
    @ResponseBody
    public AgeDTO getEdadJSON(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

            AgeDTO ageDTO = new AgeDTO();

        try {
            String date = this.lpad(Integer.toString(dia), '0', 2) + "/" + this.lpad(Integer.toString(mes), '0', 2) + "/" + this.lpad(Integer.toString(anio), '0', 4);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            ageDTO.setDate(date);
            Integer edad = this.calculateAge(dia, mes, anio);
            ageDTO.setEdad(edad);
        } catch (Exception e){
            ageDTO.setError(e.getMessage());
        }

        return ageDTO;
    }

    private Integer calculateAge(Integer dia, Integer mes, Integer anio){
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInput = sdf.parse(dia + "/" + mes + "/" + anio);

            Long edad =  ((date.getTime() / 1000 - dateInput.getTime() / 1000) / 31536000);
            if(dateInput.getTime() > date.getTime()) throw new IllegalArgumentException("La fecha ingresada es incorrecta");
            return edad.intValue();

        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *  Pad to the left
     *
     * @param s String to pad
     * @param c character to fill string
     * @param places number of times to repeat the character
     */
    public static String lpad(String s, char c, int places){
        String pad = Character.toString(c).repeat(places - s.length()) + s;
        return pad;
    }
    
}
