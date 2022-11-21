package com.service.planillasueldoservice.controllers;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;


import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.planillasueldoservice.entities.PlanillaEmpleadoEntity;
//import com.service.planillasueldoservice.models.UserInfo;
import com.service.planillasueldoservice.services.PlanillaEmpleadoService;

//import javassist.NotFoundException;

@Controller
//@CrossOrigin(origins="http://localhost:3000")
@RequestMapping()
public class PlanillaEmpleadoController {

    @Autowired
    PlanillaEmpleadoService planillaEmpleadoService;

    @Autowired//BORRAR DPS ESTO SE DEBE HACER EN LOS SERVICIOS
    RestTemplate restTemplate;

    @GetMapping("planilla-sueldo/all")
    public ResponseEntity<List<PlanillaEmpleadoEntity>> obtenerPlanillas(){
        
        List<PlanillaEmpleadoEntity> planillas = planillaEmpleadoService.getAllPlanillas();
        return ResponseEntity.ok(planillas);
    } 





    @GetMapping("/planilla-sueldo/calculate")
    public ResponseEntity<List<PlanillaEmpleadoEntity>> calcularPlanillas(HttpServletResponse response) throws IOException {
        List<PlanillaEmpleadoEntity> planillas = planillaEmpleadoService.getPlanillas();
        planillaEmpleadoService.guardarPlanillas(planillas);
        return ResponseEntity.ok(planillaEmpleadoService.getAllPlanillas());

        //reportService.generateEmployeesReport(response, employees);
    }
/* 
    @PostMapping("/planilla-sueldo/autenticar")
    public ResponseEntity<String> autenticacion(){
        UserInfo userInfo = new UserInfo("gerardoluceroc", "gerardo123");
        return planillaEmpleadoService.autenticarse(userInfo);

        /* 
        ResponseEntity<String> jwtResponse = planillaEmpleadoService.autenticarse(userInfo);

         String token = "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnZXJhcmRvbHVjZXJvYyIsImV4cCI6MTY2OTAwMzA4OSwiaWF0IjoxNjY4OTkyMjg5LCJyb2wiOnsiYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9fQ.kWQM2M_2skcgtY1goBGXP6aTK1hBLYRUVrn4BFgT3Zg";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        //headers.setBearerAuth(token);

        HttpEntity<String> entityReq = new HttpEntity<String>("holaa", headers);
        String url = "http://localhost:8080/empleado/planilla";
        System.out.println("ALOOOOOOOOOOOOOOOOOOOOOOOO "+entityReq.getHeaders());
        System.out.println("EL TOKEN ES "+token);
        ResponseEntity<Object[]> plantillasResponse = restTemplate.exchange(url, HttpMethod.GET, entityReq, Object[].class);

        Object[] records = plantillasResponse.getBody(); // Obtener lista de empleados desde microservicio empleados
        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return Arrays.stream(records)
                .map(planilla -> mapper.convertValue(planilla, PlanillaEmpleadoEntity.class))
                .collect(Collectors.toList());

        //ResponseEntity<PlanillaEmpleadoEntity> plantillasResponse = restTemplate.postForEntity(url, entityReq, PlanillaEmpleadoEntity.class);
        //return plantillasResponse;
        //template.exchange("RestSvcUrl", HttpMethod.POST, entityReq, SomeResponse.class);
    /* 
        String url = "http://localhost:8080/empleado/planilla";
        RequestEntity request = RequestEntity
                    .post(url, null)
                    .header("Authorization", token)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(null);

        ResponseEntity<PlanillaEmpleadoEntity> plantillasResponse = restTemplate.exchange(request, PlanillaEmpleadoEntity.class);
        return plantillasResponse;

        

    

        
    }
    */











}
