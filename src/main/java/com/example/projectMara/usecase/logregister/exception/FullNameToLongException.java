package com.example.projectMara.usecase.logregister.exception;

public class FullNameToLongException extends RuntimeException {

    public FullNameToLongException (){
        super(" Full Name has to many letters");
    }


}
