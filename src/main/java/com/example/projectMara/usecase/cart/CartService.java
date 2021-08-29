package com.example.projectMara.usecase.cart;

import com.example.projectMara.domain.model.Copy;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import com.example.projectMara.usecase.cart.exception.NotEnoughCopiesInStockException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CartService {

    void removeMovie(Movie movie);
    void addMovie(Movie movie);

    List<Movie> getMovieInCart() throws AddingMovieDuplicateException;

//    void checkout() throws NotEnoughCopiesInStockException;

    // BigDecimal getTotal();
}
