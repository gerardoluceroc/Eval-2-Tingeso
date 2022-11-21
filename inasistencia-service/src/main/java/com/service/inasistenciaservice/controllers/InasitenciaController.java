package com.service.inasistenciaservice.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.inasistenciaservice.entitites.InasistenciaEntity;
import com.service.inasistenciaservice.models.TokenInfo;
import com.service.inasistenciaservice.models.UserInfo;
import com.service.inasistenciaservice.services.InansistenciaService;
import com.service.inasistenciaservice.services.JwtUtilService;


@Controller
@RequestMapping()
public class InasitenciaController {
    @Autowired
	InansistenciaService inasistenciaService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;


    //Controlador para recibir las marcas de ingreso salida e ingresarlas en la base datos
    @RequestMapping(value= "/inasistencia/enviarjustificativo", method = RequestMethod.POST)
    public ResponseEntity<InasistenciaEntity> agregarJustificativo(@RequestBody InasistenciaEntity justificativo){
        inasistenciaService.updateInasistencia(justificativo);
        return ResponseEntity.ok(justificativo);

    }

    @GetMapping("inasistencia/all")
    public ResponseEntity<List<InasistenciaEntity>> obtenerInasistencias(){
        List<InasistenciaEntity> inasistencias = inasistenciaService.getAllInasistencias();
        if (inasistencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(inasistencias);
    } 



    @PostMapping("inasistencia/autenticar")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody UserInfo userInfo) {

        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userInfo.getUsuario(), userInfo.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(userInfo.getUsuario());
        final String jwt = jwtUtilService.generateToken(userDetails);
        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }

}    


    