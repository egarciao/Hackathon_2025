package com.ejercicio_5_cesar_chavez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppCajero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CajeroAutomatico cajero = new CajeroAutomatico(1000.0);
        boolean ejecutando = true;

        System.out.println("--- BIENVENIDO AL CAJERO AUTOMÁTICO ---");

        while (ejecutando) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: $" + cajero.consultarSaldo());
                        break;
                    case 2:
                        System.out.print("Ingrese monto a depositar: ");
                        double deposito = scanner.nextDouble();
                        cajero.depositar(deposito);
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + cajero.consultarSaldo());
                        break;
                    case 3:
                        System.out.print("Ingrese monto a retirar: ");
                        double retiro = scanner.nextDouble();
                        cajero.retirar(retiro);
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + cajero.consultarSaldo());
                        break;
                    case 4:
                        System.out.println("Gracias por usar nuestro cajero. ¡Adiós!");
                        ejecutando = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente del 1 al 4.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada no válida. Debe ingresar números.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}