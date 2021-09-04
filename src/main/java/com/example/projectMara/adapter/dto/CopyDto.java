package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CopyDto {

    private int id;
    private Movie movie;

}
