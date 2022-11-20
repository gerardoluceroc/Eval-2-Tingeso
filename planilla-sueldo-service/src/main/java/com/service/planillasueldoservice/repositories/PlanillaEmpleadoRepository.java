package com.service.planillasueldoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.planillasueldoservice.entities.PlanillaEmpleadoEntity;


@Repository
public interface PlanillaEmpleadoRepository extends CrudRepository<PlanillaEmpleadoEntity, Long> {

    



}