/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero_automatico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastian
 */
public class Cliente {

    private String dni;
    private String contrasena;
    private String nombre;
    private double saldo;
    public List<Cliente> clientes;

    public void cargar() {
        clientes = new ArrayList<>();

        String[] dnis = {"83749573", "98456398", "72482060"};
        String[] nombres = {"Sebastian Mogollon", "Junior Nanez", "Alex Quispe"};
        double[] saldos = {1243.5, 9845.3, 12985.6};
        String[] claves = {"6752", "9853", "1234"};

        for (int i = 0; i < 3; i++) {
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setDni(dnis[i]);
            nuevoCliente.setNombre(nombres[i]);
            nuevoCliente.setSaldo(saldos[i]);
            nuevoCliente.setContrasena(claves[i]);
            clientes.add(nuevoCliente);
        }

        for (Cliente cliente : clientes) {
            System.out.print("El cliente cargado es: " + cliente.getNombre() + " " + cliente.getDni() + " " + cliente.getContrasena() + "\n");
        }
        System.out.print("\n");

    }

    public boolean validarDNI(String dni) {
        boolean dniValido = false;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                dniValido = true;
            }
        }

        return dniValido;
    }

    public Cliente validarContrasena(String contrasena) {
        for (Cliente cliente : clientes) {
            if (cliente.getContrasena().equals(contrasena)) {
                return cliente;
            }
        }

        return null;
    }

    public Cliente buscarPorDNI(String dni) {

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                return cliente;
            }
        }

        return null;
    }

    public Cliente actualizarSaldo(Cliente cliente, double monto, String tipo) {

        double saldoAnterior = cliente.getSaldo();
        double nuevoSaldo = saldoAnterior;

        if (tipo.equals("+")) {
            nuevoSaldo += monto;
            cliente.setSaldo(nuevoSaldo);
            return cliente;
        } else {
            if (tipo.equals("-")) {
                // El saldo disponible debe ser mayor a 0
                if (saldoAnterior > 0) {
                    // El monto debe ser menor o igual al saldo disponible
                    if (monto <= saldoAnterior) {
                        nuevoSaldo -= monto;
                        cliente.setSaldo(nuevoSaldo);
                        return cliente;
                    } else {
                        System.out.println("RPTA: Su saldo es insuficiente");
                        System.out.print("\n");
                    }
                } else {
                    System.out.println("RPTA: Usted no cuenta con saldo suficiente para este retiro");
                    System.out.print("\n");
                }
            }
        }

        return null;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
