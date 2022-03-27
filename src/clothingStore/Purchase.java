/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingStore;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Bogdan
 */
public class Purchase {
    private final Cart cart;
    private final LocalDateTime dateOfCreation;
    private final double subtotal;
    private final double totalDiscount;

    public Purchase(Cart cart, LocalDateTime dateOfCreation) {
        if(cart == null) { throw new IllegalArgumentException("No shopping cart provided to create purchase."); }
        if(dateOfCreation == null) { throw new IllegalArgumentException("Invalid date of purchase entered."); }
        
        this.dateOfCreation = dateOfCreation;
        
        setDiscounts(cart, this.dateOfCreation.getDayOfWeek());
        double totals[] = setTotals(cart);
        this.subtotal = totals[0];
        this.totalDiscount = totals[1];
        this.cart = cart;
    }
    
    public Purchase(Cart cart) {
        this(cart, LocalDateTime.now());
    }
    
    private static void setDiscounts(Cart cart, DayOfWeek dayOfWeek){
        for(int i=0; i<cart.productsCount(); i++){
            if(dayOfWeek == DayOfWeek.TUESDAY){
                if (cart.getProduct(i) instanceof Shoes){
                    cart.getProduct(i).getPrice().setDiscount(25);
                    continue;
                }
                else if(cart.getProduct(i) instanceof Shirt){
                    cart.getProduct(i).getPrice().setDiscount(10);
                }
            }
            if(cart.productsCount()>=3) {
                cart.getProduct(i).getPrice().setDiscount(20);
            }
        }
    }
    
    private static double[] setTotals(Cart cart){
        double totals[] = {0.00, 0.00};
        for(int i=0; i<cart.productsCount(); i++){
            totals[0]+= cart.getProduct(i).getPrice().getAmount();
            totals[1]+= cart.getProduct(i).getPrice().getDiscountAmount();
        }
        return totals;
    }
    
    public double Total () {
        return this.subtotal - this.totalDiscount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = "Date: "+this.dateOfCreation.format(formatObj)
                      +"\n---Products---\n"
                      +"\n"
                      +this.cart
                      +"\n-------------------------------------\n" 
                      +"\n" 
                      +"SUBTOTAL: "+this.subtotal+"\n" 
                      +"DISCOUNT: -"+String.format("%.2f", this.totalDiscount)+"\n" 
                      +"\n" 
                      +"TOTAL: "+this.Total();
        
        return text;
    }
}
