/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lib.Input;
import model.Customer;

/**
 *
 * @author tranh
 */
public class CustomerDAO implements IDAOCustomer{
    private final String FILENAME = "customers.txt";
    private final String PHONENUMBER = "^\\d{10,12}$";
    static Map<String, Customer> customers;

    public CustomerDAO() {
        customers = ReadFile();
    }        
    
    public boolean CheckIDExist(String ID){
        return customers.containsKey(ID);
    }
    
    public boolean CheckCustomerExist(String ID, String name, String address, String phone){
        Collection<Customer> data = customers.values();
        for (Customer customer : data) {
            if(ID.equals(customer.getCustomerID()))
                return false;
        }
        return true;
    }
    
    @Override
    public Map<String, Customer> ReadFile() {
        Map<String, Customer> data = new HashMap<>();
        try {
            FileReader fr = new FileReader(FILENAME);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {                
                line = br.readLine();
                if(line == null) break;
                
                String txt[] = line.split(",");
                String ID = txt[0];
                String Name = txt[1];
                String Address = txt[2];
                String Phone = txt[3];
                data.put(ID, new Customer(ID, Name, Address, Phone));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Customer search(String ID) {
        return customers.get(ID);
    }

    @Override
    public void create() {
        String ID = Input.read_pattern("ID [Cxxx]: ", "Must be correct format!", "^[cC]\\d{3}$").toUpperCase();
        String name = Input.input_String("Name: ", "Required to fill in information").toUpperCase();
        String address = Input.input_String("Address: ", "Required to fill in information").toUpperCase();
        String phone = Input.read_pattern("Phone number: ", "Only 10 or 12 number!", PHONENUMBER);
        Customer customer = new Customer(ID, name, address, phone);
        if(CheckCustomerExist(ID, name, address, phone)){
            customers.put(ID, customer);
            System.out.println("Add successfully.");
        } else System.out.println("This record is existed.");
        
    }

    @Override
    public boolean update(String ID) {
        Customer customer = search(ID);
        if(customer == null) return false;
        //input new field
        String updateName = Input.updateString("Name: ", customer.getCustomerName());
        String updateAddress = Input.updateString("Address: ", customer.getCustomerAddress());
        String updatePhone = Input.updateStringPattern("Phone: ", "Only 10 or 12 number!", PHONENUMBER, customer.getCustomerPhone());
        
        //set update
        customer.setCustomerName(updateName);
        customer.setCustomerAddress(updateAddress);
        customer.setCustomerPhone(updatePhone);
        WriteFile();
        return true;
    }

    @Override
    public void WriteFile() {
        ArrayList<Customer> data = new ArrayList<>();
        data.addAll(customers.values());
        try { 
            FileWriter fw = new FileWriter(FILENAME);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Customer customer : data) {
                bw.write(customer.toString());
                bw.newLine();
            }
            
            bw.close();
            fw.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }              

    @Override
    public boolean remove(String ID) {
        Customer customer = customers.remove(ID);
        if (customer == null) return false;
        else return true;
    }

    @Override
    public void PrintAll() {
        Map<String, Customer> data = ReadFile();
        Collection<Customer> list = data.values();
        for (Customer customer : list) {
            System.out.println(customer.toString());
        }
    }

    
}
