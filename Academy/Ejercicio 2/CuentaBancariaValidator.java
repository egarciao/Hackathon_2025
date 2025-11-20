package main.java.com;

public class CuentaBancariaValidator {

    /**
     * * @param numeroCuenta La cadena de texto a validar.
     * @return true si la cuenta es válida (10 dígitos numéricos), false en caso contrario.
     */
    public static boolean esNumeroCuentaValido(String numeroCuenta) {
        if (numeroCuenta == null) {
            return false;
        }

        if (numeroCuenta.length() != 10) {
            return false;
        }

        return numeroCuenta.matches("\\d+"); 
    }

    public static void main(String[] args) {
        String cuentaValidaEjemplo = "1234567890"; // Válida
        String cuentaCortaEjemplo = "123456789";  // Inválida (9 dígitos)
        String cuentaConLetrasEjemplo = "123456789A"; // Inválida (carácter no numérico)

        System.out.println("Validacion de Numeros de Cuenta");
        System.out.println("Cuenta " + cuentaValidaEjemplo + " es valida: " + esNumeroCuentaValido(cuentaValidaEjemplo));
        System.out.println("Cuenta " + cuentaCortaEjemplo + " es valida: " + esNumeroCuentaValido(cuentaCortaEjemplo));
        System.out.println("Cuenta " + cuentaConLetrasEjemplo + " es valida: " + esNumeroCuentaValido(cuentaConLetrasEjemplo));
    }
}