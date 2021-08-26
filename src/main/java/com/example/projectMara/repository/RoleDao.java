package com.example.projectMara.repository;

import com.example.projectMara.domain.model.Role;
import com.example.projectMara.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleDao extends CrudRepository<Role, Integer> {
    Optional<Role> findById(Integer id);
    Role findByName(String name);



}
