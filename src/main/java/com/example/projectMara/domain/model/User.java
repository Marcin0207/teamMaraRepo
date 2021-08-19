package com.example.projectMara.domain.model;

import com.example.projectMara.domain.model.Order;
import com.example.projectMara.domain.model.Rate;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "nick_name", unique = true, nullable = false, length = 30)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    @Enumerated(EnumType.STRING)
    private Enum clientType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rate> rateList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;
}
