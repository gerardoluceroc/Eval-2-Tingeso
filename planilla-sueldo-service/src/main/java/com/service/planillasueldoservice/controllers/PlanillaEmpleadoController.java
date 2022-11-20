package com.service.planillasueldoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.planillasueldoservice.entities.PlanillaEmpleadoEntity;
import com.service.planillasueldoservice.services.PlanillaEmpleadoService;

@Controller
@RequestMapping()
public class PlanillaEmpleadoController {

    @Autowired
    PlanillaEmpleadoService planillaEmpleadoService;

    @GetMapping("planilla-sueldo/all")
    public ResponseEntity<List<PlanillaEmpleadoEntity>> obtenerUsuarios(){
        
        List<PlanillaEmpleadoEntity> planillas = planillaEmpleadoService.getAllPlanillas();
        return ResponseEntity.ok(planillas);
    } 
}
