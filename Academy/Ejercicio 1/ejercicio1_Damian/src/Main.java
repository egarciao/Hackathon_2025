import java.util.Scanner;
public class interesSimple {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Monto inicial:");
        int monto = scanner.nextInt();

        System.out.print("Tasa de intereses % ?:");
        int intereses = scanner.nextInt();

        System.out.print("a cuantos años:");
        int years = scanner.nextInt();

        int resultado = MONTO * INTERESES * years/100;
        int montofinal = MONTO + RESULTADO;

       System.out.println("interes total:" + RESULTADO);
       System.out.println("monto final:" + MONTOFINAL);

        }
    }