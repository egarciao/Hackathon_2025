package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String[] nombres = {"Nombre 1", "Nombre 2", "Nombre 3", "Nombre 4", "Nombre 5",
        "Nombre 6",  "Nombre 7", "Nombre 8", "Nombre 9", "Nombre 10"};
        for (int i = 0; i < 10; i++) {
            String id = String.valueOf(i);
            String nombre = nombres[i];
            Double saldo = Double.valueOf(Math.random()*10000);
            Cliente c = new Cliente(id, nombre, saldo);
            clientes.add(c);
        }

        Cliente mayorSaldo = clientes.stream().max(Comparator.comparing(Cliente::getSaldo)).get();
        System.out.println("Nombre: " + mayorSaldo.getNombre()
        + " Saldo: " + mayorSaldo.getSaldo());

    }
}
