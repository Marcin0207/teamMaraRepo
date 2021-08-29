package com.example.projectMara.adapter.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDto {

    @NotNull
    @NotEmpty
    private String nickName;

    @NotNull
    @NotEmpty
    private String password;


}
