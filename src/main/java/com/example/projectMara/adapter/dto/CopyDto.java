package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.Order;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CopyDto {

    private int id;
    private int movieId;
    private String movieTitle;

}
