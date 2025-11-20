package main.java.com;
import java.util.Scanner;
import java.text.DecimalFormat;

public class InteresCalculoPrueb {

    private static final DecimalFormat fd = new DecimalFormat("#.00");

    /**
     * * @param montoInicial El capital inicial (P).
     * @param tasaAnualPorcentaje La tasa de interés anual en porcentaje (ej. 10).
     * @param tiempoAnos El número de años (t).
     * @return array
     */

    public static double[] calcularInteresYFinal(double montoInicial, double tasaAnualPorcentaje, int tiempoAnos) {
        double tasaDecimal = tasaAnualPorcentaje / 100.0;
        double interesTotal = montoInicial * tasaDecimal * tiempoAnos;
        double montoFinal = montoInicial + interesTotal;
        return new double[]{interesTotal, montoFinal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Calcula el Interes Simple (Refactorizado)");
        System.out.print("Ingresa el Monto Inicial (P) :");
        double montoInicial = scanner.nextDouble();
        System.out.print("Ingresa la Tasa de Interes Anual (sin porcentaje, ej. 10 para 10%) :");
        double tasaAnualPorcentaje = scanner.nextDouble();
        System.out.print("Ingresa el Numero de Años (t) :");
        int tiempo = scanner.nextInt();
        scanner.close();

        double[] resultados = calcularInteresYFinal(montoInicial, tasaAnualPorcentaje, tiempo);
        double interesTotal = resultados[0];
        double montoFinal = resultados[1];
        
        System.out.println("Resultado del Calculo");
        System.out.println("Monto Inicial (P) :" + fd.format(montoInicial));
        System.out.println("Tasa Anual (r) :" + fd.format(tasaAnualPorcentaje) + "%");
        System.out.println("Tiempo (Años) (t) :" + tiempo);
        System.out.println("Interes Total Ganado (I) :" + fd.format(interesTotal));
        System.out.println("Monto Final Total (A) :" + fd.format(montoFinal));
    }
}