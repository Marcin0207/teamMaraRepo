package com.example.projectMara.usecase.clientpanel.exceptions;

public class AddressNameToLongException extends RuntimeException{

    public AddressNameToLongException(){
        super("Your Address Name has too many characters");
    }

}
