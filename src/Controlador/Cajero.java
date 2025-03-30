package Controlador;

import Modelo.*;
import Vista.InscribirPersonas;
import Vista.Ventana;

public class Cajero {
    Inventario auxInventario = new Inventario();
    InscribirPersonas aux = new InscribirPersonas();

    long total;


    public void iniciar() {

        aux.setVisible(false);
      /*  try {
            aux.setVisible(false);
           // menu();

        } catch (NumberFormatException e) {
            Ventana.mostrarInfor("Error, Digite nuevamente la opcion");
        }*/
    }

    /*public void menu() throws NumberFormatException {
        int op = 0;
        do {
            op = Integer.parseInt(Ventana.pedirInfo("Menu de inicio" + "\n" +
                    "1. Agregar Productos" + "\n" +
                    "2. Vender Productos" + "\n" +
                    "3. Mostrar Total Vendidos" + "\n" +
                    "4. Salir "));
            opcion(op);
        } while (op != 4);
    }*/


    public void opcion(int op) throws NumberFormatException {
        switch (op) {
            case 1:
                try {
                    int opProducto = Integer.parseInt(Ventana.pedirInfo("Que producto desea agregar? \n 1. Cigarrillos \n 2. Bebidas \n 3. Mecato"));
                    auxInventario.CargarProductos(opProducto);
                } catch (NumberFormatException e) {
                    Ventana.mostrarInfor("Error, Digite nuevamente la opcion");
                    opcion(op);
                }
                break;
            case 2:

                try {
                    auxInventario.AgregarComprador();
                    auxInventario.Vender();
                    auxInventario.mostrarTotal();

                } catch (NumberFormatException e) {
                    Ventana.mostrarInfor("Error, Digite nuevamente la opcion");
                    opcion(op);
                }
                break;
            case 3:
                auxInventario.MostrarTotalVendido();
               /* try {
                    auxInventario.MostrarTotalVendido();
                } catch (Exception e) {
                    Ventana.mostrarInfor(auxInventario.getClientesExitosos().toString());
                    Ventana.mostrarInfor("Lo sentimos, esta opcion aun esta disponible");
                }*/
                break;
        }
    }


}
