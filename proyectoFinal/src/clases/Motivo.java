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
 * @author karrieta9
 */
public class Motivo extends Destino{
 private String motivo;

    public Motivo(String motivo, String destino, Personas pasajero) {
        super(destino, pasajero);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
 
public void guardar(ObjectOutputStream salida) throws IOException{
      salida.writeObject(this);
        
    } 
 
 
}
