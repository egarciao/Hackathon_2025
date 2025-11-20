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
}
