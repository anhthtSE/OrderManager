/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author tranh
 */
public class Order {
    public String orderID, customerID, productID, nameCustomer;
    private int orderQuantity;
    private boolean status;
    private String orderDate;
    
    //Contructor

    public Order() {
        orderID = null;
        customerID = null;
        productID = null;
        orderQuantity = 0;
        orderDate = null;
    }

    public Order(String orderID, String customerID, String productID, int orderQuantity, String orderDate, boolean status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.orderQuantity = orderQuantity;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Order(String orderID, String customerID, String productID, String nameCustomer, int orderQuantity, boolean status, String orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.nameCustomer = nameCustomer;
        this.orderQuantity = orderQuantity;
        this.status = status;
        this.orderDate = orderDate;
    }   

    //Getter
    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getProductID() {
        return productID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public boolean isStatus() {
        return status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }        

    //Setter
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Override
    public String toString() {
        return orderID + "," + customerID + "," + productID + "," 
                + orderQuantity+ "," + orderDate + "," + status;
    }
    
    public String toStringbyName(){
        return orderID + "," + customerID + "," + nameCustomer + "," + productID
                + "," + status + "," + orderDate;
    }
}
