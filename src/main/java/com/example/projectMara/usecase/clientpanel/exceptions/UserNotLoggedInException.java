package com.example.projectMara.usecase.clientpanel.exceptions;

public class UserNotLoggedInException extends RuntimeException {

    public UserNotLoggedInException(){
        super("Sign In to change your data");
    }

}
