package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Rate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RateDao extends CrudRepository <Rate, Integer> {
    Optional<Rate> findById (Integer id);
}
