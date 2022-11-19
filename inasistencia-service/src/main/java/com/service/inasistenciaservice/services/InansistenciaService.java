package com.service.inasistenciaservice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.inasistenciaservice.entitites.InasistenciaEntity;
import com.service.inasistenciaservice.repositories.InasistenciaRepository;

@Service
public class InansistenciaService {
    @Autowired
    InasistenciaRepository inasistenciaRepository; 


    //Metodo para guardar una inasistencia
    public void saveInasistencia(InasistenciaEntity inasistencia){

        inasistenciaRepository.save(inasistencia);
    }

    //Metodo para actualizar una inasistencia, ingresando el justificativo, osea se cambian
    //lo valores de los atributos "justificativoAprobado" y "motivoInasistencia"
    public void updateInasistencia (InasistenciaEntity inasistenciaActualizada){

        InasistenciaEntity inasistenciaOriginal = inasistenciaRepository.consultarInasistenciaByRutFecha(inasistenciaActualizada.getRutEmpleado(),inasistenciaActualizada.getFecha());

        //Se copian los valores de la inasistencia original a la nueva que será la versión actualizada
        inasistenciaActualizada.setId_inasistencia(inasistenciaOriginal.getId_inasistencia());
        inasistenciaActualizada.setJustificativoAprobado(true);
        //se actualiza el registro
        inasistenciaRepository.save(inasistenciaActualizada);

    }//fin updateInasistencia

    //Metodo para obtener todas las inasistencias
    public ArrayList<InasistenciaEntity> getAllInasistencias(){

        return (ArrayList<InasistenciaEntity>) inasistenciaRepository.findAll();
    }


    


    




    




  
}