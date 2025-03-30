/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * @author leopa
 */

import Vista.*;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Inventario {

    static long totalVendido = 0;
    Cigarro marlboro = new Cigarro(1000, 20), luckyStrike = new Cigarro(1000, 20);
    Bebidas corona = new Bebidas(4000, 20), poker = new Bebidas(2000, 20), colombiana = new Bebidas(1800, 20), pepsi = new Bebidas(2000, 20);
    Mecato papasLimon = new Mecato(2000, 20), doritos = new Mecato(2000, 20);
    Cliente auxCliente = new Cliente();
    ArrayList<Cliente> clientesExitosos = new ArrayList<>();
    final double iva = 0.19;

    public long getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(long totalVendido) {
        this.totalVendido = totalVendido;
    }

    public ArrayList<Cliente> getClientesExitosos() {
        return clientesExitosos;
    }

    @Override
    public String toString() {
        String a = "";
        for (int j = 0; j < this.clientesExitosos.size(); j++) {
            a += ("Cliente: " + this.clientesExitosos.get(j).getNombre() + "\n"
                    + "Debe: " + this.clientesExitosos.get(j).getDeuda());
        }
        return a;
    }


    public void CargarProductos(int x) throws NumberFormatException {

        switch (x) {
            case 1:
                int pediTipoCigarrilo = Integer.parseInt(Ventana.pedirInfo("¿Que cigarrillo desea agregar? \n 1. Marlboro \n 2. Lucky Strike"));
                switch (pediTipoCigarrilo) {
                    case 1:
                        marlboro.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantos cigarrilos de Marlboro desea agregar?")));
                        marlboro.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio del cigarrillo")));
                        break;
                    case 2:
                        luckyStrike.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantos cigarrilos de Lucky Stryke deseia agregar?")));
                        luckyStrike.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio del cigarrillo")));
                        break;
                    default:
                        Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                        break;
                }
                break;
            case 2:
                int pedirtipoBebidas = Integer.parseInt(Ventana.pedirInfo("¿Que tipo de bebida desea agregar? \n 1. bebidas azucaradas \n 2. bebidas alcoholicas"));
                switch (pedirtipoBebidas) {
                    case 1:
                        int pedirTipoBebibaAzucarada = Integer.parseInt(Ventana.pedirInfo("¿Que bebida azucarada desea agregar? \n 1. Colombiana \n 2. Pepsi"));
                        switch (pedirTipoBebibaAzucarada) {
                            case 1:
                                colombiana.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Colombiana desea agregar?")));
                                colombiana.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de la bebida")));
                                break;
                            case 2:
                                pepsi.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Pepsi desea agregar?")));
                                pepsi.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de la bebida")));
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }
                        break;
                    case 2:
                        int pedirTipoBebidaAlcoholica = Integer.parseInt(Ventana.pedirInfo("¿Que bebida alcoholica desea agregar?  \n 1. Corona Extra \n 2. Poker"));
                        switch (pedirTipoBebidaAlcoholica) {
                            case 1:
                                corona.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Corona Extra desea agregar?")));
                                corona.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de la bebida")));
                                break;
                            case 2:
                                poker.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Poker desea agregar?")));
                                poker.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de la bebida")));
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }
                        break;
                }
                break;
            case 3:
                int pedirTipoMecato = Integer.parseInt(Ventana.pedirInfo("¿Que papas desea modificar? \n 1. Papas de limon \n 2.Doritos"));
                switch (pedirTipoMecato) {
                    case 1:
                        papasLimon.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantas papas de limon desea agregar?")));
                        papasLimon.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de las papas")));
                        break;
                    case 2:
                        doritos.setCantidad(Integer.parseInt(Ventana.pedirInfo("Cuantos Doritos desea agregar?")));
                        doritos.setPrecio(Long.parseLong(Ventana.pedirInfo("Ingrese el precio de las papas")));
                    default:
                        Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                        break;
                }
                break;
            default:
                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                break;
        }
    }

    public void AgregarComprador() {
        Ventana.mostrarInfor("Antes de seguir comprando Necesitamos algunos datos del cliente");
        auxCliente = new Cliente();
        auxCliente.setNombre(Ventana.pedirInfo("Ingrese el nombre del cliente"));
        auxCliente.setEdad(Integer.parseInt(Ventana.pedirInfo("Ingrese la edad del cliente")));
    }

    public void Vender() throws NumberFormatException {
        boolean seguir = true;

        do {

            if (auxCliente.getEdad() <= 17) {
                int opVendermenores = Integer.parseInt(Ventana.pedirInfo("Que producto desea comprar? \n 1. Bebidas \n 2. Mecato \n 3. Salir"));
                switch (opVendermenores) {
                    case 1:

                        int pedirTipoBebibaAzucarada = Integer.parseInt(Ventana.pedirInfo("¿Que bebida azucarada desea comprar? \n 1. Colombiana Precio:" + colombiana.getPrecio() + "\n 2. Pepsi Precio: " + pepsi.getPrecio()));
                        switch (pedirTipoBebibaAzucarada) {
                            case 1:
                                int cantComprarBebidas = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas desea comprar?"));
                                if (colombiana.getCantidad() >= cantComprarBebidas) {

                                    int aux = colombiana.getCantidad();
                                    colombiana.setCantidad(aux - cantComprarBebidas);
                                    totalVendido += colombiana.getPrecio() * cantComprarBebidas;
                                    auxCliente.setDeuda(auxCliente.getDeuda() + (colombiana.getPrecio() * cantComprarBebidas));

                                    seguir = Ventana.pedirBoolean("Desea Seguir comprando?");

                                } else {
                                    Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                }

                                break;
                            case 2:

                                int cantComprada = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas desea comprar?"));
                                if (pepsi.getCantidad() >= cantComprada) {
                                    int aux = pepsi.getCantidad();
                                    pepsi.setCantidad(aux - cantComprada);
                                    totalVendido += pepsi.getPrecio() * cantComprada;
                                    auxCliente.setDeuda(auxCliente.getDeuda() + (pepsi.getPrecio() * cantComprada));
                                    seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                } else {
                                    Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                }
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }

                        break;

                    case 2:

                        int pedirTipoMecato = Integer.parseInt(Ventana.pedirInfo("¿Que papas desea comprarr? \n 1. Papas de limon Precio: " + papasLimon.getPrecio() + "\n 2.Doritos Precio: " + doritos.getPrecio()));
                        switch (pedirTipoMecato) {
                            case 1:
                                int cantCaa = Integer.parseInt(Ventana.pedirInfo("Cuantas papas de limon desea comprar?"));
                                if (papasLimon.getCantidad() >= cantCaa) {
                                    int aux = papasLimon.getCantidad();
                                    papasLimon.setCantidad(aux - cantCaa);
                                    totalVendido += papasLimon.getPrecio() * cantCaa;
                                    auxCliente.setDeuda(auxCliente.getDeuda() + (papasLimon.getPrecio() * cantCaa));

                                    seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                } else {
                                    Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                }
                                break;

                            case 2:

                                int cantCaaa = Integer.parseInt(Ventana.pedirInfo("Cuantos Doritos desea comprar?"));
                                if (doritos.getCantidad() >= cantCaaa) {
                                    int aux = doritos.getCantidad();
                                    doritos.setCantidad(aux - cantCaaa);
                                    totalVendido += doritos.getPrecio() * cantCaaa;
                                    seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                    auxCliente.setDeuda(auxCliente.getDeuda() + (doritos.getPrecio() * cantCaaa));
                                } else {
                                    Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                }
                                break;
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }

                        break;
                    case 3:
                        seguir = false;
                        break;
                    default:
                        Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                        break;
                }

            } else {
                int opVenderMayores = Integer.parseInt(Ventana.pedirInfo("Que producto desea comprar? \n 1. Cigarrillos \n 2. Bebidas \n 3. Mecato \n 4. Salir"));

                switch (opVenderMayores) {
                    case 1:
                        int pediTipoCigarrilo1 = Integer.parseInt(Ventana.pedirInfo("¿Que cigarrillo desea comprar? \n 1. Marlboro Precio: " + marlboro.getPrecio() + "\n 2. Lucky Strike Precio: " + luckyStrike.getPrecio()));
                        switch (pediTipoCigarrilo1) {
                            case 1:
                                int cantComprada = Integer.parseInt(Ventana.pedirInfo("Cuantos cigarrillos Marlboro desea comprar?"));
                                if (cantComprada > 0) {
                                    if (marlboro.getCantidad() >= cantComprada) {
                                        int aux = marlboro.getCantidad();
                                        marlboro.setCantidad(aux - cantComprada);
                                        totalVendido += marlboro.getPrecio() * cantComprada;
                                        auxCliente.setDeuda(auxCliente.getDeuda() + (marlboro.getPrecio() * cantComprada));
                                        seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                    } else {
                                        Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                    }
                                } else
                                    Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");


                                break;
                            case 2:
                                int cantComprada1 = Integer.parseInt(Ventana.pedirInfo("Cuantos cigarrillos Lucky Strike desea comprar?"));

                                if (cantComprada1 > 0) {

                                    if (luckyStrike.getCantidad() >= cantComprada1) {
                                        int aux = luckyStrike.getCantidad();
                                        luckyStrike.setCantidad(aux - cantComprada1);
                                        totalVendido += luckyStrike.getPrecio() * cantComprada1;
                                        auxCliente.setDeuda(auxCliente.getDeuda() + (luckyStrike.getPrecio() * cantComprada1));
                                        seguir = Ventana.pedirBoolean("Desea Seguir comprando?");

                                    } else {
                                        Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                    }
                                } else
                                    Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");
                                break;
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }
                        break;
                    case 2:
                        int pedirtipoBebidas = Integer.parseInt(Ventana.pedirInfo("¿Que tipo de bebida desea comprarr? \n 1. bebidas azucaradas \n 2. bebidas alcoholicas"));
                        switch (pedirtipoBebidas) {
                            case 1:
                                int pedirTipoBebibaAzucarada = Integer.parseInt(Ventana.pedirInfo("¿Que bebida azucarada desea comprar? \n 1. Colombiana Precio:" + colombiana.getPrecio() + "\n 2. Pepsi Precio: " + pepsi.getPrecio()));
                                switch (pedirTipoBebibaAzucarada) {
                                    case 1:
                                        int cantComprarBebidas = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas desea comprar?"));

                                        if (cantComprarBebidas > 0) {
                                            if (colombiana.getCantidad() >= cantComprarBebidas) {
                                                int aux = colombiana.getCantidad();
                                                colombiana.setCantidad(aux - cantComprarBebidas);
                                                totalVendido += colombiana.getPrecio() * cantComprarBebidas;
                                                auxCliente.setDeuda(auxCliente.getDeuda() + (colombiana.getPrecio() * cantComprarBebidas));
                                                seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                            } else {
                                                Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                            }
                                        } else
                                            Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");

                                        break;
                                    case 2:

                                        int cantComprada = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas desea comprar?"));
                                        if (cantComprada > 0) {
                                            if (pepsi.getCantidad() >= cantComprada) {
                                                int aux = pepsi.getCantidad();
                                                pepsi.setCantidad(aux - cantComprada);
                                                totalVendido += pepsi.getPrecio() * cantComprada;
                                                auxCliente.setDeuda(auxCliente.getDeuda() + (pepsi.getPrecio() * cantComprada));
                                                seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                            } else {
                                                Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                            }
                                        } else
                                            Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");
                                        break;
                                    default:
                                        Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                        break;
                                }

                                break;
                            case 2:
                                int pedirTipoBebidaAlcoholica = Integer.parseInt(Ventana.pedirInfo("¿Que bebida alcoholica desea comprar?  \n 1. Corona Extra Precio:" + corona.getPrecio() + " \n 2. Poker Precio: " + poker.getPrecio()));
                                switch (pedirTipoBebidaAlcoholica) {
                                    case 1:
                                        int cantC = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Corona Extra desea comprar?"));
                                        if (cantC > 0) {
                                            if (corona.getCantidad() >= cantC) {
                                                int aux = corona.getCantidad();
                                                corona.setCantidad(aux - cantC);
                                                totalVendido += corona.getPrecio() * cantC;
                                                auxCliente.setDeuda(auxCliente.getDeuda() + (corona.getPrecio() * cantC));
                                                seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                            } else {
                                                Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                            }
                                        } else
                                            Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");

                                        break;
                                    case 2:
                                        int cantCa = Integer.parseInt(Ventana.pedirInfo("Cuantas bebidas Poker desea comprar?"));
                                        if (cantCa > 0) {
                                            if (poker.getCantidad() >= cantCa) {
                                                int aux = poker.getCantidad();
                                                poker.setCantidad(aux - cantCa);
                                                totalVendido += poker.getPrecio() * cantCa;
                                                auxCliente.setDeuda(auxCliente.getDeuda() + (poker.getPrecio() * cantCa));
                                                seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                            } else {
                                                Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                            }
                                        } else
                                            Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");
                                }
                                break;
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }
                        break;
                    case 3:
                        int pedirTipoMecato = Integer.parseInt(Ventana.pedirInfo("¿Que papas desea comprarr? \n 1. Papas de limon Precio: " + papasLimon.getPrecio() + "\n 2.Doritos Precio: " + doritos.getPrecio()));
                        switch (pedirTipoMecato) {
                            case 1:
                                int cantCaa = Integer.parseInt(Ventana.pedirInfo("Cuantas papas de limon desea comprar?"));
                                if (cantCaa > 0) {
                                    if (papasLimon.getCantidad() >= cantCaa) {
                                        int aux = papasLimon.getCantidad();
                                        papasLimon.setCantidad(aux - cantCaa);
                                        totalVendido += papasLimon.getPrecio() * cantCaa;
                                        auxCliente.setDeuda(auxCliente.getDeuda() + (papasLimon.getPrecio() * cantCaa));
                                        seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                    } else {
                                        Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                    }
                                } else
                                    Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");
                                break;

                            case 2:

                                int cantCaaa = Integer.parseInt(Ventana.pedirInfo("Cuantos Doritos desea comprar?"));
                                if (cantCaaa > 0) {
                                    if (doritos.getCantidad() >= cantCaaa) {
                                        int aux = doritos.getCantidad();
                                        doritos.setCantidad(aux - cantCaaa);
                                        totalVendido += doritos.getPrecio() * cantCaaa;
                                        auxCliente.setDeuda(auxCliente.getDeuda() + (doritos.getPrecio() * cantCaaa));
                                        seguir = Ventana.pedirBoolean("Desea Seguir comprando?");
                                    } else {
                                        Ventana.mostrarInfor("Lo sentimos no tenemos en stock esa cantidad");
                                    }
                                } else
                                    Ventana.mostrarInfor("Lo sentimos no se puede ingresar cantidades negativas");
                            default:
                                Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                                break;
                        }
                        break;
                    case 4:
                        seguir = false;
                        break;
                    default:
                        Ventana.mostrarInfor("Ingrese alguna opcion disponible");
                        Vender();
                        break;
                }
            }
        }
        while (!seguir);

    }

    public void mostrarTotal() {
        int cobrar = Integer.parseInt(Ventana.pedirInfo("Pago Total" + "\n"
                + " Productos sin impuestos: " + (auxCliente.getDeuda() - (auxCliente.getDeuda() * iva)) + "\n"
                + " Impuestos: " + (auxCliente.getDeuda() * iva) + "\n"
                + " Pago Total : " + auxCliente.getDeuda() + "\n"
                + " Ingrese el pago total del cliente"));

        if (cobrar> 0){
            if (auxCliente.getDeuda() > cobrar) {
                long aux = auxCliente.getDeuda();
                auxCliente.setDeuda(aux - cobrar);
                Ventana.mostrarInfor("El cliente " + auxCliente.getNombre() + " le quedo debiendo " + auxCliente.getDeuda());
                clientesExitosos.add(auxCliente);

            } else if (auxCliente.getDeuda() < cobrar) {
                long aa = auxCliente.getDeuda();
                auxCliente.setDeuda(cobrar - aa);
                Ventana.mostrarInfor("Se le devuelven al cliente: " + auxCliente.getNombre() + " el total de: " + auxCliente.getDeuda());
                clientesExitosos.add(auxCliente);

            } else {
                Ventana.mostrarInfor("El cliente " + auxCliente.getNombre() + " pago la totalidad de la compra. ");
                auxCliente.setDeuda(auxCliente.getDeuda() - cobrar);
                clientesExitosos.add(auxCliente);

            }
        }else {
            Ventana.mostrarInfor("Lo sentimos no se puede pagar en cantidades negativas");
        }


    }

    public void MostrarTotalVendido() {
        boolean pregunta = Ventana.pedirBoolean("El total vendido es: " + totalVendido + "\n"
                + "Desea ver la lista de clientes? ");
        if (pregunta == false) {
            for (int j = 0; j < this.clientesExitosos.size(); j++) {
                Ventana.mostrarInfor("Cliente: " + this.clientesExitosos.get(j).getNombre() + "\n"
                        + "Debe: " + this.clientesExitosos.get(j).getDeuda());
            }

        }
    }

}
