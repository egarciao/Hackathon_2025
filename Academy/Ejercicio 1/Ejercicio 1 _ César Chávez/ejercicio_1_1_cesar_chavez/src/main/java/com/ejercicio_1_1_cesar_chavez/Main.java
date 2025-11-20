package com.ejercicio_1_1_cesar_chavez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresa el monto inicial de la cuenta: ");
        double monto = entrada.nextDouble();

        System.out.print("Ingresa la tasa de interés anual (%): ");
        double tasa = entrada.nextDouble();

        System.out.print("Ingresa el número de años: ");
        int anios = entrada.nextInt();

        CuentaBancaria miCuenta = new CuentaBancaria(monto);

        double interesGenerado = miCuenta.calcularInteres(tasa, anios);
        double montoFinal = miCuenta.getSaldo() + interesGenerado;

        // D. Mostrar resultados
        System.out.println("\n--- Reporte de la Cuenta ---");
        System.out.println("Saldo original:   " + miCuenta.getSaldo());
        System.out.println("Interés ganado:   " + interesGenerado);
        System.out.println("Monto final:      " + montoFinal);

        entrada.close();
    }
}