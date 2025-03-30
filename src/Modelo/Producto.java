/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leopa
 */
public class  Producto {
    private long precio;
    private int cantidad;

    public Producto(long precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(int cantidad){
        this.cantidad=cantidad;
    }
   
    
    public Producto(){
        
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

 
    
    
}
