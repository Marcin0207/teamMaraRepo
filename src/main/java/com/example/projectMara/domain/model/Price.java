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

    private final BigDecimal silverDiscount;
    private final BigDecimal goldDiscount;
    private final BigDecimal platinumDiscount;



    public Price(@Value("${price_CLASSIC}")BigDecimal classPrice,
                 @Value("${price_NOVELTY}")BigDecimal novelPrice,
                 @Value("${price_PREMIERE}")BigDecimal premierPrice,
                 @Value("${price_STANDARD}")BigDecimal standardPrice,
                 @Value("${discount_SILVER}")BigDecimal silverDiscount,
                 @Value("${discount_GOLD}")BigDecimal goldDiscount,
                 @Value("${discount_PLATINUM}")BigDecimal platinumDiscount) {

        this.classPrice = classPrice;
        this.novelPrice = novelPrice;
        this.premierPrice = premierPrice;
        this.standardPrice = standardPrice;

        this.silverDiscount = silverDiscount;
        this.goldDiscount = goldDiscount;
        this.platinumDiscount = platinumDiscount;
    }


}
