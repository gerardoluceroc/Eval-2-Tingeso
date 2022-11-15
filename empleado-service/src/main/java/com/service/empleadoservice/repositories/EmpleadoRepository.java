package com.service.empleadoservice.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.empleadoservice.entities.EmpleadoEntity;


@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {

 

    //Se consulta a la base de datos la cantidad de inasistencias no justificadas que tiene un empleado
    @Query(value = "select count(*) from inasistencias i where i.id_empleado = :valor_id and i.justificativo_aprobado = false", nativeQuery = true)
    int calcularInasistenciasNoJustificadas(@Param("valor_id") Long valor_id);


    //Se consulta a la base de datos por el sueldo fijo mensual de un empleado de acuerdo a su id
    @Query(value = "select c.sueldo_fijo_mensual from categorias_empleados c, empleados e where e.id_categoria = c.id_categoria and e.id_empleado = :id", nativeQuery = true)
    int consultarSueldoFijoMensual(@Param("id") Long id);

    //Se consulta a la base de datos por las horas extras aprobadas realizadas por un empleado
    @Query(value = "select count(*) from horas_extras h, empleados e where h.id_empleado = e.id_empleado and e.id_empleado = :id and h.hora_extra_aprobada = true", nativeQuery = true)
    int consultarCantidadHorasExtras(@Param("id") Long id);

    //Se consulta a la bd por el monto por hora extra de un empleado
    @Query(value = "select c.monto_hora_extra from categorias_empleados c, empleados e where e.id_categoria = c.id_categoria and e.id_empleado = :id" ,nativeQuery = true)
    int consultarMontoHorasExtras(@Param("id") Long id);

    @Query(value = "select * from empleados e where e.rut = :rut",nativeQuery = true)
    EmpleadoEntity getEmpleadoByRut(@Param("rut") String rut);
    
    @Query(value = "SELECT * FROM empleados e WHERE e.id_categoria = :valor_id", nativeQuery = true)
    //@Query(value = "select e from Empleado where e.id_categoria = :valor_id")
    public ArrayList<EmpleadoEntity> buscarEmpleadoPorId(@Param("valor_id") Long valor_id);




}