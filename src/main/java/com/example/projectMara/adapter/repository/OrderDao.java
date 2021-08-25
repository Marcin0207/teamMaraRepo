package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderDao extends CrudRepository <Order, Integer> {

    Optional<Order> findById(Integer id);

}
