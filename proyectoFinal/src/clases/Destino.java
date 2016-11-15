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
 * @author sony
 */
public class Destino implements java.io.Serializable{
 private String destino;
 private Personas pasajero;

    public Destino(String destino, Personas pasajero) {
        this.destino = destino;
        this.pasajero = pasajero;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
