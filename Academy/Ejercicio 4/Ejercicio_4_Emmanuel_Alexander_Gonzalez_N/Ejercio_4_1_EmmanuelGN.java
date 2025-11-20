package Ejercicio_4_Emmanuel_Alexander_Gonzalez_N;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercio_4_1_EmmanuelGN {
    private CalculadoraBalance calculadora;
    private List<Transaccion> datosPrueba;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraBalance();
        datosPrueba = new ArrayList<>();
        // Datos controlados para la prueba
        datosPrueba.add(new Transaccion("Deposito", 1000.0, "01/01"));
        datosPrueba.add(new Transaccion("Retiro", 200.0, "02/01"));
    }

    @Test
    void testSumaDepositos() {
        // Probamos si suma bien los 1000
        double resultado = calculadora.sumarPorTipo(datosPrueba, "Deposito");
        assertEquals(1000.0, resultado, "El depósito debería ser 1000");
    }

    @Test
    void testSumaRetiros() {
        // Probamos si suma bien los 200
        double resultado = calculadora.sumarPorTipo(datosPrueba, "Retiro");
        assertEquals(200.0, resultado, "El retiro debería ser 200");
    }

    @Test
    void testBalanceNeto() {
        // 1000 - 200 debe ser 800
        double resultado = calculadora.calcularBalanceNeto(datosPrueba);
        assertEquals(800.0, resultado, "El balance neto falló");
    }

    @Test
    void testManejoMayusculas() {
        // Probamos que 'deposito' minúscula lo cuente igual
        datosPrueba.add(new Transaccion("deposito", 50.0, "03/01"));
        double resultado = calculadora.sumarPorTipo(datosPrueba, "Deposito");
        assertEquals(1050.0, resultado, "Debería ignorar mayúsculas/minúsculas");
    }
}
