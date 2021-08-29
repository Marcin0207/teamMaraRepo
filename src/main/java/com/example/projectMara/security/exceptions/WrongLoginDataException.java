package com.example.projectMara.security.exceptions;

public class WrongLoginDataException extends RuntimeException{

    public WrongLoginDataException(String message){
        super(message);
    }

}
