package com.example.projectMara.usecase.logregister;

import com.example.projectMara.adapter.dto.UserLoginDto;
import com.example.projectMara.adapter.repository.RoleDao;
import com.example.projectMara.adapter.repository.UserDao;
import com.example.projectMara.mappers.UserMapper;
import com.example.projectMara.security.config.SecurityConfiguration;
import com.example.projectMara.security.exceptions.WrongLoginDataException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUser {

    public String getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!! athorities "+((UserDetails) principal).getAuthorities());
        } else {
            username = principal.toString();
        }
        return username;
    }


}
