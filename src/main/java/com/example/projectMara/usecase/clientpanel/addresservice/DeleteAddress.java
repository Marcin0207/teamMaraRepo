package com.example.projectMara.usecase.clientpanel.addresservice;


import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.repository.AddressDao;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.Address;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.mappers.AddressMapper;
import com.example.projectMara.usecase.clientpanel.exceptions.AddressDoesNotExist;
import com.example.projectMara.usecase.clientpanel.exceptions.NotYourAddressException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import com.example.projectMara.usecase.logregister.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAddress {

    private final UserDao userDao;
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;
    private final LoginUser loginUser;

    public List<AddressDto> deleteById(int id)
            throws UserNotLoggedInException, NotYourAddressException, AddressDoesNotExist {


        String username = loginUser.getUsername();
        if (username.equals("anonymousUser") || username == null) {
            throw new UserNotLoggedInException();
        }

        User loggedUser = userDao.findByNickName(username);

        Optional<Address> addr = addressDao.findById(id);
        if (addr.isPresent()) {
            if (addr.get().getUser().getId() != loggedUser.getId()) {
                throw new NotYourAddressException();
            }
        } else {
            throw new AddressDoesNotExist();
        }

        List<Address> addressList = loggedUser.getAddressList();
        addressList.removeIf(address -> address.getId()==id);


        for (Address address: addressList) {
            System.out.println(address.getAddressName());

        }
        loggedUser.setAddressList(addressList);
        userDao.save(loggedUser);
        addressDao.deleteById(id);


        List<AddressDto> addressDtoList;
        addressDtoList = loggedUser.getAddressList().stream()
                .map(address -> addressMapper.mapToAddressDto(address))
                .collect(Collectors.toList());

        return addressDtoList;
    }
}

