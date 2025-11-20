import java.util.Scanner;

/*
Ejercicio 2: Validación de Número de Cuenta

Descripción:
Verifica si un número de cuenta bancaria (string) es válido. Una cuenta válida tiene exactamente 10 dígitos numéricos.
* */
public class Main {
    public static void main(String[] args) {

String numero_cuenta = "";
    Scanner s= new Scanner(System.in);
    int b=0;
    int bandera=0;
        System.out.println("Ingresa el número de cuenta bancaria");
            String numero=s.nextLine();
            numero_cuenta=numero;
    if (numero_cuenta.length()<11&&numero_cuenta.length()>9){
        System.out.println("Válido");
        }else {
        System.out.println("Error: La cuenta no tiene los 10 digitos necesarios volver a ingresar.");
    }

        try {
            b=Integer.parseInt(numero);

        } catch (Exception e) {
            System.out.println("Error Dato incorrecto: Ingresa numeros.");

        }
    }
}