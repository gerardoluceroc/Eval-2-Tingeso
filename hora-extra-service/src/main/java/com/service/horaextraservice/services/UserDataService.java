package com.service.horaextraservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.horaextraservice.entities.UserData;
import com.service.horaextraservice.repositories.UserDataRepository;

import java.util.List;

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

