package com.service.horaextraservice.controllers;


import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.horaextraservice.entities.HoraExtraEntity;
import com.service.horaextraservice.models.TokenInfo;
import com.service.horaextraservice.models.UserInfo;
import com.service.horaextraservice.services.HoraExtraService;
import com.service.horaextraservice.services.JwtUtilService;





@Controller
@RequestMapping()
public class HoraExtraController {
    @Autowired
	HoraExtraService horaExtraService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    //Controlador para recibir una autorización de horas extras e ingresarlas en la base datos
    @RequestMapping(value= "/hora-extra/enviarautorizacion", method = RequestMethod.POST)
    public ResponseEntity<HoraExtraEntity> agregarHoraExtra(@RequestBody HoraExtraEntity horaExtra){

        horaExtraService.saveHoraExtra(horaExtra);
        return ResponseEntity.ok(horaExtra);
        
    }

    @GetMapping("hora-extra/all")
    public ResponseEntity<List<HoraExtraEntity>> obtenerUsuarios(){
        List<HoraExtraEntity> horasExtras = horaExtraService.getAllHoras();
        if (horasExtras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(horasExtras);
    } 

    @PostMapping("hora-extra/autenticar")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody UserInfo userInfo) {

        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userInfo.getUsuario(), userInfo.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(userInfo.getUsuario());
        final String jwt = jwtUtilService.generateToken(userDetails);
        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }

}    
