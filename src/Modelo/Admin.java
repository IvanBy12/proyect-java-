/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leopa
 */
public class Admin extends Persona {
    
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Admin(String contraseña, String nombre) {
        super(nombre);
        this.contraseña = contraseña;
    }

    public Admin(String nombre) {
        super(nombre);
    }

    public Admin() {
    }
    
    public boolean comprobar(){
            if (Admin.super.getNombre().equalsIgnoreCase("Victor") && contraseña.equals("hola1234")) {
           return true;
        }else{
                return false;
            }         
    }
    
    
    
    
    
}
