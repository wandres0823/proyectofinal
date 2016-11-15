/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author walbonis1
 */
public class Personas implements java.io.Serializable{
   
    private String cedula;
    private String nombre;
    private String apellido;
    private String origen;
   

    public Personas(String cedula, String nombre, String apellido, String origen) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.origen = origen;
       
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void guardar(ObjectOutputStream salida) throws IOException{
      salida.writeObject(this);
        
    }
}


