package com.service.planillasueldoservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.planillasueldoservice.entities.PlanillaEmpleadoEntity;
//import com.service.planillasueldoservice.models.UserInfo;
import com.service.planillasueldoservice.repositories.PlanillaEmpleadoRepository;



@Service
public class PlanillaEmpleadoService {

    @Autowired
    PlanillaEmpleadoRepository planillaEmpleadoRepository;

    @Autowired
    RestTemplate restTemplate;

    /* 
    @Autowired
    EmpleadoService empleadoService;

    @Autowired 
    CategoriaEmpleadoRepository categoriaEmpleadoRepository;

    //Método que calcula la planilla de sueldo de un empleado
    public PlanillaEmpleadoEntity obtenerPlanilla(EmpleadoEntity empleado){

        PlanillaEmpleadoEntity planilla = new PlanillaEmpleadoEntity();

        planilla.setRut(empleado.getRut());
        planilla.setNombres(empleado.getApellidos()+" "+empleado.getNombres());
        planilla.setTiempoDeServicio(empleadoService.calcularYearsOfService(empleado));
        planilla.setSueldoFijoMensual(empleadoService.getSueldo_fijo_mensual(empleado));
        planilla.setMontoBonificacionTiempoServicio(empleadoService.calcularBonificacionTiempoServicio(empleado));
        planilla.setMontoPagoHorasExtras(empleadoService.calcularBonificacionHorasExtras(empleado));
        planilla.setMontoDescuentos(empleadoService.calcularDescuentosTotales(empleado));
        planilla.setSueldoBruto(empleadoService.calcularSueldoBruto(empleado));
        planilla.setCotizacionPrevisional(empleadoService.calcularDescuentoCotizacionPrevisional(empleado));
        planilla.setCotizacionSalud(empleadoService.calcularDescuentoCotizacionPlanSalud(empleado));
        planilla.setSueldoFinal(empleadoService.calcularSueldoFinal(empleado));
        planilla.setCategoria(empleadoService.consultarCategoriaEmpleado(empleado));

        planillaEmpleadoRepository.save(planilla);
        return planilla;
    }
    */



    public List<PlanillaEmpleadoEntity> getPlanillas() {
        //String url = "http://localhost:8080/empleado/planilla";
        String url = "http://empleado-service:8080/empleado/planilla";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class); // Se usa lista de Object para mapear la repuesta JSON
        Object[] records = response.getBody(); // Obtener lista de empleados desde microservicio empleados
        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return Arrays.stream(records)
                .map(planilla -> mapper.convertValue(planilla, PlanillaEmpleadoEntity.class))
                .collect(Collectors.toList());
    }

/* 
    //metodo para autenticarse en el microservicio de empleado
    public ResponseEntity<String> autenticarse(UserInfo userInfo){

        String url = "http://localhost:8080/empleado/autenticar";
        ResponseEntity<String> token = restTemplate.postForEntity(url, userInfo, String.class);
        return token;
    }
*/



    //metodo para obtener todas las marcas de la base de datos
    public ArrayList<PlanillaEmpleadoEntity> getAllPlanillas(){
        
        return (ArrayList<PlanillaEmpleadoEntity>) planillaEmpleadoRepository.findAll();
    }   


    //Metodo para guardar la planilla de un empleado en la base de datos
    public void guardarPlanillas(List<PlanillaEmpleadoEntity> planillas){
        int cantidadPlanillas = planillas.size();
        int i=0;
        while(i<cantidadPlanillas){
            planillaEmpleadoRepository.save(planillas.get(i));
            i = i+1;
        }
    }



    
    
}
