package com.example.projectMara.usecase.cart.exception;

public class MovieNotInCartException extends RuntimeException {

    public MovieNotInCartException(String title){
        super("Movie with title "+title+" is not in cart");
    }

}