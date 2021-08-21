package com.example.projectMara.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "a_movie_id", nullable = false)
    private int aMovieId;

    @Column(name = "a_order_id", nullable = false)
    private int aOrderId;

    @Column(nullable = false)
    private LocalDateTime orderCreatedAt;

    @Column(name = "final_price", nullable = false)
    private BigDecimal finalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
