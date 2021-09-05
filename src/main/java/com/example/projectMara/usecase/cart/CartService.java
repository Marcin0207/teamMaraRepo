package com.example.projectMara.usecase.cart;

import com.example.projectMara.adapter.dto.CartDto;
import com.example.projectMara.adapter.dto.MiniCartDto;
import com.example.projectMara.domain.model.Copy;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import com.example.projectMara.usecase.cart.exception.NotEnoughCopiesInStockException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CartService {

    MiniCartDto removeMovie(int idMovie);
    MiniCartDto addMovie(int idMovie);
    CartDto showCart();

    List<Movie> getMovieInCart() throws AddingMovieDuplicateException;

//    void checkout() throws NotEnoughCopiesInStockException;

    // BigDecimal getTotal();
}
