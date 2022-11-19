package com.service.inasistenciaservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.inasistenciaservice.entitites.InasistenciaEntity;
import com.service.inasistenciaservice.services.InansistenciaService;


@Controller
@RequestMapping()
public class InasitenciaController {
    @Autowired
	InansistenciaService inasistenciaService;


    //Controlador para recibir las marcas de ingreso salida e ingresarlas en la base datos
    @RequestMapping(value= "/inasistencia/enviarjustificativo", method = RequestMethod.POST)
    public ResponseEntity<InasistenciaEntity> agregarJustificativo(@RequestBody InasistenciaEntity justificativo){
        inasistenciaService.updateInasistencia(justificativo);
        return ResponseEntity.ok(justificativo);

    }

    @GetMapping("inasistencia/all")
    public ResponseEntity<List<InasistenciaEntity>> obtenerUsuarios(){
        List<InasistenciaEntity> inasistencias = inasistenciaService.getAllInasistencias();
        if (inasistencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(inasistencias);
    } 

}    


    