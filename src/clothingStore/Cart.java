/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingStore;

import java.util.ArrayList;

/**
 *
 * @author Bogdan
 */
public class Cart {
    private final ArrayList<Product> products = new ArrayList<>();
    
    public void addProduct (Product p){
        if(p != null){
            products.add(p);
        }
        else{
            throw new IllegalArgumentException("Invalid product can't be added to cart.");
        }
    }
    
    public void removeProduct (Product p){
        if(p != null){
            products.remove(p);
        }
        else{
            throw new IllegalArgumentException("Invalid product reference can't be used for removing product from cart.");
        }
    }

    public Product getProduct(int index) {
        if(index < 0) throw new IllegalArgumentException("Index of product in cart can't be negative.");
        return products.get(index);
    }
    
    public int productsCount (){
        return products.size();
    }

    @Override
    public String toString() {
        String text = "";
        for(Product p : this.products) {
            text += p+"\n";
        }
        return text;
    }
    
    
}
