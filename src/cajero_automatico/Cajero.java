/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero_automatico;

import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class Cajero {

    Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("-------------------------");
        System.out.println("Seleccione una operacion:");
        System.out.println("-------------------------");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar Dinero ");
        System.out.println("3. Retirar Dinero");
        System.out.println("4. Salir");
        System.out.println("-------------------------");
        System.out.print("Operacion N°: ");

        int operacion = scanner.nextInt();
        return operacion;

    }

    public void realizarOperación(int operacion, Cliente cliente) {

        int nuevaOperacion = 4;
        switch (operacion) {
            case 1:
                System.out.print("\n");
                System.out.println("*********************");
                System.out.println("MENU CONSULTAR SALDO:");
                System.out.println("*********************");

                consultarMonto(cliente);

                nuevaOperacion = mostrarMenu();
                realizarOperación(nuevaOperacion, cliente);

                break;
            case 2:
                System.out.print("\n");
                System.out.println("**********************");
                System.out.println("MENU DEPOSITAR DINERO:");
                System.out.println("**********************");
                System.out.println("Su saldo disponible es: " + cliente.getSaldo());
                System.out.print("Ingrese el monto a depositar:");

                double montoDepositar = scanner.nextDouble();
                depositarMonto(cliente, montoDepositar);

                nuevaOperacion = mostrarMenu();
                realizarOperación(nuevaOperacion, cliente);

                break;
            case 3:
                System.out.print("\n");
                System.out.println("**********************");
                System.out.println("MENU RETIRAR DINERO:");
                System.out.println("**********************");
                System.out.println("Su saldo disponible es: " + cliente.getSaldo());
                System.out.print("Ingrese el monto a retirar:");

                double montoRetirar = scanner.nextDouble();
                retirarMonto(cliente, montoRetirar);

                nuevaOperacion = mostrarMenu();
                realizarOperación(nuevaOperacion, cliente);

                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Esta operacion no esta disponible");
        }

    }

    public void consultarMonto(Cliente cliente) {
        System.out.println("RPTA: Su saldo disponible es: $" + cliente.getSaldo());
        System.out.print("\n");
    }

    public void depositarMonto(Cliente cliente, double monto) {
        Cliente clienteActualizado = cliente.actualizarSaldo(cliente, monto, "+");
        System.out.println("Se ha depositado $" + monto + " a su cuenta");
        System.out.println("RPTA:  Su nuevo saldo disponible es $" + clienteActualizado.getSaldo());
        System.out.print("\n");
    }

    public void retirarMonto(Cliente cliente, double monto) {
        Cliente clienteActualizado = cliente.actualizarSaldo(cliente, monto, "-");
        if (clienteActualizado != null) {
            System.out.println("Se ha retirado $" + monto + " de su cuenta");
            System.out.println("RPTA: Su nuevo saldo disponible es $" + clienteActualizado.getSaldo());
            System.out.print("\n");
        }
    }

}
