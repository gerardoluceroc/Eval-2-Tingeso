package com.service.empleadoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.empleadoservice.entities.EmpleadoEntity;
import com.service.empleadoservice.services.EmpleadoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping()
public class EmpleadoController {
    @Autowired
	EmpleadoService empleadoService;


///* 
    @GetMapping("/empleados/all")
    public ResponseEntity<List<EmpleadoEntity>> obtenerUsuarios(){
        List<EmpleadoEntity> empleados = empleadoService.obtenerUsuarios();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(empleados);
    }   
}