/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author karrieta9
 */
public class Edad extends Personas{
 private String edad;
 private Personas pasajero;   

    public Edad(String cedula, String nombre, String apellido, String origen,String sexo,String edad, Personas pasajero) {
        super(cedula,nombre,apellido,origen,sexo);
        this.edad = edad;
        this.pasajero = pasajero;
    }
    
    

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Personas getPasajero() {
        return pasajero;
    }

    public void setPasajero(Personas pasajero) {
        this.pasajero = pasajero;
    }
    
    
 
 public void guardar(ObjectOutputStream salida) throws IOException{
      salida.writeObject(this);
        
    }
 
 
 
 
 
 
 
 
 
}
