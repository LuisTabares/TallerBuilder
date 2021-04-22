/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.dominio;

/**
 *
 * @author Luis Tabares
 */
public class Component {
    private int id;
    private String name;
    private int price;
    private EnumComponent type;
    
    public Component() {
        
    }
        
    public Component(int id, String name, int price, EnumComponent type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
        
    public void setPrice(int price) {
        this.price = price;
    }
            
    public void setType(EnumComponent type) {
        this.type = type;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPrice() {
        return this.price;
    }   
    
    public EnumComponent getType() {
        return this.type;
    }
}
