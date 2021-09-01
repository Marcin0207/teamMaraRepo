package com.example.projectMara.usecase.clientpanel.exceptions;

public class NotYourAddressException extends RuntimeException{

    public NotYourAddressException(){
        super("Address with this Id cannot be changed");
    }

}
