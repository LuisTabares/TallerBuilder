/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.tallerbuilder.dominio;

import co.unicauca.tallerbuilder.access.Factory;
import co.unicauca.tallerbuilder.access.IComponentRepository;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Tabares
 */
public class OrientalDishBuilder extends DishBuilder {

    public OrientalDishBuilder(){
        Dish orientalDish = new OrientalDish();
        this.setDish(orientalDish);
    }
    
    @Override
    public void setCore() {
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.println("Por favor ingrese el nombre del plato: ");
            String dishName = in.nextLine().trim();
            this.getDish().setName(dishName);
            if (this.getDish().getName().isEmpty()){
                System.out.println("Debe ingresar un valor");
            }
        } while (this.getDish().getName().isEmpty());
        
        do {
            System.out.println("Por favor ingrese la descripcion del plato: ");
            String dishDescription = in.nextLine().trim();
            this.getDish().setDescription(dishDescription);
            if (this.getDish().getDescription().isEmpty()){
                System.out.println("Debe ingresar un valor");
            }
        } while (this.getDish().getDescription().isEmpty());
        
        do {
            System.out.println("Por favor ingrese la direccion de la foto del plato: ");
            String dishImage = in.nextLine().trim();
            this.getDish().setImage(dishImage);
            if (this.getDish().getImage().isEmpty()){
                System.out.println("Debe ingresar un valor");
            }
        } while (this.getDish().getImage().isEmpty());
    }

    @Override
    public void addParts() {
        
        String mensaje = ("Por favor ingrese el id de la entrada, o oprima enter para no agregarla");
        this.addPart(mensaje);
        
        
        while (true) {
            mensaje = ("Por favor ingrese el id de la base");
            if (this.addPart(mensaje)) {
                break;
            }
            else {
                System.out.println("Debe agregar una base");
            }
        }
               
        boolean agregarOtro = true;
        while (agregarOtro) {
            mensaje = ("Por favor ingrese el nombre de un acompañante, o oprima enter para no agregar mas acompañantes");
            if (!this.addPart(mensaje)) {
                agregarOtro = false;
            }
        }
        
        mensaje = ("Por favor ingrese el id de la bebida, o oprima enter para no agregarla");
        this.addPart(mensaje);
        
        mensaje = ("Por favor ingrese el id del postre, o oprima enter para no agregarlo");
        this.addPart(mensaje);
    }

    @Override
    public void setSize() {
        Scanner in = new Scanner(System.in);
        
        while (this.getDish().getSize() == null) {
            System.out.println("Por favor ingrese el tamaño del plato: ALL - HALF");
            String dishSize = in.nextLine().trim().toUpperCase();
            try {
                this.getDish().setSize(EnumSize.valueOf(dishSize));
            } catch (Exception e) {
                System.out.println("El valor ingresado no corresponde a un tamaño");
            }
        }
    }

    private boolean addPart(String mensaje) {
        boolean partAdded = false;
        
        IComponentRepository repo = Factory.getInstance().getCustomerService();
        ComponentService componentService = new ComponentService(repo);
        
        Scanner in = new Scanner(System.in);
        
        System.out.println(mensaje);
        String respuesta = in.nextLine().trim();
        
        try {
            if (StringUtils.isNumeric(respuesta)) {
                Component part = null;
                int partId = Integer.parseInt(respuesta);
                part = componentService.findComponent(partId);
                if (part != null) {
                    this.getDish().addPart(part);
                    partAdded = true;
                }
                else {
                    System.out.println("El valor ingresado no es un id valido");
                    partAdded = this.addPart(mensaje);
                }
            }
            else if (respuesta.isEmpty()) {
                System.out.println("Parte no agregada");
            }
            else {
                System.out.println("El valor que ingreso no es numerico");
                partAdded = this.addPart(mensaje);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrientalDishBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return partAdded;
    }
}
