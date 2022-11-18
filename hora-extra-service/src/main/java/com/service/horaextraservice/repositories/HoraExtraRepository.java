package com.service.horaextraservice.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.service.horaextraservice.entities.HoraExtraEntity;



@Repository
public interface HoraExtraRepository extends CrudRepository<HoraExtraEntity, Long> {
    
    //Se obtiene una hora extra de acuerdo al rut de un empleado y la fecha
    @Query(value = "select * from horas_extras h where h.rut_empleado = :rut and h.fecha = :fecha", nativeQuery = true)
    HoraExtraEntity consultarHoraExtraByRutFecha(@Param("rut") String rut, @Param("fecha") String fecha);


}