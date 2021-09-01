package com.example.projectMara.usecase.clientpanel.exceptions;

public class NullFieldsInAddressException extends RuntimeException {

    public NullFieldsInAddressException(){
        super("Fill the empty fields in form");
    }

}
