package com.example.projectMara.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SingleMovieCartData {

    String title;
    String description;
    BigDecimal baseMoviePricePerDay;

}
