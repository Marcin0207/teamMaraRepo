package com.example.projectMara.usecase.logregister.exception;

public class NullFieldsException extends RuntimeException{

    public NullFieldsException(){
        super("Form has empty fields!");
    }
}
