package com.service.horaextraservice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.horaextraservice.entities.HoraExtraEntity;
import com.service.horaextraservice.repositories.HoraExtraRepository;



@Service
public class HoraExtraService {

    @Autowired
    HoraExtraRepository horaExtraRepository;


    public void saveHoraExtra(HoraExtraEntity horaExtra){
        horaExtraRepository.save(horaExtra);    
    }    

    //Metodo para obtener todos los usuarios en la base de datos
    public ArrayList<HoraExtraEntity> getAllHoras(){

        return ((ArrayList<HoraExtraEntity>) horaExtraRepository.findAll());
    }
}

    

    
