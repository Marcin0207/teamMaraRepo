package com.example.projectMara.domain.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String director;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private MovieStatus movieStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "avg_rate")
    private double avgRate;

    @Column(name = "premiere_date")
    private LocalDate premiereDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Copy> copies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Rate> rateList;





}
