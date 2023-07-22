/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero_automatico;

import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear objetos y variables
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        // Cargar registro de clientes
        cliente.cargar();

        Cajero cajero;

        System.out.print("Ingrese su DNI:");
        String dni = scanner.next();

        if (cliente.validarDNI(dni)) {

            System.out.print("Ingrese su clave de 4 digitos:");
            String contrasena = scanner.next();

            // Obtener el objeto del cliente autenticado
            Cliente clienteAutenticado = cliente.validarContrasena(contrasena);

            // Si el cliente autenticado existe
            if (clienteAutenticado != null) {

                // Crear un objeto cajero
                cajero = new Cajero();
                System.out.print("\n");
                System.out.println("Bienvenid@, " + clienteAutenticado.getNombre() + "");
                System.out.print("\n");

                int operacion = cajero.mostrarMenu();
                cajero.realizarOperación(operacion, clienteAutenticado);
            } else {
                System.out.println("Su clave es invalido...");
            }
        } else {
            System.out.println("Su dni es invalido...");
        }
    }
}
