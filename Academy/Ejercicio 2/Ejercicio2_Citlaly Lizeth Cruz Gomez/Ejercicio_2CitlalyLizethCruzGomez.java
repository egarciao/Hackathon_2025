import java.util.Scanner;

public class Ejercicio_2CitlalyLizethCruzGomez {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Bienvenido al sistema de validacion de numero de cuenta ---");
        System.out.println("Nota: Una cuenta valida tiene exactamente 10 digitos numericos. Si desea salir del sistema favor de presionar 0.");

        String cuentaAValidar;


        do {
            System.out.print("\nIngrese el número de cuenta: ");
            cuentaAValidar = scanner.nextLine();

            if (cuentaAValidar.equals("0")) {
                System.out.println("Gracias por usar el sistema de validacion!");
                break;
            }

            if (cuentaAValidar.matches("\\d{10}")) {
                System.out.println("Cuenta valida: " + cuentaAValidar);
            } else {
                System.out.println("Cuenta invalida. Debe tener exactamente 10 numeros.");
            }
        } while (true);
    scanner.close();
    }
}
