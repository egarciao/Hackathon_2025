import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ejercicio_4_4CitlalyLizethCruzGomez {

    private Ejercicio_4CitlalyLizethCruzGomez registro;

    @BeforeEach
    public void setUp() {
        registro = new Ejercicio_4CitlalyLizethCruzGomez();
    }

    // Prueba de conteo
    @Test
    public void testValidarTotalesNormales() {
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("Deposito", 1000, "2025-11-19"));
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("Retiro", 500, "2025-11-19"));
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("Deposito", 200, "2025-11-19"));


        assertEquals(2, registro.totalDepositos(), "Fallo: El total de depósitos debería ser 2");
        assertEquals(1, registro.totalRetiros(), "Fallo: El total de retiros debería ser 1");
    }

    // Validar el tipo
    @Test
    public void testValidarMayusculasYMinusculas() {
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("deposito", 100, "2025-11-20"));
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("DEPOSITO", 500, "2025-11-20"));
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("retiro", 50, "2025-11-20"));

        assertEquals(2, registro.totalDepositos(), "El sistema debe contar 'deposito' y 'DEPOSITO' como iguales");
        assertEquals(1, registro.totalRetiros(), "El sistema debe contar 'retiro' en minúsculas correctamente");
    }

    // Validar lista vacia
    @Test
    public void testListaVacia() {

        assertEquals(0, registro.totalDepositos(), "Si no hay datos, depósitos debe ser 0");
        assertEquals(0, registro.totalRetiros(), "Si no hay datos, retiros debe ser 0");
    }
    
    // Validar retiros
    @Test
    public void testSoloRetiros() {
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("Retiro", 100, "2025-11-21"));
        registro.agregarTransaccion(new Ejercicio_4CitlalyLizethCruzGomez.Transaccion("Retiro", 100, "2025-11-21"));
        
        assertEquals(0, registro.totalDepositos(), "No debería haber depósitos");
        assertEquals(2, registro.totalRetiros(), "Deberían ser 2 retiros");
    }
}