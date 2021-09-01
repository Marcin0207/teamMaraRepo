package com.example.projectMara.usecase.logregister.exception;

public class NickNameToLongException extends RuntimeException {

    public NickNameToLongException(){
        super("Nick Name has to many characters");
    }

}
