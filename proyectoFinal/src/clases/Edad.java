/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author karrieta9
 */
public class Edad implements java.io.Serializable{
 private String edad;
 private Personas pasajero;   

    public Edad(String edad, Personas pasajero) {
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
 
 
 
 
 
 
 
 
 
 
 
}
