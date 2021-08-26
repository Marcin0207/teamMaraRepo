package com.example.projectMara.repository;

import com.example.projectMara.domain.model.Privilege;
import com.example.projectMara.domain.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrivilegeDao extends CrudRepository<Privilege,Integer> {

    Optional<Privilege> findById(Integer id);
    Privilege findByName(String name);

}
