package com.ejercicio_6_1_cesar_chavez;

public class Cuenta {
    private int id;
    private double saldo;

    public Cuenta(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public double getSaldo() { return saldo; }
    public int getId() { return id; }

    public synchronized void depositar(double monto) {
        this.saldo += monto;
    }

    public synchronized void retirar(double monto) {
        if (this.saldo >= monto) {
            this.saldo -= monto;
        }
    }

    public void transferir(Cuenta destino, double monto) {
        synchronized (this) {
            if (this.saldo >= monto) {
                this.retirar(monto); 
                // Bloqueamos la cuenta destino
                synchronized (destino) {
                    destino.depositar(monto);
                }
            }
        }
    }
}