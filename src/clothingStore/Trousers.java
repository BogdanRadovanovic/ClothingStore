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
public class Trousers extends JacketOrTrousers {
    
    public Trousers(int size, String name, String brand, double price, String color) {
        super(size, name, brand, price, color);
    }

    @Override
    public String productName() {
        return "Trousers";
    }
    
}
