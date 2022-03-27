/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingStore;

/**
 *
 * @author Bogdan
 */
public class Price {
    private double amount;
    private int discount = 0;
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        if(amount>0){
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("Price is not entered or it's negative value, which is forbidden.");
        }
    }

    public Price(double amount) {
        this.amount = amount;
    }
    
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if(discount>0){
            this.discount = discount;
        }
        else{
            throw new IllegalArgumentException("Discount is not entered or it's negative value, which is forbidden.");
        }
    }
    
    public double getDiscountAmount() {
        if(discount>0) return Math.ceil(amount/100*discount);
        else return 0;
    }
    
    public double getDiscountedPrice () {
        return this.amount-this.getDiscountAmount();
    }

    @Override
    public String toString() {
        String text = "$"+this.amount;
        if(this.discount>0) {
            text+="\n#discount "+this.discount+"% -$"+String.format("%.2f", this.getDiscountAmount());
        }
        return text;
    }
}
