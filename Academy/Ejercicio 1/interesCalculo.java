package main.java.com;
import java.util.Scanner;
import java.text.DecimalFormat;

public class interesCalculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat fd = new DecimalFormat("#.00");

        System.out.println("Calcula el Interes Publico");
        System.out.println("Ingresa el Monto Inicial (I) :");
        double montoInicial = scanner.nextDouble();
        System.out.println("Ingresa la Tasa de Interes Anual (sin porcentaje, ej. 10 de 10%) :");
        double tasaAnualPorcentaje = scanner.nextDouble();
        double tasaDecimal = tasaAnualPorcentaje / 100.0;
        System.out.println("Ingresa el Numero de Años (t) :");
        int tiempo = scanner.nextInt();
        scanner.close();

        double interesTotal = montoInicial * tasaDecimal * tiempo;
        double montoFinal = montoInicial + interesTotal;

        System.out.println("Resultado del Calculo :");
        System.out.println("Monto Inicial :" + fd.format(montoInicial));
        System.out.println("Tasa Anual (%) :" + fd.format(tasaAnualPorcentaje) + "%");
        System.out.println("Tiempo (Años) :" + tiempo);
        System.out.println("Interes Total Ganado (I) :" + fd.format(interesTotal));
        System.out.println("Monto Final Total :" + fd.format(montoFinal));
    }
}