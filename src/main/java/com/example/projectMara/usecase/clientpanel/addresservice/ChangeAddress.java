package com.example.projectMara.usecase.clientpanel.addresservice;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.repository.AddressDao;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.Address;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.mappers.AddressMapper;
import com.example.projectMara.usecase.clientpanel.exceptions.AddressDoesNotExist;
import com.example.projectMara.usecase.clientpanel.exceptions.MissingAddressIdException;
import com.example.projectMara.usecase.clientpanel.exceptions.NotYourAddressException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import com.example.projectMara.usecase.logregister.LoginUser;
import com.example.projectMara.usecase.logregister.exception.FullNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NickNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NullFieldsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangeAddress {

    private final UserDao userDao;
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;
    private final LoginUser loginUser;

    public List<AddressDto> update(AddressDto addressDto)
            throws UserNotLoggedInException, MissingAddressIdException, NotYourAddressException{

        String username = loginUser.getUsername();
        if (username.equals("anonymousUser") || username == null) {
            throw new UserNotLoggedInException();
        }

        if (addressDto.getId() == null) {
            throw new MissingAddressIdException();
        }
        User loggedUser = userDao.findByNickName(username);


        Optional<Address> addr = addressDao.findById(addressDto.getId());
        if(Optional.of(addr).isPresent()){
            if(addr.get().getUser().getId() != loggedUser.getId()) {
                throw new NotYourAddressException();
            }
        } else {
            throw new AddressDoesNotExist();
        }



        List<Address> addressList = loggedUser.getAddressList();
        List<Address> updatedAddressList = addressList.stream()
                .map(address -> setAddressDataIfNotNull(address, addressDto))
                .collect(Collectors.toList());


        loggedUser.setAddressList(updatedAddressList);
        userDao.save(loggedUser);

        Address address = addressMapper.mapToAddress(addressDto);

        List<AddressDto> updatedAddressDtoList = new ArrayList<>();
        updatedAddressDtoList = updatedAddressList.stream().
                map(address1 -> addressMapper.mapToAddressDto(address1))
                .collect(Collectors.toList());

        return updatedAddressDtoList; //addressMapper.mapToAddressDto(addressDao.)
    }

    private Address setAddressDataIfNotNull(Address address, AddressDto addressDto) {

        if (address.getId() == addressDto.getId()) {
            if (addressDto.getAddressName() != null) {
                address.setAddressName(addressDto.getAddressName());
            }
            if (addressDto.getCity() != null) {
                address.setCity(addressDto.getCity());
            }
            if (addressDto.getCountry() != null) {
                address.setCountry(addressDto.getCountry());
            }
            if (addressDto.getIsDefault() != null) {
                address.setIsDefault(addressDto.getIsDefault());
            }
            if (addressDto.getHouseNumber() != null) {
                address.setHouseNumber(addressDto.getHouseNumber());
            }
            if (addressDto.getLocalNumber() != null) {
                address.setLocalNumber(addressDto.getLocalNumber());
            }
            if (addressDto.getPostalCode() != null) {
                address.setPostalCode(addressDto.getPostalCode());
            }
            if (addressDto.getStreet() != null) {
                address.setStreet(addressDto.getStreet());
            }
        }
        else {
            if (addressDto.getIsDefault()){
                address.setIsDefault(false);
            }
        }
        return address;
    }
}
