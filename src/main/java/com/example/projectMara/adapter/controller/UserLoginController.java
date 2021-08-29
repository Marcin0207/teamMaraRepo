package com.example.projectMara.adapter.controller;


import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.WrongLoginDataException;
import com.example.projectMara.usecase.logregister.LoginUser;
import com.example.projectMara.usecase.logregister.RegisterNewUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class UserLoginController {

    @Autowired
    LoginUser loginUser;


    @ExceptionHandler(WrongLoginDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleLoginDataException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }

}


