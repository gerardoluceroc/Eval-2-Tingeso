
package com.service.empleadoservice.repositories;

import com.service.empleadoservice.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    UserData findByUsuario(String username);
}
