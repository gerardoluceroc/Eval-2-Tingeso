package com.service.marcaentradasalidaservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.marcaentradasalidaservice.entities.MarcaIngresoSalidaEntity;
import com.service.marcaentradasalidaservice.services.MarcaIngresoSalidaService;



@Controller
@RequestMapping()
public class MarcaIngresoSalidaController {
    @Autowired
	MarcaIngresoSalidaService marcaIngresoSalidaService;


    //Controlador para recibir las marcas de ingreso salida e ingresarlas en la base datos
    @RequestMapping(value= "/marca-entrada-salida/enviarmarcas", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<MarcaIngresoSalidaEntity>> agregarMarcasIngresoSalida(@RequestBody ArrayList<MarcaIngresoSalidaEntity> marcasIngresoSalida){

        int i=0;
        int cantidadMarcas = marcasIngresoSalida.size();
        //System.out.println("cantidad de marcas es"+cantidadMarcas);
        while(i < cantidadMarcas){

            //System.out.println("Las marcas son:");
            //System.out.println(marcasIngresoSalida.get(i));
            marcaIngresoSalidaService.addMarcaIngresoSalida(marcasIngresoSalida.get(i));
            i=i+1;


        }
        return ResponseEntity.ok(marcasIngresoSalida);
    }



    @GetMapping("marca-ingreso-salida/all")
    public ResponseEntity<List<MarcaIngresoSalidaEntity>> obtenerMarcas(){
        
        List<MarcaIngresoSalidaEntity> marcas = marcaIngresoSalidaService.getAllMarcas();
        return ResponseEntity.ok(marcas);
    } 


    
}