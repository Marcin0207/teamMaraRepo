package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.Copy;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.domain.model.MovieStatus;
import com.example.projectMara.domain.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDto {

    private int id;
    private String title;
    private String director;
    private String description;
    private MovieStatus movieStatus;
    private MovieGenre movieGenre;
    private LocalDateTime createdAt;
    private double avgRate;
    private LocalDate premiereDate;
    private List<Copy> copies;
    private List<Rate> rateList;

}
