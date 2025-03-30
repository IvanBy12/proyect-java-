/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leopa
 */
public class Cliente extends Persona {
    private long deuda;

    public Cliente(long deuda, int edad, String nombre) {
        super(edad, nombre);
        this.deuda = deuda;
    }

    public Cliente(long deuda, String nombre) {
        super(nombre);
        this.deuda = deuda;
    }

    public Cliente(long deuda) {
        this.deuda = deuda;
    }
    
    public Cliente(){
        
    }

    public long getDeuda() {
        return deuda;
    }

    public void setDeuda(long deuda) {
        this.deuda = deuda;
    }
}
