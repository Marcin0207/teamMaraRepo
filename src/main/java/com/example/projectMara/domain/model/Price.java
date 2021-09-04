package com.example.projectMara.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Getter
@Setter
@Component
public class Price {
    private final BigDecimal classPrice;
    private final BigDecimal novelPrice;
    private final BigDecimal premierPrice;
    private final BigDecimal standardPrice;

    public Price(@Value("${price_CLASSIC}")BigDecimal classPrice,
                 @Value("${price_NOVELTY}")BigDecimal novelPrice,
                 @Value("${price_PREMIERE}")BigDecimal premierPrice,
                 @Value("${price_STANDARD}")BigDecimal standardPrice) {
        this.classPrice = classPrice;
        this.novelPrice = novelPrice;
        this.premierPrice = premierPrice;
        this.standardPrice = standardPrice;
    }


}
