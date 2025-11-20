package Ejercicio_1_Emmanuel_Alexander_Gonzalez_N;

import java.util.Scanner;

public class CalculoInteres {
 public static void main(String[] args) {
     Scanner scanner  = new Scanner(System.in);
     System.out.println("Calculadora de interes \n");


     System.out.println("Ingresa el monto inicial:");
     double montoInicial = scanner.nextDouble();

     System.out.println("Ingresa la tasa de interes anual:");
     double tasaInteres = scanner.nextDouble();

     System.out.println("Ingresa la cantidad de años");
     double yeas = scanner.nextInt();

     double interesTotal  =  montoInicial * (tasaInteres/100) * yeas;
     double montoFinal = montoInicial + interesTotal;

     System.out.println("Interes total generados: " +  interesTotal);
     System.out.println("Monto final acumualdo: " +  montoFinal);
 }

}

