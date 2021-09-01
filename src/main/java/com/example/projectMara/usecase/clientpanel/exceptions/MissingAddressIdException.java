package com.example.projectMara.usecase.clientpanel.exceptions;

public class MissingAddressIdException extends RuntimeException{

    public MissingAddressIdException(){
        super("Address Id is missing");
    }

}
