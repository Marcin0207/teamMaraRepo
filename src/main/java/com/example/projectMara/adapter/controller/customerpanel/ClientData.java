package com.example.projectMara.adapter.controller.customerpanel;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.usecase.adminpanel.AddMovieToCentralStore;
import com.example.projectMara.usecase.adminpanel.ReadMovieFromCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.clientpanel.addresservice.ChangeAddress;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("clientpanel/mydata/address")
@RequiredArgsConstructor
public class ClientData {


    @Autowired
    private ChangeAddress changeAddress;

    @ExceptionHandler(UserNotLoggedInException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("update")
    public AddressDto add(@RequestBody AddressDto addressDto) {
        return this.changeAddress.update(addressDto);
    }




}
