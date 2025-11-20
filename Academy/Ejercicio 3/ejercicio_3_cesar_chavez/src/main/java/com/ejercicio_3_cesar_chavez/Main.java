package com.ejercicio_3_cesar_chavez;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
        List<Cliente> carteraClientes = new ArrayList<>();

        carteraClientes.add(new Cliente(1, "César Chávez", 1500.50));
        carteraClientes.add(new Cliente(2, "Ana Pérez", 5000.00));
        carteraClientes.add(new Cliente(3, "Luis Gómez", 320.00));
        carteraClientes.add(new Cliente(4, "María Rodríguez", 12500.75)); // Este debería ganar
        carteraClientes.add(new Cliente(5, "Carlos Ruiz", 0.00));

        System.out.println("--- Lista de Clientes ---");
        for (Cliente c : carteraClientes) {
            System.out.println(c); 
        }


        Cliente clienteMasRico = null;
        double maxSaldo = -1.0; 

        for (Cliente actual : carteraClientes) {
            if (clienteMasRico == null || actual.getSaldo() > maxSaldo) {
                maxSaldo = actual.getSaldo();
                clienteMasRico = actual;
            }
        }

        System.out.println("\n--- Resultado del Análisis ---");
        if (clienteMasRico != null) {
            System.out.println("El cliente con mayor saldo es: " + clienteMasRico.getNombre());
            System.out.println("Detalles: " + clienteMasRico);
        } else {
            System.out.println("La lista de clientes está vacía.");
        }
    }
}