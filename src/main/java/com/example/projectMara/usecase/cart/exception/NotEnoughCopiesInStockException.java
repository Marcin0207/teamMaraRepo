package com.example.projectMara.usecase.cart.exception;

import com.example.projectMara.domain.model.Copy;

public class NotEnoughCopiesInStockException extends Exception {

    private static final String DEFAULT_MESSAGE = "Not enough copies in stock";

    public NotEnoughCopiesInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughCopiesInStockException(Copy copy) {
        super(String.format("Not enough %d Copies in stock.", copy.getMovie()));
    }
}