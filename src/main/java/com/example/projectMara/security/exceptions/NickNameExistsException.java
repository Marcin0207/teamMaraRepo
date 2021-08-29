package com.example.projectMara.security.exceptions;

public class NickNameExistsException extends RuntimeException{

    public NickNameExistsException(String message){
        super(message);
    }

}
