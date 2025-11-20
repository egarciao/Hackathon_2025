package com.ejercicio_6_cesar_chavez.runnable;

import com.ejercicio_6_cesar_chavez.Cuenta;

public class TransferenciaRunnable implements Runnable {
    private Cuenta origen;
    private Cuenta destino;
    private double monto;

    public TransferenciaRunnable(Cuenta origen, Cuenta destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10); 
            origen.transferir(destino, monto);
            System.out.println(Thread.currentThread().getName() + 
                ": Transfirió " + monto + " de Cta-" + origen.getId() + " a Cta-" + destino.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}