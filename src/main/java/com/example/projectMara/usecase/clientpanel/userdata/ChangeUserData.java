package com.example.projectMara.usecase.clientpanel.userdata;

import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.mappers.UserMapper;
import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.NickNameExistsException;
import com.example.projectMara.usecase.clientpanel.exceptions.PasswordDontMatchException;
import com.example.projectMara.usecase.clientpanel.exceptions.UserNotLoggedInException;
import com.example.projectMara.usecase.logregister.LoginUser;
import com.example.projectMara.usecase.logregister.exception.FullNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NickNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NullFieldsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangeUserData {

    private final UserDao userDao;
    private final LoginUser loginUser;
    private final UserMapper userMapper;

    public UserRegistrationDto update(UserRegistrationDto userDto)
            throws UserNotLoggedInException, EmailExistsException, NickNameExistsException, NickNameToLongException, FullNameToLongException, NullFieldsException {


        String username = loginUser.getUsername();
        if (username.equals("anonymousUser") || username == null) {
            throw new UserNotLoggedInException();
        }

        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email adress: " + userDto.getEmail());
        }
        if (nickNameExist(userDto.getNickName())) {
            throw new NickNameExistsException
                    ("There is an account with that Nickname: " + userDto.getNickName());
        }

        if(userDto.getPassword()!=null && !userDto.getPassword().equals(userDto.getMatchingPassword())){
            throw new PasswordDontMatchException();
        }
        checkData(userDto);

        User user = userDao.findByNickName(username);
        user = setUserDataIfNotNull(user, userDto);
        return userMapper.mapToUserRegistrationDto(userDao.save(user));

    }



    private User setUserDataIfNotNull(User user1, UserRegistrationDto userDto) {

        if (userDto.getNickName() != null) {
            user1.setNickName(userDto.getNickName());
        }
        if (userDto.getEmail() != null) {
            user1.setEmail(userDto.getEmail());
        }
        if (userDto.getFullName() != null) {
            user1.setFullName(userDto.getFullName());
        }
        if (userDto.getPassword() != null) {
            user1.setPassword(userDto.getPassword());
        }
        if (userDto.getPhoneNumber() != null) {
            user1.setPhoneNumber(userDto.getPhoneNumber());
        }
        return user1;
    }

    private boolean emailExist(String email) {
        return userDao.existsByEmail(email);
    }

    private boolean nickNameExist(String nickName) {
        return userDao.existsByNickName(nickName);
    }

    private void checkData(UserRegistrationDto userRegistrationDto)
            throws NullFieldsException, FullNameToLongException, NickNameToLongException {

        if (userRegistrationDto.checkNull()) {
            throw new NullFieldsException();
        } else if (userRegistrationDto.fullNameToLong()) {
            throw new FullNameToLongException();
        } else if (userRegistrationDto.nickNameToLong()) {
            throw new NickNameToLongException();
        }
    }


}
