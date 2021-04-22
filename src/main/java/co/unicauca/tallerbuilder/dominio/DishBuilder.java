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
public abstract class DishBuilder {
    protected Dish dish;
    
    public Dish setDish(Dish dish) {
        this.dish = dish;
        return this.dish;
    }
    
    public Dish getDish() {
        return this.dish;
    }
    
    public abstract void setCore();
    
    public abstract void addParts();
    
    public abstract void setSize();
}
