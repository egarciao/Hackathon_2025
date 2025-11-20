import java.util.Scanner;

public class InteresSimple {
    public static void main(String[] args) {
        int monto;
        int interes;
        int years;
/////////////////////////////////////////////////////////////////////// ENTRADA
        Scanner scanner = new Scanner(System.in);

//////////////////////////////////////////////////////////////////////// MONTO
        System.out.print("Monto inicial: ");

        while (true){
            if (scanner.hasNextInt()) {
                monto = scanner.nextInt();
                if (monto <= 0) {
                    System.out.println("El monto es incorrecto.");
                    scanner.next();
                    return;
                }
                
                break;
                }
                else {
                System.out.println("solo numeros.");
                scanner.next(); 
                }
        }
/////////////////////////////////////////////////////////////// INTERÉS
        System.out.print("Tasa de interés anual (%): ");

        while (true){
            if (scanner.hasNextInt()) {
         interes = scanner.nextInt();
        if (interes <= 0 || interes > 100) {
            System.out.println("La tasa de interés es incorrecta.");
            scanner.next();
            return;
        }
        
        break;
    }
    else {
        System.out.println("solo numeros.");
        scanner.next(); 
    }
        }
//////////////////////////////////////////////////////////////////////// AÑOS        
        System.out.print("¿A cuántos años?: ");
        while (true){
            if (scanner.hasNextInt()) {
                years = scanner.nextInt();
        int años = scanner.nextInt();
        if (años <= 0 || años > 100) {
            System.out.println("Incorrecto");
            scanner.next();
            return;
        }
        break;
    }
else{
    System.out.println("solo numeros.");
    scanner.next();
}  
 }
/*///////////////////////////////////////////////////////////////////// PROCESO */
       
        int resultado = monto * interes * years / 100;
        int montoFinal = monto + resultado;

        System.out.println("Interés total: $" + resultado);
        System.out.println("Monto final: $" + montoFinal);

        scanner.close();
        }
    }