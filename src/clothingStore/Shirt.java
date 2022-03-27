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
public class Shirt extends Product{
    private String size; 
    private static final String[] SIZES = {"XS", "S", "M", "L", "XL", "2XL", "XXL"};

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if(size != null && !size.isEmpty()){
            size = size.toUpperCase();
            for(String s : SIZES){
                if(size.equals(s)) { 
                    this.size = size; 
                    break;
                }
            }
            if(this.size == null) throw new IllegalArgumentException("Shirt size is not in the good format.");
        }
        else{
            throw new IllegalArgumentException("Shirt size is not entered.");
        }
        
    }

    public Shirt(String size, String name, String brand, double price, String color) {
        super(name, brand, price, color);
        setSize(size);
    }
    
    
}
