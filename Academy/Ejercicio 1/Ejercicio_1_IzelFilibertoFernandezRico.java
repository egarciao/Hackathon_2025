import java.util.Scanner;

public class Ejercicio_1_IzelFilibertoFernandezRico {
  public static void main() {
    Scanner a = new Scanner(System.in);
    Double NumeroAnos = 0.0;
    Double MontoInicial = 0.0;
    Double TasaDeInteres = 0.0;
    Integer flag = 0;

    System.out.println("Ingresa el numero del Monto");
    try {
      Double Monto = a.nextDouble();
      MontoInicial = Monto;
    } catch (Exception e) {
        System.out.println("Tipo de dato incorrecto");
        flag = 1;
    }
  
     if (flag == 0) {
  
      System.out.println("Ingresa el numero de Años");
      try {
          Double Monto = a.nextDouble();
         NumeroAnos = Monto;
      } catch (Exception e) {
        System.out.println("Tipo de dato incorrecto");
        flag = 1;
      }
  
      if (flag == 0) {
  
        System.out.println("Ingresa la tasa de interes");
        try {
          Double Monto = a.nextDouble();
          TasaDeInteres = Monto;
        } catch (Exception e) {
          System.out.println("Tipo de dato incorrecto");
          flag = 1;
        }
  
        if (flag == 0) {
          Double InteresTotal = MontoInicial * NumeroAnos;
          Double MontoFinal = MontoInicial+(InteresTotal * (TasaDeInteres/100));
          if(MontoInicial <= 0 || NumeroAnos <= 0 || TasaDeInteres <= 0 || TasaDeInteres >= 18 ){
            System.out.println("El monto final no es valido");
            return;
          }
          System.out.println("El monto final es: ");
          System.out.println(MontoFinal);
        }
      }
    }
  }
}