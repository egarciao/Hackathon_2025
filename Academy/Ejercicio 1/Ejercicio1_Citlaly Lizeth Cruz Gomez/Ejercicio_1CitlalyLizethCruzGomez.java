import java.util.Scanner;

public class Ejercicio_1CitlalyLizethCruzGomez {
    private double montoInicial;
    private double tasaInteresAnual;
    private double numeroAnios;

    public Ejercicio_1CitlalyLizethCruzGomez (double  montoInicial, double tasaInteresAnual, double numeroAnios) {
        this.montoInicial = montoInicial;
        this.tasaInteresAnual = tasaInteresAnual;
        this.numeroAnios = numeroAnios;
    }

    public double calculoInteres () {
        return montoInicial * (tasaInteresAnual/100) * numeroAnios;
    }

   public double calculoMontoFinal () {
        return montoInicial + calculoInteres();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - Bienvenido al sistema de calculo de interes simple - - -");
        
        System.out.println("Favor de ingresar el monto inicial de su cuenta:");
        double monto = scanner.nextDouble();

        System.out.println("\n Favor de ingresar el interes de su cuenta:");
        double interes = scanner.nextDouble();

        System.out.println("\n Favor de ingresar el numero de años que lleva con la deuda:");
        double aniosDeuda = scanner.nextDouble();

        Ejercicio_1CitlalyLizethCruzGomez cuenta1 = new Ejercicio_1CitlalyLizethCruzGomez(monto, interes, aniosDeuda);
        double resCalculoInteres = cuenta1.calculoInteres();
        double resCalculoMontoFinal = cuenta1.calculoMontoFinal();

        System.out.println("\n Dando como resultado la siguiente informacion:");
        System.out.println("Interes total: " + resCalculoInteres);
        System.out.println("Monto final: " + resCalculoMontoFinal);
        scanner.close();
    }
}