package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);

}
