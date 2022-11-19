package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products {

    private String slotLocation;
    private String itemName;
    private BigDecimal price;
    private String type;
    private Integer quantity = 6;
    //private List<String>  slotLocationList= new ArrayList<>();
    private Map<String,String> mapOfItemNames = new HashMap<>();
    private Map<String,BigDecimal> mapOfItemPrice = new HashMap<>();
    private Map<String,String> mapOfItemType = new HashMap<>();
    private Map<String,Integer> mapOfItemAmount = new HashMap<>();

    public Products(String slotLocation, String itemName, BigDecimal price, String type) {
        this.slotLocation = slotLocation;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
    }

    public Map<String, String> getMapOfItemNames() {
        return mapOfItemNames;
    }

    public Map<String, BigDecimal> getMapOfItemPrice() {
        return mapOfItemPrice;
    }

    public Map<String, String> getMapOfItemType() {
        return mapOfItemType;
    }

    public Map<String, Integer> getMapOfItemAmount() {
        return mapOfItemAmount;
    }

    public Products() {
    }

    File menu = new File("catering.csv");
    Scanner fileInput;
    int totalLine = 0;

    {
        try {
            fileInput = new Scanner(menu);
            while(fileInput.hasNextLine()){
                String[] items = fileInput.nextLine().split(",");
                this.slotLocation =items[0];
                this.itemName=items[1];
                this.price=new BigDecimal(items[2]);
                this.type=items[3];
                totalLine++;
                mapOfItemType.put(items[0], items[3]);
                mapOfItemPrice.put(items[0], new BigDecimal(items[2]));
                mapOfItemNames.put(items[0], items[1]);
                mapOfItemAmount.put(items[0], 6);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file is not exist");
        }
    }

    public void reduceMapOfItemAmount(String key) {
        this.mapOfItemAmount.put(key, getMapOfItemAmount().get(key) - 1);
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}

