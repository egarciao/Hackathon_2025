package com.ejercicio_4_1_cesar_chavez;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionTransaccionesTest {

    GestionTransacciones gestor = new GestionTransacciones();
    LocalDate hoy = LocalDate.now();

    // CP-01: Flujo Mixto
    @Test
    @DisplayName("CP-01: Calcula correctamente totales mixtos")
    void testFlujoMixto() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion(Transaccion.TIPO_DEPOSITO, 100.0, hoy),
            new Transaccion(Transaccion.TIPO_RETIRO, 50.0, hoy),
            new Transaccion(Transaccion.TIPO_DEPOSITO, 200.0, hoy)
        );

        assertEquals(300.0, gestor.calcularTotalDepositos(lista), "Suma de depósitos incorrecta");
        assertEquals(50.0, gestor.calcularTotalRetiros(lista), "Suma de retiros incorrecta");
    }

    // CP-02: Lista Vacía
    @Test
    @DisplayName("CP-02: Retorna 0.0 si la lista está vacía")
    void testListaVacia() {
        List<Transaccion> listaVacia = new ArrayList<>();
        
        assertEquals(0.0, gestor.calcularTotalDepositos(listaVacia));
        assertEquals(0.0, gestor.calcularTotalRetiros(listaVacia));
    }

    // CP-03: Lista Nula
    @Test
    @DisplayName("CP-03: Retorna 0.0 si la lista es null (sin crash)")
    void testListaNula() {
        assertEquals(0.0, gestor.calcularTotalDepositos(null));
        assertEquals(0.0, gestor.calcularTotalRetiros(null));
    }

    // CP-04: Solo Depósitos
    @Test
    @DisplayName("CP-04: Si solo hay depósitos, retiros debe ser 0")
    void testSoloDepositos() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion(Transaccion.TIPO_DEPOSITO, 100.0, hoy),
            new Transaccion(Transaccion.TIPO_DEPOSITO, 100.0, hoy)
        );

        assertEquals(200.0, gestor.calcularTotalDepositos(lista));
        assertEquals(0.0, gestor.calcularTotalRetiros(lista));
    }

    // CP-05: Solo Retiros
    @Test
    @DisplayName("CP-05: Si solo hay retiros, depósitos debe ser 0")
    void testSoloRetiros() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion(Transaccion.TIPO_RETIRO, 50.0, hoy),
            new Transaccion(Transaccion.TIPO_RETIRO, 50.0, hoy)
        );

        assertEquals(0.0, gestor.calcularTotalDepositos(lista));
        assertEquals(100.0, gestor.calcularTotalRetiros(lista));
    }

    // CP-06: Tipos Desconocidos
    @Test
    @DisplayName("CP-06: Ignora tipos de transacción desconocidos")
    void testTiposDesconocidos() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion("COMISION", 50.0, hoy), // No es DEPOSITO ni RETIRO
            new Transaccion("TRANSFERENCIA", 100.0, hoy)
        );
        
        assertEquals(0.0, gestor.calcularTotalDepositos(lista));
        assertEquals(0.0, gestor.calcularTotalRetiros(lista));
    }

    // CP-07: Insensibilidad a Mayúsculas/Minúsculas
    @Test
    @DisplayName("CP-07: Acepta 'deposito' y 'DEPOSITO' por igual")
    void testMayusculasYMinusculas() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion("deposito", 100.0, hoy),
            new Transaccion("DEPOSITO", 100.0, hoy),
            new Transaccion("DePoSiTo", 100.0, hoy)
        );
        
        assertEquals(300.0, gestor.calcularTotalDepositos(lista));
    }
    
    // CP-08: Montos Cero
    @Test
    @DisplayName("CP-08: Suma correctamente montos en cero")
    void testMontosCero() {
        List<Transaccion> lista = Arrays.asList(
            new Transaccion(Transaccion.TIPO_DEPOSITO, 0.0, hoy),
            new Transaccion(Transaccion.TIPO_RETIRO, 0.0, hoy)
        );
        
        assertEquals(0.0, gestor.calcularTotalDepositos(lista));
        assertEquals(0.0, gestor.calcularTotalRetiros(lista));
    }
}