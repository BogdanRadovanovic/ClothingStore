/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingStore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Bogdan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static void ExampleBase(Cart cart, String dateString){
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateOfPurchase = LocalDateTime.parse(dateString, formatObj);
        
        Purchase purchase = new Purchase(cart, dateOfPurchase);
        
        Cashier cashier = new Cashier();
        cashier.printReceipt(purchase);
    }
    
    static void Example1() {
        Cart cart = new Cart();
        cart.addProduct(new Shirt("M", "Blue Cotton Shirt", "BrandS", 14.99, "blue"));
        cart.addProduct(new Shirt("M", "White Cotton Shirt", "BrandS", 15.99, "white"));
        cart.addProduct(new Trousers(50, "Black Cotton Trousers", "BrandT", 29.99, "black"));
        cart.addProduct(new Shoes(43, "Black Leather Shoes", "BrandS", 59.99, "black"));
        cart.addProduct(new Jacket(50, "Black Cotton Suit Jacket", "BrandJ", 99.99, "black"));
        
        ExampleBase(cart, "2022-02-02 12:34:56");
    }
    
    static void Example2() {
        Cart cart = new Cart();
        cart.addProduct(new Shirt("L", "Black Silk Shirt", "BrandS", 29.99, "black"));
        cart.addProduct(new Shirt("L", "White Silk Shirt", "BrandS", 29.99, "white"));
        
        ExampleBase(cart, "2022-02-01 12:34:56");
    }
    
    static void Example3() {
        Cart cart = new Cart();
        cart.addProduct(new Trousers(56, "Red Linen Trousers", "BrandT", 49.99, "red"));
        cart.addProduct(new Shoes(44, "Red Suede Shoes", "BrandS", 59.99, "red"));
        cart.addProduct(new Shoes(44, "Black Suede Shoes", "BrandS", 59.99, "black"));
        cart.addProduct(new Jacket(56, "Red Linen Suit Jacket", "BrandJ", 99.99, "red"));
        cart.addProduct(new Shirt("L", "White Linen Shirt", "BrandS", 29.99, "white"));
        
        ExampleBase(cart, "2022-02-01 12:34:56");
    }
    
    public static void main(String[] args) {
        try{
            Example1();
            
            System.out.println("\n-----------------------------------------------------------------------------------\n");
            System.out.println("-----------------------------------------------------------------------------------\n");
            System.out.println("-----------------------------------------------------------------------------------\n");
            
            Example2();
            
            System.out.println("\n-----------------------------------------------------------------------------------\n");
            System.out.println("-----------------------------------------------------------------------------------\n");
            System.out.println("-----------------------------------------------------------------------------------\n");
            
            Example3();
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
