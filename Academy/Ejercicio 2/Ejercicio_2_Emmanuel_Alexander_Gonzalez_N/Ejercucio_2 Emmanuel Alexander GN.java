package Ejercicio_2_Emmanuel_Alexander_Gonzalez_N;
import java.util.Scanner;
public class ValidarCuenta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Validar Cuenta");
        System.out.println("Ingresa el numero de cuenta:");
        String cuenta = scanner.nextLine();

        if(esvalida(cuenta)){
            System.out.println("La cuenta es valido");
        }else{
            System.out.println("La cuenta no es valido");

        }

    }
    public static boolean esvalida(String cuenta){
        if(cuenta==null) return false;
        return cuenta.matches("\\d{10}");
    }
}
