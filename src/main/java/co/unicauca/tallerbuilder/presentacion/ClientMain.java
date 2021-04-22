/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.presentacion;

import co.unicauca.tallerbuilder.access.Factory;
import co.unicauca.tallerbuilder.access.IComponentRepository;
import co.unicauca.tallerbuilder.dominio.Component;
import co.unicauca.tallerbuilder.dominio.ComponentService;
import co.unicauca.tallerbuilder.dominio.Dish;
import co.unicauca.tallerbuilder.dominio.DishBuilder;
import co.unicauca.tallerbuilder.dominio.DishDirector;
import co.unicauca.tallerbuilder.dominio.EnumComponent;
import co.unicauca.tallerbuilder.dominio.OrientalDishBuilder;

/**
 *
 * @author Luis Tabares
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        ClientMain.insertInitialComponents();
        
        ClientMain.probarImplementacionPlatoOriental();
        
        //ClientMain.probarImplementacionPlatoItaliano();
    }

    public static void insertInitialComponents() throws Exception {
        //Creando componentes iniciales
        IComponentRepository repo = Factory.getInstance().getCustomerService();
        ComponentService componentService = new ComponentService(repo);
        
        Component component = new Component(16, "Lumpia", 5000, EnumComponent.ENTRY);
        componentService.saveComponent(component);
        
        component = new Component(17, "East rice", 8000, EnumComponent.BASE);
        componentService.saveComponent(component);
        
        component = new Component(18, "Fry shrimp", 7000, EnumComponent.COMPANION);
        componentService.saveComponent(component);
        
        component = new Component(19, "Squid rings", 8000, EnumComponent.COMPANION);
        componentService.saveComponent(component);
        
        component = new Component(20, "Green tea", 4000, EnumComponent.DRINK);
        componentService.saveComponent(component);
        
        component = new Component(21, "Nian Gao", 8000, EnumComponent.DESSERT);
        componentService.saveComponent(component);
    }

    private static void probarImplementacionPlatoOriental() {
        System.out.println("Creando arroz oriental");
        DishDirector director = new DishDirector();
        DishBuilder orientalDishBuilder = new OrientalDishBuilder();
        director.setDishBuilder(orientalDishBuilder);
        director.buildDish();
        
        Dish dish = director.getDish();
        System.out.println("\nImprimiendo arroz oriental: "
                           + "\nNombre: " + dish.getName()
                           + "\nDescripcion: " + dish.getDescription()
                           + "\nImagen: " + dish.getImage()
                           + "\nTamaño: " + dish.getSize()
        );
        System.out.println("Sus partes: " + dish.getPartsNames());
        System.out.println("Precio de las partes: " + dish.calculatePriceParts());
    }

    private static void probarImplementacionPlatoItaliano() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
