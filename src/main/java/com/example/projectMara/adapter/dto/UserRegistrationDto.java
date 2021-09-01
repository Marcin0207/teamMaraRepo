package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRegistrationDto {

    @NotNull
    @NotEmpty
    private String fullName;

    @NotNull
    @NotEmpty
    private String nickName;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;


    public boolean checkNull() {
        return (this.nickName == null
                || this.fullName == null
                || this.email == null
                || this.password == null
                || this.matchingPassword == null
                || this.phoneNumber == null);
    }
    public boolean fullNameToLong() {
        return this.fullName.length() > 50;
    }

    public boolean nickNameToLong() {
        return this.nickName.length() > 30;
    }


}
