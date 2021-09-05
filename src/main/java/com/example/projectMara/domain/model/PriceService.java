package com.example.projectMara.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class PriceService {

    @Autowired
    Price price;

    public BigDecimal priceOfStatus (MovieStatus movieStatus){

        BigDecimal moviePrice;

        switch (movieStatus){
            case CLASSIC:
                moviePrice = price.getClassPrice();
                break;
            case NOVELTY:
                moviePrice = price.getNovelPrice();
                break;
            case PREMIERE:
                moviePrice = price.getPremierPrice();
                break;
            default:
                moviePrice = price.getStandardPrice();
        }
       return moviePrice;
    }
    public BigDecimal getDiscount(BigDecimal totalPrice, ClientType clientType){
    BigDecimal discountedPrice = totalPrice;

        switch (clientType){
            case SILVER:
                discountedPrice = totalPrice.multiply(price.getSilverDiscount());
                break;
            case GOLD:
                discountedPrice = totalPrice.multiply(price.getGoldDiscount());
                break;
            case PLATINUM:
                discountedPrice = totalPrice.multiply(price.getPlatinumDiscount());
                break;
            default:
                discountedPrice = totalPrice;
        }
        return discountedPrice;
    }

}
