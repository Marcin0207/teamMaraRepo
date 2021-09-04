package com.example.projectMara.usecase.adminpanel.exception;

public class MovieIdDoesntExsistException extends RuntimeException {

    public MovieIdDoesntExsistException(int Id){
        super("There is no movie with this Id :" +  Id);
    }
}
