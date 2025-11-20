package ejercicio.pkg1_gabrielagarciareyes;

/**
 *
 * @author micro
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Empleado{
    
    int id;
    String nombre;
    double salario;

    public Empleado(int id, String nombre, double salario){
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Empleado> empleado = new ArrayList<>();

        empleado.add(new Empleado(1, "Ana G.", 12000));
        empleado.add(new Empleado(2, "Felipe R.", 1200));
        empleado.add(new Empleado(3, "Carolina V.", 14000));
        empleado.add(new Empleado(4, "Manuel L.", 22000));
        empleado.add(new Empleado(5, "Maria N.", 16000));

        double promedio = empleado.stream().mapToDouble(e -> e.salario).average().orElse(0);

        System.out.println("Salario promedio:" + promedio);
        System.out.println("\nEmpleados con salario mayor al promedio:");

        empleado.stream().filter(e -> e.salario > promedio).forEach(e -> System.out.println(e.id + " - " + e.nombre + " - " + e.salario));
        empleado.sort(Comparator.comparingDouble((Empleado e) -> e.salario).reversed());

        System.out.println("\nLista ordenada por salarios descendente:");
        empleado.forEach(e -> System.out.println(e.id + " - " + e.nombre + " - " + e.salario));        
    }
} 
