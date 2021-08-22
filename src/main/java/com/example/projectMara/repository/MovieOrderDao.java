package com.example.projectMara.repository;

import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieOrder;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface MovieOrderDao extends CrudRepository <MovieOrder, Integer> {

    Optional<MovieOrder> findById(Integer id);

}
