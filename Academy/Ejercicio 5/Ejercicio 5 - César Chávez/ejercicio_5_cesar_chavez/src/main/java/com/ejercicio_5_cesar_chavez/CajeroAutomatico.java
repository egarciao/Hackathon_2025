package com.ejercicio_5_cesar_chavez;

public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.saldo = saldoInicial;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        this.saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Fondos insuficientes. Saldo actual: " + this.saldo);
        }
        this.saldo -= monto;
    }
}