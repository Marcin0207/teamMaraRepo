package com.example.projectMara.usecase.cart.impl;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.usecase.cart.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Page<Movie> findAllMoviesPageable(Pageable pageable) {
        return movieDao.findAll(pageable);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieDao.findById(id);
    }
}
