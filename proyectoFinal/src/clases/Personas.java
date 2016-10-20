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
   
    private String nombre;
    private String apellido ;
    private String cedula;
    private String origen;
    private String destino;

    public Personas(String nombre, String apellido, String cedula,String origen ,String destino) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.origen = origen;
        this.destino = destino;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDestino() {
        return destino;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

