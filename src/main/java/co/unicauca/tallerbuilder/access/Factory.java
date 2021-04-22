/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.access;

import co.unicauca.tallerbuilder.infra.Utilities;

/**
 *
 * @author Luis Tabares
 */
public class Factory {
    
    private static Factory instance;
    
     /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }
    
        /**
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IComponentRepository getCustomerService() {

        IComponentRepository result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "sqlite":
                result = new ComponentRepository();
                break;
        }

        return result;

    }
}
