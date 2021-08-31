package com.example.projectMara.usecase.clientpanel.addresservice;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.repository.AddressDao;
import com.example.projectMara.domain.model.Address;
import com.example.projectMara.mappers.AddressMapper;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import com.example.projectMara.usecase.logregister.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeAddress {

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;
    private final LoginUser loginUser;

    public AddressDto update(AddressDto addressDto) throws UserNotLoggedInException {


        String username = loginUser.getUsername();

        System.out.println("@#@#@#@#@#@ Username of logged User: " + username);

        Address address = addressMapper.mapToAddress(addressDto);


        return null; //addressMapper.mapToAddressDto(addressDao.)
    }


}
