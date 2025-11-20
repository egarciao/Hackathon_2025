package test.java.com;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.com.CuentaBancariaValidator;

public class CuentaBancariaValidatorTest {

    @Test
    void testCuentaValidaDiezDigitos() {
        String cuenta = "1234567890";
        assertTrue(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                   "La cuenta de 10 dígitos debería ser válida.");
    }

    @Test
    void testCuentaMenosDeDiezDigitos() {
        String cuenta = "12345";
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "La cuenta con menos de 10 dígitos no debería ser válida.");
    }

    @Test
    void testCuentaMasDeDiezDigitos() {
        String cuenta = "1234567890123";
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "La cuenta con más de 10 dígitos no debería ser válida.");
    }

    @Test
    void testCuentaConCaracteresNoNumericos() {
        String cuenta = "123456789A";
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "La cuenta con letras no debería ser válida.");
    }

    @Test
    void testCuentaConEspacios() {
        String cuenta = "1234 567890";
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "La cuenta con espacios no debería ser válida.");
    }

    @Test
    void testCuentaNula() {
        String cuenta = null;
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "Una cuenta nula no debería ser válida.");
    }

    @Test
    void testCuentaVacia() {
        String cuenta = "";
        assertFalse(CuentaBancariaValidator.esNumeroCuentaValido(cuenta), 
                    "Una cuenta vacía no debería ser válida.");
    }
}