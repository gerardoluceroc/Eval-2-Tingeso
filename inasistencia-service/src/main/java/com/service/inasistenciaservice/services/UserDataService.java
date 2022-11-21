package com.service.inasistenciaservice.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.inasistenciaservice.entitites.UserData;
import com.service.inasistenciaservice.repositories.UserDataRepository;

@Service
public class UserDataService {

    @Autowired
    UserDataRepository userDataRepository;

    public List<UserData> getAll() {
        return userDataRepository.findAll();
    }

    public UserData getUserById(int id) {
        return userDataRepository.findById(id).orElse(null);
    }

    public UserData save(UserData userData) {
        UserData userDataNew = userDataRepository.save(userData);
        return userDataNew;
    }

}

