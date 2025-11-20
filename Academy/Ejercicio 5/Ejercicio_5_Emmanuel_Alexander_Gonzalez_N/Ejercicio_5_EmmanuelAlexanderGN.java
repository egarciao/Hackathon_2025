package Ejercicio_5_Emmanuel_Alexander_Gonzalez_N;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejercicio_5_EmmanuelAlexanderGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n1. Saldo\n2. Depositar\n3. Retirar\n4. Salir");
                System.out.print("Opcion: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo: " + saldo);
                        break;

                    case 2:
                        System.out.print("Monto: ");
                        double deposito = scanner.nextDouble();
                        if (deposito > 0) {
                            saldo += deposito;
                            System.out.println("Nuevo saldo: " + saldo);
                        } else {
                            System.out.println("Error: Monto invalido");
                        }
                        break;

                    case 3:
                        System.out.print("Monto: ");
                        double retiro = scanner.nextDouble();
                        if (retiro <= 0) {
                            System.out.println("Error: Monto invalido");
                        } else if (retiro > saldo) {
                            System.out.println("Error: Fondos insuficientes");
                        } else {
                            saldo -= retiro;
                            System.out.println("Nuevo saldo: " + saldo);
                        }
                        break;

                    case 4:
                        System.out.println("Fin");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Solo numeros");
                scanner.next();
            }
        }
        scanner.close();
    }

}
