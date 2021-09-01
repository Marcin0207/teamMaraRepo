package com.example.projectMara.usecase.clientpanel.addresservice;

import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.repository.AddressDao;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.Address;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.mappers.AddressMapper;
import com.example.projectMara.usecase.clientpanel.exceptions.AddressNameToLongException;
import com.example.projectMara.usecase.clientpanel.exceptions.NullFieldsInAddressException;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AddAddress {

    private final UserDao userDao;
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;
    private final LoginUser loginUser;

    public List<AddressDto> add(AddressDto addressDto) throws UserNotLoggedInException {

        String username = loginUser.getUsername();
        if (username.equals("anonymousUser") || username == null) {
            throw new UserNotLoggedInException();
        }

        User loggedUser = userDao.findByNickName(username);

        checkData(addressDto);
        Address address = addressMapper.mapToAddress(addressDto);
        List<Address> addressList = loggedUser.getAddressList();

        if(address.getIsDefault()){
            addressList.forEach(addr -> addr.setIsDefault(false));
        }
        address.setUser(loggedUser);
        addressList.add(address);
        loggedUser.setAddressList(addressList);
        userDao.save(loggedUser);

        List<AddressDto> extendedAddressDtoList = new ArrayList<>();
        extendedAddressDtoList = addressList.stream().
                map(addr -> addressMapper.mapToAddressDto(addr))
                .collect(Collectors.toList());

        return extendedAddressDtoList;
    }

    private void checkData(AddressDto addressDto)
            throws NullFieldsInAddressException, AddressNameToLongException {

        if (addressDto.checkNull()) {
            throw new NullFieldsInAddressException();
        } else if (addressDto.addressName()) {
            throw new AddressNameToLongException();
        }
    }
}