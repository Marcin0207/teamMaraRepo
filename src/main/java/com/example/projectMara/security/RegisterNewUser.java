package com.example.projectMara.security;

import com.example.projectMara.adapter.dto.UserDto;
import com.example.projectMara.domain.model.User;
import com.example.projectMara.repository.RoleDao;
import com.example.projectMara.repository.UserDao;
import com.example.projectMara.security.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class RegisterNewUser {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email adress: " + accountDto.getEmail());
        }
        User user = new User();

        user.setFullName(accountDto.getFullName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());

        user.setRoles(Arrays.asList(roleDao.findByName("ROLE_USER")));
        return userDao.save(user);
    }

    private boolean emailExist(String email){
       return userDao.existsByEmail(email);
    }
}
