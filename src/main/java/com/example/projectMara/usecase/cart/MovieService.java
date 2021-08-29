package com.example.projectMara.usecase.cart;

import com.example.projectMara.domain.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface MovieService {


        Optional<Movie> findById(Integer id);

        Page<Movie> findAllMoviesPageable(Pageable pageable);


}
