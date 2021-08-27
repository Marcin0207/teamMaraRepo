package com.example.projectMara.usecase.adminpanel.exception;

public class MovieAlreadyPresentException extends Exception {

    public MovieAlreadyPresentException(String title){
        super("Movie with title "+title+" already exists");
    }

}
