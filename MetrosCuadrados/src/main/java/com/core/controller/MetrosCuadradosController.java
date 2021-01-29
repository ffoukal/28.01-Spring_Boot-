package com.core.controller;

import com.core.model.CasaDTO;
import com.core.model.CotizacionDTO;
import com.core.services.CotizacionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetrosCuadradosController {

    @PostMapping("/cotizar")
    @ResponseBody
    public CotizacionDTO cotizarCasa(@RequestBody CasaDTO casa){
        return CotizacionService.getCotizacion(casa);
    }
}
