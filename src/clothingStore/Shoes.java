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
public class Shoes extends Product {
    private int size;
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size>=39 && size<=46){
            this.size = size;
        }
        else{
            throw new IllegalArgumentException("Shoe size is not in the good format.");
        }
    }

    public Shoes(int size, String name, String brand, double price, String color) {
        super(name, brand, price, color);
        setSize(size);
    }
    
    
}
