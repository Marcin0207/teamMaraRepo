package com.example.projectMara.usecase.clientpanel.exceptions;

public class AddressDoesNotExist extends RuntimeException{

    public AddressDoesNotExist(){
        super("That Address does not exist");
    }

}
