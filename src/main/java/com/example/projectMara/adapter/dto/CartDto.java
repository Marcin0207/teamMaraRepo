package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartDto {

    private List<String> movieTitles;
    private BigDecimal totalPricePerDay;

}


