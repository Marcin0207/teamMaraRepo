package com.example.projectMara.domain.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Copy> copiesList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
