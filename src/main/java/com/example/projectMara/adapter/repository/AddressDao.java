package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Address;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressDao extends JpaRepository<Address, Integer> {

    Optional<Address> findByUser(User user);

    void deleteById(Integer id);


}
