import java.util.Scanner;

public class Ejercicio_1JimenezPalosJuanPabloAngel{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // para que ingrese datillos el usuario 

        System.out.print("Ingrese el monto inicial: ");
        double mI = scanner.nextDouble();

        System.out.print("Ingrese la tasa de interés anual (%): ");
        double tasaInteres = scanner.nextDouble();

        System.out.print("Ingrese el número de años: ");
        int years = scanner.nextInt();

        double interes = (mI * tasaInteres * years) / 100;

        double montoFinal = mI + interes;

        System.out.printf("\nInterés total ganado: $%.2f\n", interes);
        System.out.printf("Monto final después de %d años: $%.2f\n", years, montoFinal);

        scanner.close();
    }
}

