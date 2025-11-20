package com.ejercicio_1_1_cesar_chavez;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    // CP-01: Flujo Feliz (Happy Path)
    @Test
    @DisplayName("CP-01: Calcular interés con valores estándar")
    void testCalculoInteresCorrecto() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        
        double interes = cuenta.calcularInteres(10, 2);
        

        assertEquals(200.0, interes, 0.001, "El interés de 1000 al 10% por 2 años debe ser 200");
    }

    // CP-02: Decimales y Precisión
    @Test
    @DisplayName("CP-02: Calcular interés con centavos y decimales")
    void testCalculoConDecimales() {
        CuentaBancaria cuenta = new CuentaBancaria(1500.50);
        double interes = cuenta.calcularInteres(2.5, 1);
        
        // 1500.50 * 0.025 * 1 = 37.5125
        assertEquals(37.5125, interes, 0.0001);
    }

    // CP-03: Valor Límite (Saldo Cero)
    @Test
    @DisplayName("CP-03: Calcular interés con saldo cero")
    void testSaldoCero() {
        CuentaBancaria cuenta = new CuentaBancaria(0);
        double interes = cuenta.calcularInteres(5, 3);
        assertEquals(0.0, interes, "Si el saldo es 0, el interés debe ser 0");
    }

    // CP-05: Dato Inválido (Saldo Inicial Negativo)
    @Test
    @DisplayName("CP-05: Debe fallar si se intenta crear cuenta con saldo negativo")
    void testSaldoInicialNegativo() {
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria(-500);
        });
        
        assertEquals("El saldo inicial no puede ser negativo", excepcion.getMessage());
    }

    // CP-06: Dato Inválido (Tasa Negativa)
    @Test
    @DisplayName("CP-06: Debe fallar si la tasa es negativa")
    void testTasaInteresNegativa() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta.calcularInteres(-5, 1);
        });
    }

    // CP-07: Cálculo Grande (Stress Test)
    @Test
    @DisplayName("CP-07: Cálculo con montos muy grandes (Billones)")
    void testCalculoGrande() {
        double montoGigante = 1_000_000_000; 
        CuentaBancaria cuenta = new CuentaBancaria(montoGigante);
        
        // Interés: 10% anual por 10 años.
        // Matemáticamente: 1,000,000,000 * 0.10 * 10 = 1,000,000,000 de interés.
        double interes = cuenta.calcularInteres(10, 10);
        
        assertEquals(1_000_000_000.0, interes, 0.01, "El sistema debe soportar billones sin desbordarse");
    }
}