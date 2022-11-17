package com.techelevator.models;

import com.techelevator.models.Products;

import java.math.BigDecimal;

public class Gum extends Products {
    public Gum(String slotLocation, String itemName, BigDecimal price, String type) {
        super(slotLocation, itemName, price, type);
    }
}
