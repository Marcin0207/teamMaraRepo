package com.example.projectMara.domain.model;

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
@Table(name = "Users")
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

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus clientType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rate> rateList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderArchive> orderArchiveList;

}
