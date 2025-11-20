package com.ejercicio_6_1_cesar_chavez;

import com.ejercicio_6_1_cesar_chavez.runnable.TransferenciaRunnable;

public class Main {
public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta1 = new Cuenta(1, 10000);
        Cuenta cuenta2 = new Cuenta(2, 10000);
        
        double saldoInicialTotal = cuenta1.getSaldo() + cuenta2.getSaldo();
        System.out.println("Saldo Inicial Total del Banco: $" + saldoInicialTotal);

        Thread[] hilos = new Thread[100];

        for (int i = 0; i < hilos.length; i++) {
            if (i % 2 == 0) {
                hilos[i] = new Thread(new TransferenciaRunnable(cuenta1, cuenta2, 100));
            } else {
                hilos[i] = new Thread(new TransferenciaRunnable(cuenta2, cuenta1, 100));
            }
        }

        /// IniciaN todos los hilos
        for (Thread h : hilos) {
            h.start();
        }

        for (Thread h : hilos) {
            h.join();
        }

        double saldoFinalTotal = cuenta1.getSaldo() + cuenta2.getSaldo();
        
        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Cuenta 1: $" + cuenta1.getSaldo());
        System.out.println("Cuenta 2: $" + cuenta2.getSaldo());
        System.out.println("Saldo Final Total: $" + saldoFinalTotal);

        if (saldoInicialTotal == saldoFinalTotal) {
            System.out.println("RESULTADO: ✅ EXITO. El dinero se conserva.");
        } else {
            System.out.println("RESULTADO: ❌ FALLO. Ha desaparecido dinero (Race Condition).");
        }
    }
}