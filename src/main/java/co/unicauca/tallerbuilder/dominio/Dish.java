/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.dominio;

import java.util.ArrayList;

/**
 *
 * @author Luis Tabares
 */
public class Dish {
    private String name;
    private String description;
    private String image;
    private int price;
    private EnumSize size;
    private ArrayList<Component> parts;
    
    public Dish() {
        parts = new ArrayList<Component>();
    }
    
    public Dish setName(String name) {
        this.name = name;
        return this;
    }
    
    public Dish setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public Dish setImage(String image) {
        this.image = image;
        return this;
    }
    
    public Dish setSize(EnumSize size) {
        this.size = size;
        return this;
    }
    
    public Dish addPart(Component part) {
        this.parts.add(part);
        return this;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getImage() {
        return this.image;
    }
    
    public int getPrice() {
        return this.calculatePriceParts();
    }
    
    public EnumSize getSize() {
        return this.size;
    }
    
    public String getPartsNames() {
        String partsNames = "";
        for (Component part : parts) {
            partsNames += part.getName() + ", " ;
        }
        return partsNames;
    }
    
    public ArrayList<Component> getParts(){
        return this.parts;
    }

    public int calculatePriceParts() {
        int partsPrice = 0;
        for (Component part : parts) {
            int price = part.getPrice();
            
            //Si es una porcion media el valor se divide a la mitad solo si es una base o un acompañante
            //Porque la bebida, el postre y la entrada son porciones enteras asi el plato sea medio
            if (this.getSize() == EnumSize.HALF) {
                if (part.getType() == EnumComponent.BASE  || part.getType() == EnumComponent.COMPANION) {
                    price /= 2;
                }
            }
            
            partsPrice += price;
        }
        return partsPrice;
    }
}
