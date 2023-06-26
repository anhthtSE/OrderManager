/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.Map;
import model.Product;

/**
 *
 * @author tranh
 */
public interface IDAOProduct {
    boolean checkIDExist(String ID) throws IOException;
    boolean checkProductExist (String productID, String productName, String unit,
            String origin, double price) throws IOException;
    void printAll();
    Map<String, Product> ReadFile();
    void create();
}
