package com.prajitha.productcalculation.model;

import javax.persistence.*;

//for database creation
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int initialCartonCount;
    private double initialCartonPrice;
    private double discountCartonPrice;
    private double singleUnitPrice;

    public Product(){

    }

    public Product(String productName, int initialCartonCount, double initialCartonPrice, double discountCartonPrice, double singleUnitPrice) {
        this.productName = productName;
        this.initialCartonCount = initialCartonCount;
        this.initialCartonPrice = initialCartonPrice;
        this.discountCartonPrice = discountCartonPrice;
        this.singleUnitPrice = singleUnitPrice;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getInitialCartonCount() {
        return initialCartonCount;
    }

    public void setInitialCartonCount(int initialCartonCount) {
        this.initialCartonCount = initialCartonCount;
    }
    public double getInitialCartonPrice() {
        return initialCartonPrice;
    }

    public void setInitialCartonPrice(double initialCartonPrice) {
        this.initialCartonPrice = initialCartonPrice;
    }
    public double getDiscountCartonPrice() {
        return discountCartonPrice;
    }

    public void setDiscountCartonPrice(double discountCartonPrice) {
        this.discountCartonPrice = discountCartonPrice;
    }
    public double getSingleUnitPrice() {
        return singleUnitPrice;
    }

    public void setSingleUnitPrice(double singleUnitPrice) {
        this.singleUnitPrice = singleUnitPrice;
    }
}
