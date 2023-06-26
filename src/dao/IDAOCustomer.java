/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.Customer;

/**
 *
 * @author tranh
 */
public interface IDAOCustomer {
    Map<String, Customer> ReadFile();
    Customer search(String ID);
    void create();
    boolean update(String ID) throws IOException;
    boolean remove(String ID) throws IOException;
    void WriteFile();
    void PrintAll();
}
