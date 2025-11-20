package ejemplo;
import java.util.Scanner;
/*
Ejercicio 1: Cálculo de Interés Simple
Descripción:
Implementa un programa que calcule el interés simple de una cuenta bancaria.
Requerimientos:
•	El programa debe solicitar: monto inicial, tasa de interés anual (%), y número de años.
•	Debe imprimir el interés total y el monto final.
* */
public class ejercicio {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Cálculo de Interés Simple");
        double mon_inicial = 0;
        double tasa_interes = 0;
        double tiempo = 0;


        try {

                System.out.println("Ingresa tu monto inicial");
                double mon_inicial2 = s.nextDouble();
                mon_inicial = mon_inicial2;

        } catch (Exception e) {
            System.out.println("Error Dato incorrecto: Ingresa numeros.");

        }

        try {
            System.out.println("Ingresa tu tasa de interes");
            double tasa_interes2= s.nextDouble();
            tasa_interes=tasa_interes2/100;
        } catch (Exception e) {
            System.out.println("Error Dato incorrecto: Ingresa numeros.");
        }

            try {
                System.out.println("Ingresa el numero de años");
                double tiempo2 = s.nextDouble();
                tiempo=tiempo2;

            } catch (Exception e) {
                System.out.println("Error Dato incorrecto: Ingresa numeros.");
            }
        double interes_total= mon_inicial*tiempo;
        double monto_final= ((interes_total*tasa_interes)+mon_inicial);

        System.out.println(monto_final);
    }
}
