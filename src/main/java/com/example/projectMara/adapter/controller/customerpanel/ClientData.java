package com.example.projectMara.adapter.controller.customerpanel;


import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.NickNameExistsException;
import com.example.projectMara.usecase.clientpanel.exceptions.PasswordDontMatchException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import com.example.projectMara.usecase.clientpanel.userdata.ChangeUserData;
import com.example.projectMara.usecase.logregister.exception.FullNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NickNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NullFieldsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("clientpanel/mydata")
@RequiredArgsConstructor
public class ClientData {

    private final ChangeUserData changeUserData;

    @ExceptionHandler(UserNotLoggedInException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNotLoggedInException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }

    @ExceptionHandler(PasswordDontMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handlePasswordDontMatchException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }
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

    @ExceptionHandler(NickNameToLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNickNameToLong(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }

    @ExceptionHandler(FullNameToLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleFullNameToLong(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }

    @ExceptionHandler(NullFieldsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNullFieldsException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("update")
    public UserRegistrationDto update(@RequestBody UserRegistrationDto userDto) {
        return this.changeUserData.update(userDto);
    }

}
