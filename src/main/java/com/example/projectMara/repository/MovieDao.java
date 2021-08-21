package com.example.projectMara.repository;

import com.example.projectMara.domain.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieDao extends CrudRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);

}
