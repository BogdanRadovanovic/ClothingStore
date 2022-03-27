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
public abstract class Product {
    private String name;
    private String brand;
    private Price price;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Product name is not entered.");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand != null && !brand.trim().isEmpty()){
            this.brand = brand;
        }
        else{
            throw new IllegalArgumentException("Product brand is not entered.");
        }
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(this.price == null){
            this.price = new Price(price);
        }
        else{
            this.price.setAmount(price);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color != null && !color.trim().isEmpty()){
            this.color = color;
        }
        else{
            throw new IllegalArgumentException("Color of product is not entered");
        }
    }

    public Product(String name, String brand, double price, String color) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setColor(color);
    }

    @Override
    public String toString() {
        return this.name + " - " + this.brand + "\n" + this.price + "\n";
    }
    
    
}
