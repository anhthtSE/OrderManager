/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lib.Input;
import model.Product;

/**
 *
 * @author tranh
 */
public class ProductDAO implements IDAOProduct{
    private final String FILENAME = "products.txt";
    Map<String, Product> products;

    public ProductDAO() {
        products = ReadFile();
    }    
    
    @Override
    public Map<String, Product> ReadFile() {
        Map<String, Product> data = new HashMap<>();
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
                String unit = txt[2];
                String origin = txt[3];
                Double price = Double.parseDouble(txt[4]);
                data.put(ID, new Product(ID, Name, unit, origin, price));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void printAll() {
        Map<String, Product> data = ReadFile();
        Collection<Product> list = data.values();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    @Override
    public boolean checkIDExist(String ID) {
        return products.containsKey(ID);
    }

    @Override
    public boolean checkProductExist(String productID, String productName, String unit, String origin, double price) throws IOException {
        Collection<Product> data = products.values();
        for (Product product : data) {
            if (productID.equals(product.getProductID())) 
                return false;
        }
        return true;
    }

    @Override
    public void create() {
        String productID = Input.read_pattern("ID [Pxxx]: ", "Must be correct format!", "^[pP]\\d{3}$").toUpperCase();
        String productName = Input.input_String("Name: ","No special character.");
        String unit = Input.input_String("Unit: ","No special character.");
        String origin = Input.input_String("Origin: ","No special character.");
        double price = Input.input_Double_min_max("Price: ", "Must be more than 0.", 1, Integer.MAX_VALUE);
        
    }
    
}
