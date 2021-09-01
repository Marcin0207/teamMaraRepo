package com.example.projectMara.adapter.controller.customerpanel;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.usecase.adminpanel.AddMovieToCentralStore;
import com.example.projectMara.usecase.adminpanel.ReadMovieFromCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.clientpanel.addresservice.AddAddress;
import com.example.projectMara.usecase.clientpanel.addresservice.ChangeAddress;
import com.example.projectMara.usecase.clientpanel.exceptions.AddressDoesNotExist;
import com.example.projectMara.usecase.clientpanel.exceptions.MissingAddressIdException;
import com.example.projectMara.usecase.clientpanel.exceptions.NotYourAddressException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("clientpanel/mydata/address")
@RequiredArgsConstructor
public class ClientData {

    @Autowired
    private ChangeAddress changeAddress;
    @Autowired
    private AddAddress addAddress;

    @ExceptionHandler(UserNotLoggedInException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNotLoggedInException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }
    @ExceptionHandler(MissingAddressIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMissingIdException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }
    @ExceptionHandler(AddressDoesNotExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMissingAddress(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }
    @ExceptionHandler(NotYourAddressException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleNotYourAddressException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
    public List<AddressDto> add(@RequestBody AddressDto addressDto) {
        return this.addAddress.add(addressDto);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("update")
    public List<AddressDto> update(@RequestBody AddressDto addressDto) {
        return this.changeAddress.update(addressDto);
    }


}
