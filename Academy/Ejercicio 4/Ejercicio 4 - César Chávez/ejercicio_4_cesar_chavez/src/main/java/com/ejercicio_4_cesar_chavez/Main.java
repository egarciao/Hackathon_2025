package com.ejercicio_4_cesar_chavez;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaccion> historial = new ArrayList<>();
        historial.add(new Transaccion(Transaccion.TIPO_DEPOSITO, 1000.0, LocalDate.now()));
        historial.add(new Transaccion(Transaccion.TIPO_RETIRO, 200.0, LocalDate.now()));
        historial.add(new Transaccion(Transaccion.TIPO_DEPOSITO, 500.0, LocalDate.of(2023, 1, 15)));
        historial.add(new Transaccion("RETIRO", 100.0, LocalDate.now())); // String directo

        GestionTransacciones gestor = new GestionTransacciones();

        double totalIngresos = gestor.calcularTotalDepositos(historial);
        double totalEgresos = gestor.calcularTotalRetiros(historial);

        System.out.println("--- Balance de Cuenta ---");
        System.out.println("Total Depositado:  $" + totalIngresos);
        System.out.println("Total Retirado:    $" + totalEgresos);
        System.out.println("Balance Neto:      $" + (totalIngresos - totalEgresos));
    }
}