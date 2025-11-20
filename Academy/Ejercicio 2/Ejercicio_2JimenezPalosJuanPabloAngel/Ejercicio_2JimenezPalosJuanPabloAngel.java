import java.util.Scanner;

public class Ejercicio_2JimenezPalosJuanPabloAngel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cuenta;

        while (true) {
            System.out.print("Ingresa el número de cuenta: ");
            cuenta = sc.nextLine();

            if (cuenta != null && cuenta.matches("\\d{10}")) {
                System.out.println("La cuenta " + cuenta + " es válida");
                break;
            } else {
                System.out.println("Cuenta inválida, intenta de nuevo.\n");
            }
        }

        sc.close();
    }
}
