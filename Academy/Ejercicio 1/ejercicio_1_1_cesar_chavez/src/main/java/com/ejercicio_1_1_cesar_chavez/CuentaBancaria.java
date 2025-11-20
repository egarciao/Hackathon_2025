package com.ejercicio_1_1_cesar_chavez;


class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
    }

    public double calcularInteres(double tasaAnual, int anios) {
        if (tasaAnual < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        if (anios < 0) {
            throw new IllegalArgumentException("El número de años no puede ser negativo");
        }
        return this.saldo * (tasaAnual / 100) * anios;
    }

    public double getSaldo() {
        return this.saldo;
    }
}