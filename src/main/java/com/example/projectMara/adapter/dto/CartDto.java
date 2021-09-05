package com.example.projectMara.adapter.dto;

import com.example.projectMara.domain.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartDto {

    List<SingleMovieCartData> singleMovieCartData;
    private BigDecimal totalPricePerDay;

}


