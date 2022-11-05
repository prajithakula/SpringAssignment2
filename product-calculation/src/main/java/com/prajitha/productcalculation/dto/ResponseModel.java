package com.prajitha.productcalculation.dto;

//for processPrice
public class ResponseModel {
    private int cartons;
    private int units;
    private double price;
    private int productId;
    private String name;
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCartons() {
        return cartons;
    }
    public void setCartons(int cartons) {
        this.cartons = cartons;
    }

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
