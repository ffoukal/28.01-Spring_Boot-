package com.example.diploma.controllers;


import com.example.diploma.models.AlumnoDTO;
import com.example.diploma.models.DiplomaDTO;
import com.example.diploma.services.DiplomaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {

    @PostMapping("/diploma")
    @ResponseBody
    public DiplomaDTO getDiploma(@RequestBody AlumnoDTO alumno){
        return DiplomaService.getDiploma(alumno);
    }
}
