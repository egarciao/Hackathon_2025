import java.util.Scanner;

public class Ejercicio_5CitlalyLizethCruzGomez {
    private double saldo;

    public Ejercicio_5CitlalyLizethCruzGomez (double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo () {
        return saldo;
    }

    public void setSaldo (double saldo) {
        this.saldo = saldo;
    } 

    public static double leerNumero(Scanner scanner, String mensaje) {
    double numero;

    while (true) {
        System.out.print(mensaje);

        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada invalida. Solo se permiten numeros.");
            scanner.nextLine();  
            System.out.print(mensaje);
        }

        numero = scanner.nextDouble();

        if (numero < 0) {
            System.out.println("El numero no puede ser negativo.");
            continue; 
        }

        return numero; 
    }
}

    public static void main(String[] args) {       
        Scanner scanner = new Scanner(System.in);
        int opcionCase;

        Ejercicio_5CitlalyLizethCruzGomez saldoCliente = new Ejercicio_5CitlalyLizethCruzGomez(5000);

        do {
            System.out.println("\n ------  Bienvenido al registro de clientes ------");
            System.out.println("1. Consultar saldo. ");
            System.out.println("2. Depositar. ");
            System.out.println("3. Retirar. ");
            System.out.println("4. Salir ");
            opcionCase = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionCase) {
                case 1:
                    System.out.println("Tu saldo es de: " + saldoCliente.getSaldo());
                    break;

                case 2:
                    double deposito = leerNumero(scanner, "Cantidad a depositar: ");
                    saldoCliente.setSaldo(saldoCliente.getSaldo() + deposito);
                    
                    System.out.println("Tu saldo es: " + saldoCliente.getSaldo());
                    break;

                case 3:
                    double retiro = leerNumero(scanner, "Cantidad a retirar: ");
                    if (retiro > saldoCliente.getSaldo()) {
                        System.out.println("No puedes retirar más de lo que tienes.");
                    } else {
                        saldoCliente.setSaldo(saldoCliente.getSaldo() - retiro);
                    }

                    System.out.println("Tu saldo es: " + saldoCliente.getSaldo());
                    break;

                case 4: 
                    System.out.println("Que tengas un lindo dia :)");
                    break;
            
                default:
                    System.out.println("\n Opcion no valida");
                    break;
            }

        } while (opcionCase != 5);
    }
}
