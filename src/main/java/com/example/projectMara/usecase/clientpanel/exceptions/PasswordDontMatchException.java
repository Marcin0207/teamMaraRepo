package com.example.projectMara.usecase.clientpanel.exceptions;

public class PasswordDontMatchException extends RuntimeException{

    public PasswordDontMatchException(){
        super("Enter same password twice");
    }
}
