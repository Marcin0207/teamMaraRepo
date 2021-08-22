package com.example.projectMara.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adress_name", nullable = false, length = 50)
    private String adressName;

    @Column(nullable = false)
    private String country;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(name = "house_number", nullable = false)
    private String houseNumber;

    @Column(name = "local_number", nullable = false)
    private String localNumber;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
