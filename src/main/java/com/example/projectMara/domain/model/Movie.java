package com.example.projectMara.domain.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column
    @Enumerated(EnumType.STRING)
    private MovieStatus movieStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name= "avt_rate")
    private float avgRate;






}
