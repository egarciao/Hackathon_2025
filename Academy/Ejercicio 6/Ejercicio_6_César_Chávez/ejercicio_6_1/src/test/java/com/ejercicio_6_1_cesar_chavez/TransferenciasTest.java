package com.ejercicio_6_1_cesar_chavez;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciasTest {

    // CP-02: Carga Media (100 Hilos)
    @Test
    @DisplayName("CP-02: 100 Hilos concurrentes no deben perder dinero")
    void testConcurrenciaMedia() throws InterruptedException {
        int numeroHilos = 100;
        int saldoInicial = 10000;
        int montoTransferencia = 10;

        Cuenta ctaOrigen = new Cuenta(1, saldoInicial);
        Cuenta ctaDestino = new Cuenta(2, saldoInicial);
        
        double totalDineroInicial = ctaOrigen.getSaldo() + ctaDestino.getSaldo();

        ExecutorService executor = Executors.newFixedThreadPool(numeroHilos);
        
        CountDownLatch latch = new CountDownLatch(numeroHilos);

        // 2. Ejecución (Act)
        for (int i = 0; i < numeroHilos; i++) {
            executor.execute(() -> {
                try {
                    ctaOrigen.transferir(ctaDestino, montoTransferencia);
                } finally {
                    latch.countDown();
                }
            });
        }

        boolean terminaronATiempo = latch.await(5, TimeUnit.SECONDS);
        assertTrue(terminaronATiempo, "Los hilos tardaron demasiado (posible Deadlock)");

        double totalDineroFinal = ctaOrigen.getSaldo() + ctaDestino.getSaldo();

        System.out.println("Dinero Inicial: " + totalDineroInicial);
        System.out.println("Dinero Final:   " + totalDineroFinal);

        assertEquals(totalDineroInicial, totalDineroFinal, 
            "ERROR DE CONCURRENCIA: El dinero total cambió. ¿Falta un 'synchronized'?");
    }

    // CP-03: Estrés (1000 Hilos)
    @Test
    @DisplayName("CP-03: Prueba de Estrés con 1000 operaciones simultáneas")
    void testStress() throws InterruptedException {
        int hilos = 1000;
        Cuenta c1 = new Cuenta(1, 50000);
        Cuenta c2 = new Cuenta(2, 50000);
        double totalEsperado = 100000;

        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(hilos);

        for (int i = 0; i < hilos; i++) {
            final int direccion = i; 
            executor.execute(() -> {
                try {
                    if (direccion % 2 == 0) {
                        c1.transferir(c2, 5);
                    } else {
                        c2.transferir(c1, 5);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10, TimeUnit.SECONDS);
        
        assertEquals(totalEsperado, c1.getSaldo() + c2.getSaldo());
    }
    
    // CP-04: Integridad (Saldo Negativo)
    @Test
    @DisplayName("CP-05: Múltiples hilos no deben dejar la cuenta en negativo")
    void testSaldoNoNegativo() throws InterruptedException {
        Cuenta ctaPobre = new Cuenta(1, 100); 
        Cuenta ctaRica = new Cuenta(2, 0);
        
        int hilos = 50;
        // Cada hilo intenta sacar 10 pesos. Total intento: 500 pesos.
        // Solo deberían poder salir 10 hilos (100 pesos total).
        
        ExecutorService executor = Executors.newFixedThreadPool(hilos);
        CountDownLatch latch = new CountDownLatch(hilos);

        for (int i = 0; i < hilos; i++) {
            executor.execute(() -> {
                try {
                    ctaPobre.transferir(ctaRica, 10);
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await(5, TimeUnit.SECONDS);

        assertTrue(ctaPobre.getSaldo() >= 0, "La cuenta origen quedó en negativo: " + ctaPobre.getSaldo());
        assertEquals(100.0, ctaRica.getSaldo(), "Se transfirió más dinero del que existía");
    }
}