package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);

    List<Movie> findByOrderByTitle();

    List<Movie> findByOrderByPremiereDate();

    List<Movie> findByOrderByCreatedAt();

    List<Movie> findByOrderByAvgRateDesc();

  //  List<Movie> findByOrderByAvgRateDescMovieGenre(MovieGenre movieGenre);
}
