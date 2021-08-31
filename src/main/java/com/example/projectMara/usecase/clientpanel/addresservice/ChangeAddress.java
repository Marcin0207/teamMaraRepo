package com.example.projectMara.usecase.clientpanel.addresservice;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.repository.AddressDao;
import com.example.projectMara.domain.model.Address;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.mappers.AddressMapper;
import com.example.projectMara.mappers.MovieMapper;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChangeAddress {

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressDto update(AddressDto addressDto) throws UserNotLoggedInException {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println("@#@#@#@#@#@ Username of logged User: " + username);

        Address address = addressMapper.mapToAddress(addressDto);


        return null; //addressMapper.mapToAddressDto(addressDao.)
    }


}
