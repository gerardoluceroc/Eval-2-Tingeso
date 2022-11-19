package com.service.inasistenciaservice.repositories;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.inasistenciaservice.entitites.InasistenciaEntity;




@Repository
public interface InasistenciaRepository extends CrudRepository<InasistenciaEntity, Long> {
    

    //Se obtiene una inasistencia de acuerdo al rut de un empleado y la fecha
    @Query(value = "select * from inasistencias i where i.rut_empleado = :rut and i.fecha = :fecha", nativeQuery = true)
    InasistenciaEntity consultarInasistenciaByRutFecha(@Param("rut") String rut, @Param("fecha") String fecha);


}