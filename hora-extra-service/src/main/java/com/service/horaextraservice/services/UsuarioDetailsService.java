package com.service.horaextraservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.service.horaextraservice.entities.UserData;
import com.service.horaextraservice.repositories.UserDataRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService  {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData userData = userDataRepository.findByUsuario(username);

        if (userData != null) {
            User.UserBuilder userBuilder = User.withUsername(username);
            String encryptedPassword = userData.getClave();
            var rol = userData.getRol();
            userBuilder.password(encryptedPassword);
            userBuilder.roles(rol);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException(username);
        }

    }
}

