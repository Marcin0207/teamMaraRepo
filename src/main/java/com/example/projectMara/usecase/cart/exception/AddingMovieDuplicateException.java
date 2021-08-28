package com.example.projectMara.usecase.cart.exception;


import com.example.projectMara.domain.model.Movie;

public class AddingMovieDuplicateException extends RuntimeException {

    public AddingMovieDuplicateException(String title){
        super("Movie with title "+title+" already added to cart");
    }

}