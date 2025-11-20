package test.java.com;
import org.junit.jupiter.api.Test;

import main.java.com.InteresCalculoPrueb;

import static org.junit.jupiter.api.Assertions.*;

public class interesTest {

    private static final double DELTA = 0.0001; 

    @Test
    void testCasoBaseEstandar() {
        // Datos de Prueba: P = 1000, r = 10% (0.10), t = 5 años
        // Cálculo Manual Esperado: 
        // Interés: 1000 * 0.10 * 5 = 500.0
        // Monto Final: 1000 + 500 = 1500.0
        double principal = 1000.0;
        double tasa = 10.0;
        int tiempo = 5;

        double[] resultado = InteresCalculoPrueb.calcularInteresYFinal(principal, tasa, tiempo);

        assertEquals(500.0, resultado[0], DELTA, "El cálculo del Interés Total es incorrecto en el caso estándar.");
        assertEquals(1500.0, resultado[1], DELTA, "El cálculo del Monto Final es incorrecto en el caso estándar.");
    }

    @Test
    void testCasoConTasaDecimal() {
        // Datos de Prueba: P = 2000, r = 7.5% (0.075), t = 2 años
        // Cálculo Manual Esperado: 
        // Interés: 2000 * 0.075 * 2 = 300.0
        // Monto Final: 2000 + 300 = 2300.0
        double principal = 2000.0;
        double tasa = 7.5; // Tasa con decimal
        int tiempo = 2;

        double[] resultado = InteresCalculoPrueb.calcularInteresYFinal(principal, tasa, tiempo);

        assertEquals(300.0, resultado[0], DELTA, "El cálculo del Interés Total es incorrecto con tasa decimal.");
        assertEquals(2300.0, resultado[1], DELTA, "El cálculo del Monto Final es incorrecto con tasa decimal.");
    }

    @Test
    void testCasoConTiempoCero() {
        double principal = 1000.0;
        double tasa = 5.0;
        int tiempo = 0; 

        double[] resultado = InteresCalculoPrueb.calcularInteresYFinal(principal, tasa, tiempo);

        assertEquals(0.0, resultado[0], DELTA, "El interés debe ser cero si el tiempo es cero.");
        assertEquals(principal, resultado[1], DELTA, "El Monto Final debe ser igual al Principal si el tiempo es cero.");
    }
}
