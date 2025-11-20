package Ejercicio_6_Emmanuel_Alexander_Gonzalez_N;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ejercicio_6_1_EmmanuelAlexanerGN {
    @Test
    void testConstanciaBancariaMasiva() throws InterruptedException {
        Cuenta cuentaA = new Cuenta(1,50000);
        Cuenta cuentaB = new Cuenta(2,50000);
        double totalEsperado = 100000;
        int numHilos = 100;
        ExecutorService executor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < numHilos; i++) {
            if(i%2==0){
                executor.execute(new Tranferencia(cuentaA,cuentaB,10));
            }
            else{
                executor.execute(new Tranferencia(cuentaB,cuentaA,10));
            }
        }
        executor.shutdown();
        boolean terminaron = executor.awaitTermination(1, TimeUnit.MINUTES);

        assertTrue(terminaron, "Los hilos tardaron demasiado");

        double totalReal = cuentaA.getSaldo() + cuentaB.getSaldo();

        System.out.println("Total Esperado: " + totalEsperado);
        System.out.println("Total Real:      " + totalReal);

        assertEquals(totalEsperado, totalReal, "Error: Se perdió dinero");

    }
    // TEST 2: Stress Test (Alta Carga)
    // Probamos con 10,000 operaciones para forzar la CPU
    @Test
    void testStressMasivo() throws InterruptedException {
        Cuenta cuentaA = new Cuenta(1, 1000000);
        Cuenta cuentaB = new Cuenta(2, 1000000);
        double totalEsperado = 2000000;
        int numTransacciones = 10000; // ¡Muchos hilos!

        ExecutorService executor = Executors.newFixedThreadPool(100); // 100 hilos simultáneos

        for (int i = 0; i < numTransacciones; i++) {
            // Aleatoriedad simple: Unos van y otros vienen
            if (i % 2 == 0) executor.execute(new Tranferencia(cuentaA, cuentaB, 50));
            else executor.execute(new Tranferencia(cuentaB, cuentaA, 50));
        }

        executor.shutdown();
        boolean aTiempo = executor.awaitTermination(2, TimeUnit.MINUTES);
        
        assertTrue(aTiempo, "El test de stress tardó demasiado");
        assertEquals(totalEsperado, cuentaA.getSaldo() + cuentaB.getSaldo(), "Error en test de stress");
    }

    // TEST 3: Intento de sobregiro concurrente (Saldo Insuficiente)
    // Cuenta A tiene 1000. 20 hilos intentan sacar 100 cada uno (Total 2000).
    // Solo deberían poder salir 1000. El saldo nunca debe ser negativo.
    @Test
    void testSaldoInsuficienteConcurrente() throws InterruptedException {
        Cuenta cuentaA = new Cuenta(1, 1000); // Poco dinero
        Cuenta cuentaB = new Cuenta(2, 0);
        
        int hilos = 20;
        ExecutorService executor = Executors.newFixedThreadPool(hilos);

        for (int i = 0; i < hilos; i++) {
            // Todos intentan sacar 100 de A
            executor.execute(new Tranferencia(cuentaA, cuentaB, 100));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Validaciones
        System.out.println("Saldo Final A (Debe ser 0 o positivo): " + cuentaA.getSaldo());
        
        assertTrue(cuentaA.getSaldo() >= 0, "ERROR CRÍTICO: El saldo quedó negativo");
        assertEquals(1000, cuentaA.getSaldo() + cuentaB.getSaldo(), "El dinero total cambió");
    }

    // TEST 4: Transferencia a la misma cuenta
    @Test
    void testTransferenciaMismaCuenta() throws InterruptedException {
        Cuenta cuentaA = new Cuenta(1, 5000);
        double saldoInicial = 5000;
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for(int i=0; i<50; i++) {
            // A se transfiere a A
            executor.execute(new Tranferencia(cuentaA, cuentaA, 100));
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        assertEquals(saldoInicial, cuentaA.getSaldo(), "El saldo cambió al transferirse a sí mismo");
    }
}
