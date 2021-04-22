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
public class OrientalDish extends Dish{
    private String orientalName;
    
    public Dish setOrientalName(String orientalName) {
        this.orientalName = orientalName;
        return this;
    }
    
    public String getOrientalName() {
        return this.orientalName;
    }
}
