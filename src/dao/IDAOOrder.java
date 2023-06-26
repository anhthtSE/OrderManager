/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.Map;
import model.Order;

/**
 *
 * @author tranh
 */
public interface IDAOOrder {
    Map<String, Order> ReadFile();    
    void create();
    boolean update(String ID) throws IOException;
    boolean remove(String ID) throws IOException;
    void WriteFile();
    boolean checkID(String ID) throws IOException;
    boolean checkOrderExist(String orderID, String customerID, String productID,
            int orderQuantity, boolean status, String orderDate) throws IOException;
    void printAll();

}
