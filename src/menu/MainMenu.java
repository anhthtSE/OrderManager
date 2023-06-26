/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lib.Input;
import lib.Menu;
import model.Customer;
import model.Order;
import model.Product;

/**
 *
 * @author tranh
 */
public class MainMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();        
        CustomerDAO customers = new CustomerDAO();
        ProductDAO products = new ProductDAO();
        OrderDAO orders = new OrderDAO();
        int choice=0;
        boolean yesorno;
        do {
            String[] options = {"List all Products","List all Customers",
            "Search a Customer based on his/her ID","Add a Customer",
            "Update a Customer","Save Customers to the file",
            "List all Orders in ascending order of Customer name",
            "List all pending Orders","Add an Order","Update an Order",
            "Save Orders to file","Quit"};
            
            try {
                choice = menu.getChoice(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            switch(choice){
                case 1:                    
                    do {
                        Map<String, Product> data = products.ReadFile();
                        Collection<Product> list = data.values();
                        for (Product product : list) {
                            System.out.println(product);
                        }
                        yesorno = Input.yes_no("Do you want to back menu(Y/N): ");
                    } while (!yesorno);
                    break;
                case 2:
                    do {
                        Map<String, Customer> data = customers.ReadFile();
                        Collection<Customer> list = data.values();
                        for (Customer customer : list) {
                            System.out.println(customer);
                        }
                        yesorno = Input.yes_no("Do you want to back menu(Y/N): ");
                    } while (!yesorno);
                    break;
                case 3:
                    do {     
                        String findID = Input.read_pattern("ID [Cxxx]: ", "Must be correct format!", "^[cC]\\d{3}$").toUpperCase();
                        Customer result = customers.search(findID);
                        if(result == null) System.out.println("This customer does not exist");
                        else System.out.println(result);
                        
                        yesorno = Input.yes_no("Do you want to back menu(Y/N): ");
                    } while (!yesorno);
                    break;
                case 4:
                    do {                        
                        customers.create();
                        customers.WriteFile();
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                case 5:
                    do {                        
                        String findID = Input.read_pattern("Search Customer's ID [Cxxx]: ", "Must be correct format!", "^[cC]\\d{3}$").toUpperCase();
                        if(!customers.CheckIDExist(findID)) System.out.println("“Customer does not exist");
                        else {
                            if(customers.update(findID)) System.out.println("Update successfully."); 
                            else System.out.println("Update Fail.");
                        }                        
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);                    
                    break;
                case 6:
                    do {                        
                        customers.WriteFile();
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                case 7:
                    do {               
                        orders.printAll();
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                case 8:
                    do {               
                        Map<String, Order> data = orders.ReadFile();
                        Collection<Order> list = data.values();
                        for (Order order : list) {
                            System.out.println(order.toString());
                        }
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                case 9:
                    do {               
                        orders.create();
                        orders.WriteFile();
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                case 10:
                    break;
                case 11:
                    do {                        
                        orders.WriteFile();
                        yesorno = Input.yes_no("Do you want to continue(Y/N): ");
                    } while (yesorno);
                    break;
                default:
                    System.out.println("Thanks for using");
                    break;
            }
                    
        } while (choice>=0 && choice<12);
        
    }
}
