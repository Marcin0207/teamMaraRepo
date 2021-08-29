package com.example.projectMara.adapter.controller;


import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.NickNameExistsException;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.logregister.RegisterNewUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("register")
@RequiredArgsConstructor
public class UserRegistrationController {

    @Autowired
    RegisterNewUser registerNewUser;


    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleEmailException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }

    @ExceptionHandler(NickNameExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleNickNameException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("newUser")
    public UserRegistrationDto add(@RequestBody UserRegistrationDto userRegistrationDto) {
        return this.registerNewUser.registerNewUserAccount(userRegistrationDto);
    }


}
