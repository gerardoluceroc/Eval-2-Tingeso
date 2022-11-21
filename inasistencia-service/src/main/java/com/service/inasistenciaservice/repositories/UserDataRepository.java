package com.service.inasistenciaservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.inasistenciaservice.entitites.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    UserData findByUsuario(String username);
}
