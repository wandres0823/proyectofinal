/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author walbonis1
 */
public class Helper {
  public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }

    public static void limpiadoTabla(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);
            }
        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }

    public static int cantidadPares(JTable tabla1) {
        int nf, nc, aux, cont = 0;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void pares(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void letraC(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (i == 0 || i == nf - 1 || j == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void diagonalPrincipal(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (i == j) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void letraH(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (j == 0 || j == nc - 1 || i == (nf - 1) / 2) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static int[][] pasoDeDatos(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        int m[][] = new int[nf][nc];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                m[i][j] = (int) tabla1.getValueAt(i, j);
            }

        }
        return m;

    }

    public static String recorridoHaciaArriba(int[][] m, int j) {
        int nf = m.length;
        String aux = "";
        for (int i = nf - 1; i >= 0; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
     public static String recorridoHaciaArriba(int[][] m, int j, int in, int fin) {
      
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoHaciaAbajo(int[][] m, int j) {
        int nf = m.length;
        String aux = "";
        for (int i = 0; i < nf; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
     public static String recorridoHaciaAbajo(int[][] m, int j, int in, int fin) {
      
        String aux = "";
        for (int i = in; i < fin; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoUno(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nc = m[0].length;
        String aux = "";
        for (int j = 0; j < nc; j++) {
            if (j % 2 == 0) {
                aux = aux + Helper.recorridoHaciaArriba(m, j);
            } else {
                aux = aux + Helper.recorridoHaciaAbajo(m, j);
            }
        }
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoHaciaIzquierda(int[][] m, int i) {
        int nc = m[0].length;
        String aux = "";
        for (int j = nc-1; j >= 0; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
     public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {
        
        String aux = "";
        for (int j =in; j >= fin; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    public static String recorridoHaciaDerecha(int[][] m, int i) {
        int nc = m[0].length;
        String aux = "";
        for (int j = 0; j < nc; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
    public static String recorridoHaciaDerecha(int[][] m, int i,int in, int fin) {
       
        String aux = "";
        for (int j = in; j < fin; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
    public static String recorridoDos(JTable tabla1){
        int m[][] = pasoDeDatos(tabla1);
        int nf = m.length;
        String aux="";
        for (int i = 0; i < nf; i++) {
            if(i%2==0){
                aux=aux+ recorridoHaciaIzquierda(m, i);
            }else{
                aux=aux+recorridoHaciaDerecha(m, i);
            }
            
        }
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static void llenarTabla(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList<Personas> personas = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = personas.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(i+1, i, 0);
           tabla.setValueAt(personas.get(i).getCedula(), i, 1);
           tabla.setValueAt(personas.get(i).getNombre(), i, 2);
           tabla.setValueAt(personas.get(i).getApellido(), i, 3);
           tabla.setValueAt(personas.get(i).getOrigen(), i, 4);
           tabla.setValueAt(personas.get(i).getSexo(), i, 5);
          
        }
    }
    
     public static void llenarTablaDestinos(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList<Destino> destinos = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = destinos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(i+1, i, 0);
           tabla.setValueAt(destinos.get(i).getPasajero().getCedula(), i, 1);
           tabla.setValueAt(destinos.get(i).getPasajero().getNombre(), i, 2);
           tabla.setValueAt(destinos.get(i).getPasajero().getApellido(), i, 3);
           tabla.setValueAt(destinos.get(i).getPasajero().getOrigen(), i, 4);
          
        }
    }
    public static void llenarTablaListado(JTable tabla, String ruta){
        DefaultTableModel tm;
        int nf;
        ArrayList<Destino> destinos = traerDatos(ruta);
        tm = (DefaultTableModel)tabla.getModel();
        limpiadoTabla(tabla);
        nf = destinos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
           tabla.setValueAt(i+1, i, 0);
           tabla.setValueAt(destinos.get(i).getPasajero().getCedula(), i, 1);
           tabla.setValueAt(destinos.get(i).getPasajero().getNombre(), i, 2);
           tabla.setValueAt(destinos.get(i).getPasajero().getApellido(), i, 3);
           tabla.setValueAt(destinos.get(i).getPasajero().getOrigen(), i, 4);
           tabla.setValueAt(destinos.get(i).getDestino(), i, 5);
        }
    }
    
    public static void llenarTabla(JTable tabla, ArrayList<Personas> personas) {
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = personas.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(personas.get(i).getCedula(), i, 1);
           tabla.setValueAt(personas.get(i).getNombre(), i, 2);
           tabla.setValueAt(personas.get(i).getApellido(), i, 3);
           tabla.setValueAt(personas.get(i).getOrigen(), i, 4);
           
        }
    }
    
    public static void llenarTablaOrigen(JTable tabla, ArrayList<Destino> destinos) {
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = destinos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i+1, i, 0);
            tabla.setValueAt(destinos.get(i).getPasajero().getCedula(), i, 1);
           tabla.setValueAt(destinos.get(i).getPasajero().getNombre(), i, 2);
           tabla.setValueAt(destinos.get(i).getPasajero().getApellido(), i, 3);
           tabla.setValueAt(destinos.get(i).getPasajero().getOrigen(), i, 4);
           tabla.setValueAt(destinos.get(i).getDestino(), i, 5);
        }
    }
    
    public static void llenarTablaDestino(JTable tabla, String ruta) {
        DefaultTableModel tm;
        int nf;
        ArrayList<Destino> destinos = traerDatos(ruta);
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = destinos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(destinos.get(i).getDestino(), i, 1);
            tabla.setValueAt(destinos.get(i).getPasajero().getCedula(), i, 2);
            tabla.setValueAt(destinos.get(i).getPasajero().getNombre(), i, 3);
            tabla.setValueAt(destinos.get(i).getPasajero().getApellido(), i, 4);
            tabla.setValueAt(destinos.get(i).getPasajero().getOrigen(), i, 5);
            tabla.setValueAt(destinos.get(i).getPasajero().getSexo(), i, 6);
        }
    }
    
    public static ArrayList traerDatos(String ruta){
        FileInputStream archivo;
        ObjectInputStream entrada;
        ArrayList personas = new ArrayList();
        Object p;
        
        try {
            archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            while((p=entrada.readObject())!=null){
                personas.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
             System.out.println(ex.getMessage());
        }
           return personas;
    } 
    
    public static void volcado(ObjectOutputStream salida,ArrayList personas ){
        for (int i = 0; i < personas.size(); i++) {
            try {
                salida.writeObject(personas.get(i));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }
public static boolean buscarPersonaCedula(String cedula, String ruta) {
        ArrayList<Personas> personas = traerDatos(ruta);
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
   }
    
    public static Personas traerPersonaCedula(String cedula, String ruta){
         ArrayList<Personas> personas = traerDatos(ruta);
         for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                return personas.get(i);
            }
            
        }
         return null;
    }
    
    public static ArrayList<Personas> modificarPersona(String ruta, String cedula,String nombre, String apellido,String origen){
         ArrayList<Personas> personas = traerDatos(ruta);
         for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getCedula().equals(cedula)){
                personas.get(i).setNombre(nombre);
                personas.get(i).setApellido(apellido);
                personas.get(i).setOrigen(origen);
                
              
                
                return personas;
            }
         
        }
         return null;
    } 
    
    public static ArrayList<Destino> modificarDestino(String ruta, String cedula,String destino,Personas propietario){
         ArrayList<Destino> destinos = traerDatos(ruta);
         for (int i = 0; i < destinos.size(); i++) {
            if(destinos.get(i).getPasajero().getCedula().equals(cedula)){
                destinos.get(i).setDestino(destino);
                destinos.get(i).setPasajero(propietario);
               
                
                return destinos;
            }
         
        }
         return null;
    } 

    public static void listadoPorOrigen(JTable tabla, String ruta, String origen) {
        ArrayList<Destino> destinos = traerDatos(ruta);
        ArrayList<Destino> DestinopersonasFiltradas = new ArrayList();
        for (int i = 0; i < destinos.size(); i++) {
            if (destinos.get(i).getPasajero().getOrigen().equalsIgnoreCase(origen)) {
                DestinopersonasFiltradas.add(destinos.get(i));
            }

        }
        llenarTablaOrigen(tabla, DestinopersonasFiltradas);

    }
    
    public static void llenarComboPersonas(JComboBox combo, String ruta){
        ArrayList<Personas> personas = traerDatos(ruta);
        DefaultComboBoxModel dcbm =(DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        Personas p;
        for (int i = 0; i < personas.size(); i++) {
            p = personas.get(i);
           dcbm.addElement(p.getCedula()+" - "+p.getNombre()+" "+p.getApellido());
        }
    } 
    
    public static void llenarComboCedula(JComboBox combo, String ruta){
        ArrayList<Destino> destinos = traerDatos(ruta);
        DefaultComboBoxModel dcbm =(DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        Destino d;
        for (int i = 0; i < destinos.size(); i++) {
            d = destinos.get(i);
           dcbm.addElement(d.getPasajero().getCedula());
        }
    }
    
    public static boolean buscarDestino(String cedula, String ruta) {
        ArrayList<Destino> destinos = traerDatos(ruta);
        for (int i = 0; i < destinos.size(); i++) {
            if (destinos.get(i).getPasajero().getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
   }
    
    public static Destino traerDestino(String cedula, String ruta){
         ArrayList<Destino> destinos = traerDatos(ruta);
         for (int i = 0; i < destinos.size(); i++) {
            if (destinos.get(i).getPasajero().getCedula().equals(cedula)) {
                return destinos.get(i);
            }
            
        }
         return null;
    }
    
   public static String destinoSeleccionado(JRadioButton boton1,JRadioButton boton2,JRadioButton boton3,JRadioButton boton4,JRadioButton boton5,
           JRadioButton boton6,JRadioButton boton7,JRadioButton boton8){
    String destino="";
    if(boton1.isSelected()){
    destino="Barranquilla";
    }else if(boton2.isSelected()){
    destino="Bogota";
    }else if(boton3.isSelected()){
    destino="Madrid";
    }else if(boton4.isSelected()){
    destino="Miami";
    }else if(boton5.isSelected()){
    destino="Nueva York";
    }else if(boton6.isSelected()){
    destino="Paris";
    }else if(boton7.isSelected()){
    destino="Rio de Janeiro";
    }else if(boton8.isSelected()){
    destino="San Andres";
    }
    
       
       
       
       return destino;
       
       
   }
   
}
    
   
