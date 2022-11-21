package com.service.empleadoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.service.empleadoservice.entities.EmpleadoEntity;
import com.service.empleadoservice.models.PlanillaEmpleadoModel;
//import com.service.empleadoservice.models.TokenInfo;
//import com.service.empleadoservice.models.UserInfo;
import com.service.empleadoservice.services.EmpleadoService;
//import com.service.empleadoservice.services.JwtUtilService;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;





@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
	EmpleadoService empleadoService;


    //@Autowired
    //private AuthenticationManager authenticationManager;

    //@Autowired
    //UserDetailsService usuarioDetailsService;

    //@Autowired
    //private JwtUtilService jwtUtilService;


///* 
    @GetMapping("/all")
    public ResponseEntity<List<EmpleadoEntity>> obtenerUsuarios(){
        List<EmpleadoEntity> empleados = empleadoService.obtenerUsuarios();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(empleados);
    }  
    
    //Metodo para solicitar la planilla de sueldos
    @GetMapping("/planilla")
    public ResponseEntity<List<PlanillaEmpleadoModel>> getAllPlannillas(){
        

        ArrayList<PlanillaEmpleadoModel> planillas = new ArrayList<PlanillaEmpleadoModel>();

        ArrayList<EmpleadoEntity> empleados = empleadoService.obtenerUsuarios();

        int cantidadEmpleados = empleados.size();

        int i=0;
        while(i<cantidadEmpleados){ 

            PlanillaEmpleadoModel planilla = new PlanillaEmpleadoModel();
            planilla.setRut(empleados.get(i).getRut());
            planilla.setNombres(empleados.get(i).getApellidos()+" "+empleados.get(i).getNombres());
            planilla.setTiempoDeServicio(empleadoService.calcularYearsOfService(empleados.get(i)));
            planilla.setSueldoFijoMensual(empleadoService.getSueldo_fijo_mensual(empleados.get(i)));
            planilla.setMontoBonificacionTiempoServicio(empleadoService.calcularBonificacionTiempoServicio(empleados.get(i)));
            planilla.setMontoPagoHorasExtras(empleadoService.calcularBonificacionHorasExtras(empleados.get(i)));
            planilla.setMontoDescuentos(empleadoService.calcularDescuentosTotales(empleados.get(i)));
            planilla.setSueldoBruto(empleadoService.calcularSueldoBruto(empleados.get(i)));
            planilla.setCotizacionPrevisional(empleadoService.calcularDescuentoCotizacionPrevisional(empleados.get(i)));
            planilla.setCotizacionSalud(empleadoService.calcularDescuentoCotizacionPlanSalud(empleados.get(i)));
            planilla.setSueldoFinal(empleadoService.calcularSueldoFinal(empleados.get(i)));
            planilla.setCategoria(empleadoService.consultarCategoriaEmpleado(empleados.get(i)));
            planillas.add(planilla);
            i = i+1;


        }
        return ResponseEntity.ok(planillas);

    }


    

    /* 
    @PostMapping("/autenticar")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody UserInfo userInfo) {

        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userInfo.getUsuario(), userInfo.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(userInfo.getUsuario());
        final String jwt = jwtUtilService.generateToken(userDetails);
        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }
    */
}
