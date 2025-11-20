package com.ejercicio_4_1_cesar_chavez;

import java.time.LocalDate;

public class Transaccion {
    public static final String TIPO_DEPOSITO = "DEPOSITO";
    public static final String TIPO_RETIRO = "RETIRO";

    private String tipo; 
    private double monto;
    private LocalDate fecha;

    public Transaccion(String tipo, double monto, LocalDate fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return "[" + fecha + "] " + tipo + ": $" + monto;
    }
}