/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.dominio;

import co.unicauca.tallerbuilder.access.IComponentRepository;
import java.util.ArrayList;

/**
 *
 * @author Luis Tabares
 */
public class ComponentService {
    
    private final IComponentRepository service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo ICustomerService
     */
    public ComponentService(IComponentRepository service) {
        this.service = service;
    }


    public boolean saveComponent(Component component) throws Exception {
        return service.saveComponent(component);

    }
    
    public ArrayList<Component> getComponents() throws Exception {
        return service.getComponents();

    } 
    
    public Component findComponent(int id) throws Exception {
        return service.findComponent(id);
    }
}
