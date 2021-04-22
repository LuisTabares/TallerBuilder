/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.access;

import co.unicauca.tallerbuilder.dominio.Component;
import java.util.ArrayList;

/**
 *
 * @author Luis Tabares
 */
public interface IComponentRepository {
    
    public boolean saveComponent(Component component);
    
    public ArrayList<Component> getComponents();
    
    public Component findComponent(int id);
    
}
