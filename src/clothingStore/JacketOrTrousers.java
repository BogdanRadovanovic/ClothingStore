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
public abstract class JacketOrTrousers extends Product {
    private int size; 

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size>=42 && size<=66 && size%2==0){
            this.size = size;
        }
        else{
            throw new IllegalArgumentException(this.productName()+" size is not in the good format.");
        }
    }
    
    public abstract String productName();

    public JacketOrTrousers(int size, String name, String brand, double price, String color) {
        super(name, brand, price, color);
        this.setSize(size);
    }
}
