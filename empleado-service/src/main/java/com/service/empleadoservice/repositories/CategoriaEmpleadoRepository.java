package com.service.empleadoservice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.empleadoservice.entities.CategoriaEmpleadoEntity;



@Repository
public interface CategoriaEmpleadoRepository extends CrudRepository<CategoriaEmpleadoEntity, Long> {

    @Query(value = "select * from categorias_empleados c where c.id_categoria = :id", nativeQuery = true)
    public CategoriaEmpleadoEntity buscarCategoriaById(@Param("id") Long id);



}
