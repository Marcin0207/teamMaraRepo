package com.example.projectMara.adapter.controller;


import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.NickNameExistsException;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.logregister.RegisterNewUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRegistrationController {

    @Autowired
    RegisterNewUser registerNewUser;
    @Autowired
    UserDao userDao;


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

// thymeleaf


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (userDao.findByNickName(user.getUsername())!=null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/registration");
        } else {
            // Registration successful, save user
            // Set user role to USER and set it as active
            userDao.save(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("/registration");
        }
        return modelAndView;
    }

}
