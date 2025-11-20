package calculodeinteresessimple;
import java.util.Scanner;

/**
 *
 * @author micro
 */
public class CalculoDeInteresesSimple {

    public static void main(String[] args) {
        
        Scanner sc = new
                Scanner(System.in);
        System.out.println("Ingresa el saldo inicial:");
        double saldoInicial = sc.nextDouble();
        System.out.println("Ingresa la tasa de Intereses:");
        int tasaDeIntereses = sc.nextInt();
        
        double tasaDecimal = tasaDeIntereses / 100.0;
        
        System.out.println("Ingresa el numero de agnos:");
        int numeroDeAños = sc.nextInt();
        
        double interesGenerado = saldoInicial * tasaDecimal * numeroDeAños;
        double saldoFinal = saldoInicial + interesGenerado;
        
        System.out.println("-----------------------------------------------");
        System.out.println("Saldo inicial:  " + saldoInicial);
        System.out.println("Tasa de interes del:  " + tasaDecimal + "%");
        System.out.println("Agnos:  "+ numeroDeAños);
        System.out.println("Interes Generado:  " + interesGenerado);
        System.out.println("Saldo Final:  " + saldoFinal);      
    }
    
}
