package com.example.projectMara.usecase.adminpanel.exception;

public class MovieAlreadyPresentException extends RuntimeException {

    public MovieAlreadyPresentException(String title){
        super("Movie with title "+title+" already exists");
    }

}
