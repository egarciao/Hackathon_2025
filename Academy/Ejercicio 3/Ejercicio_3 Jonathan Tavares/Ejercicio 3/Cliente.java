package org.example;

import java.math.BigDecimal;

public class Cliente {
    private String id;
    private String nombre;
    private BigDecimal saldo;

    public Cliente(String id, String nombre, Double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = new BigDecimal(saldo).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
