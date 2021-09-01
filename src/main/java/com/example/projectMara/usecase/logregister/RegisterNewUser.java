package com.example.projectMara.usecase.logregister;

import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.adapter.repository.RoleDao;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.mappers.UserMapper;
import com.example.projectMara.security.exceptions.EmailExistsException;
import com.example.projectMara.security.exceptions.NickNameExistsException;
import com.example.projectMara.usecase.logregister.exception.FullNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NickNameToLongException;
import com.example.projectMara.usecase.logregister.exception.NullFieldsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@AllArgsConstructor
@Transactional
public class RegisterNewUser {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserRegistrationDto registerNewUserAccount(UserRegistrationDto userRegistrationDto)
            throws EmailExistsException, NickNameExistsException, NickNameToLongException, FullNameToLongException, NullFieldsException {

        if (emailExist(userRegistrationDto.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email adress: " + userRegistrationDto.getEmail());
        }
        if (nickNameExist(userRegistrationDto.getNickName())) {
            throw new EmailExistsException
                    ("There is an account with that Nickname: " + userRegistrationDto.getNickName());
        }
        checkData(userRegistrationDto);

        User user = new User();


        user.setFullName(userRegistrationDto.getFullName());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());
        user.setNickName(userRegistrationDto.getNickName());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());

        user.setRoles(Arrays.asList(roleDao.findByName("ROLE_USER")));
        user.setCreatedAt(LocalDateTime.now());

        return userMapper.mapToUserRegistrationDto(userDao.save(user));
        //  return Mappers.getMapper(userMapper).mapToUserRegistrationDto(userDao.save(user));
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
