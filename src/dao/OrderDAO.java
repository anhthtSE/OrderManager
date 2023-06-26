
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.print.Collation;
import lib.Input;
import model.Customer;
import model.Order;
import model.Product;

/**
 *
 * @author tranh
 */
public class OrderDAO implements IDAOOrder{
    private final String FILENAME = "orders.txt";
    public DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
    
    public Map<String, Order> orders = new HashMap<>();
    CustomerDAO customers = new CustomerDAO();   
    ProductDAO products = new ProductDAO();
    Order order = new Order();

    public OrderDAO(){
        orders = ReadFile();
    }
      
    @Override
    public Map<String, Order> ReadFile(){
        Map<String, Order> data = new HashMap<>();
        try {
            FileReader fr = new FileReader(FILENAME);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {     
                line = br.readLine();
                if(line == null) break;
                String txt[] = line.split(",");
                String orderID = txt[0];
                String customerID = txt[1];
                String productID = txt[2];
                int orderQuantity = Integer.parseInt(txt[3]);
                String orderDate = txt[4];
                boolean status = Boolean.parseBoolean(txt[5]);
                data.put(orderID, new Order(orderID, customerID,
                            productID, orderQuantity, orderDate,status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    

    @Override
    public void create() {
        String orderID = Input.read_pattern("ID [Dxxx]: ", "Must be correct format!", "^[dD]\\d{3}$").toUpperCase();
        String customerID = null, productID = null;        
        int orderQuantity = Input.input_Int_min_max("Quantity: ", "Must be integer number!", 0, Integer.MAX_VALUE);
        Date date = Input.readDMY("Date ");
        String orderDate = dateFormat.format(date);
        boolean status  = Input.yes_no("Status (T/F): ", "t", "f");
        
        Order order = new Order(orderID, customerID, productID, orderQuantity, orderDate, status);
        orders.put(orderID, order);
        
        System.out.println("------------List customer----------");
        customers.PrintAll();
        customerID = Input.read_pattern("ID [Cxxx]: ", "Must be correct format!", "^[cC]\\d{3}$").toUpperCase();
        do {
            order.setCustomerID(customerID);
        } while (!customers.CheckIDExist(customerID));
        
        
        System.out.println("------------List product----------");
        products.printAll();
        productID = Input.read_pattern("ID [Pxxx]: ", "Must be correct format!", "^[pP]\\d{3}$").toUpperCase();
        do {
            order.setProductID(productID);
        } while (!products.checkIDExist(productID));
        orders.put(orderID, order);
        System.out.println("Add successfully.");
        
    }

    @Override
    public boolean update(String ID) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String ID) throws IOException {
        Order order = orders.remove(ID);
        if(order == null) return false;
        return true;
    }

    @Override
    public void WriteFile() {
        ArrayList<Order> data = new ArrayList<>();
        data.addAll(orders.values());
        try {
            FileWriter fw = new FileWriter(FILENAME);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Order order : data) {
                bw.write(order.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkID(String ID) throws IOException {
        return orders.containsKey(ID);
    }

    @Override
    public void printAll() {
        Map<String, Order> data = ReadFile();                
        Collection<Order> list = data.values();
        //setNameCustomer in order
        for (Order order : list) {
            String nameCustomer;
            if(customers.CheckIDExist(order.getCustomerID())){
                nameCustomer = customers.customers.get(order.getCustomerID()).getCustomerName();
                order.setNameCustomer(nameCustomer);
            }
        }         
        //Convert map to list
        List<Map.Entry<String, Order>> MapToList = new ArrayList<>(data.entrySet());
        
        //Create a comparator to sort by value
        Comparator<Map.Entry<String, Order>> comparator = new Comparator<Map.Entry<String, Order>>() {
            @Override
            public int compare(Map.Entry<String, Order> o1, Map.Entry<String, Order> o2) {
                return o1.getValue().getNameCustomer().compareTo(o2.getValue().getNameCustomer());
            }
        };
        //Sort value
        Collections.sort(MapToList, comparator);
        //Convert list to map
        Map<String, Order> sortMap = new LinkedHashMap<>();
        for (Map.Entry<String, Order> entry : MapToList) {
            sortMap.put(entry.getKey(), entry.getValue());
        }
       
        Collection<Order> dataAfterSort = sortMap.values();
        for (Order order : dataAfterSort) {
            System.out.println(order.toStringbyName());
        }
        
    }

    @Override
    public boolean checkOrderExist(String orderID, String customerID, String productID, int orderQuantity, boolean status, String orderDate) throws IOException {
        Collection<Order> data = orders.values();
        for (Order order : data) {
            if(orderID.equals(order.getOrderID())) return false;
        }
        return true;
    }

}
