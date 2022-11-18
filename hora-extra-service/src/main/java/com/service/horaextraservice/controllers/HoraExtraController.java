package com.service.horaextraservice.controllers;


import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.horaextraservice.entities.HoraExtraEntity;
import com.service.horaextraservice.services.HoraExtraService;





@Controller
@RequestMapping()
public class HoraExtraController {
    @Autowired
	HoraExtraService horaExtraService;

    //Controlador para recibir una autorización de horas extras e ingresarlas en la base datos
    @RequestMapping(value= "/hora-extra/enviarautorizacion", method = RequestMethod.POST)
    public ResponseEntity<HoraExtraEntity> agregarHoraExtra(@RequestBody HoraExtraEntity horaExtra){

        horaExtraService.saveHoraExtra(horaExtra);
        return ResponseEntity.ok(horaExtra);
        
    }

    @GetMapping("hora-extra/all")
    public ResponseEntity<List<HoraExtraEntity>> obtenerUsuarios(){
        List<HoraExtraEntity> horasExtras = horaExtraService.getAllHoras();
        if (horasExtras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(horasExtras);
    } 

}    
