package com.service.marcaentradasalidaservice.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.marcaentradasalidaservice.entities.MarcaIngresoSalidaEntity;
import com.service.marcaentradasalidaservice.repositories.MarcaIngresoSalidaRepository;



@Service
public class MarcaIngresoSalidaService {

    @Autowired
    MarcaIngresoSalidaRepository marcaIngresoSalidaRepository;


    //Metodo para agregar una marca de ingreso-salida a la base de datos
    public MarcaIngresoSalidaEntity addMarcaIngresoSalida(MarcaIngresoSalidaEntity marcaIngresoSalida){
        
        return marcaIngresoSalidaRepository.save(marcaIngresoSalida);

    }

    //metodo para obtener todas las marcas de la base de datos
    public ArrayList<MarcaIngresoSalidaEntity> getAllMarcas(){
        return (ArrayList<MarcaIngresoSalidaEntity>) marcaIngresoSalidaRepository.findAll();
    }    
}
