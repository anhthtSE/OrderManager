/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tranh
 */
public class Product {
    public String productID;
    private String productName, unit, origin;
    private double price;

    //contructor
    public Product() {
        productID = "";
        productName = "";
        unit = "";
        origin = "";
        price = 0;
    }
    
    public Product(String productID, String productName, String unit, String origin, double price) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.origin = origin;
        this.price = price;
    }
    
    //Getter
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnit() {
        return unit;
    }

    public String getOrigin() {
        return origin;
    }

    public double getPrice() {
        return price;
    }
    
    //Setter

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productID + "," + productName +","+ unit + "," + origin +"," + price;
    }
    
    
}
