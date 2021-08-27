package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {

    private int id;
    private String fullName;
    private String nickName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean enabled;
    private boolean tokenExpired;
    private LocalDateTime createdAt;
    private ClientType clientType;
    private List<Rate> rateList;
    private List<Order> orderList;
    private List<Address> addressList;
    private List<OrderArchive> orderArchiveList;
    private Collection<Role> roles;


}
