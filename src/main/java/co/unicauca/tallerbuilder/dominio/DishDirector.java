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
public class DishDirector {
    private DishBuilder dishBuilder;
    
    public DishDirector setDishBuilder(DishBuilder dishBuilder) {
        this.dishBuilder = dishBuilder;
        return this;
    }
    
    public Dish getDish() {
        return dishBuilder.getDish();
    }
    
    public void buildDish() {
        dishBuilder.setCore();
        dishBuilder.addParts();
        dishBuilder.setSize();
    }
}
