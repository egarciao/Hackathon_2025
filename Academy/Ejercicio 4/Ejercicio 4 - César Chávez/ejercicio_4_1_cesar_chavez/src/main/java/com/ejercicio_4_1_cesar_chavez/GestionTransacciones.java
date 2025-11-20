package com.ejercicio_4_1_cesar_chavez;

import java.util.List;

public class GestionTransacciones {

    public double calcularTotalDepositos(List<Transaccion> transacciones) {
        return calcularTotalPorTipo(transacciones, Transaccion.TIPO_DEPOSITO);
    }

    public double calcularTotalRetiros(List<Transaccion> transacciones) {
        return calcularTotalPorTipo(transacciones, Transaccion.TIPO_RETIRO);
    }

    private double calcularTotalPorTipo(List<Transaccion> lista, String tipoBuscado) {
        if (lista == null || lista.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Transaccion t : lista) {
            if (t.getTipo().equalsIgnoreCase(tipoBuscado)) {
                total += t.getMonto();
            }
        }
        return total;
    }
}