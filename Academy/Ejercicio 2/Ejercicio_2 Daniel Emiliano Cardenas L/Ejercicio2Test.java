import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio2Test {

    @Test
    public void testValidAccountNumber() {
        assertTrue(Ejercicio2.isValidAccountNumber("1234567890"));
    }

    @Test
    public void testInvalidAccountNumberTooShort() {
        assertFalse(Ejercicio2.isValidAccountNumber("123456789"));
    }

    @Test
    public void testInvalidAccountNumberTooLong() {
        assertFalse(Ejercicio2.isValidAccountNumber("12345678901"));
    }

    @Test
    public void testInvalidAccountNumberNonNumeric() {
        assertFalse(Ejercicio2.isValidAccountNumber("12345abcde"));
    }

    @Test
    public void testInvalidAccountNumberNull() {
        assertFalse(Ejercicio2.isValidAccountNumber(null));
    }

    @Test
    public void testInvalidAccountNumberEmpty() {
        assertFalse(Ejercicio2.isValidAccountNumber(""));
    }

    @Test
    public void testValidAccountNumberWithLeadingZeros() {
        assertTrue(Ejercicio2.isValidAccountNumber("0000000001"));
    }
}
