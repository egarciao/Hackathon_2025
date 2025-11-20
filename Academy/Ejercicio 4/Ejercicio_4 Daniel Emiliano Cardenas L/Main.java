import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Ana", 15000));
        empleados.add(new Empleado(2, "Luis", 22000));
        empleados.add(new Empleado(3, "María", 18000));
        empleados.add(new Empleado(4, "Carlos", 25000));

        double promedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        System.out.println("Salario promedio: " + promedio);

        double valorFiltro = 18000;
        List<Empleado> filtrados = empleados.stream()
                .filter(e -> e.getSalario() > valorFiltro)
                .collect(Collectors.toList());

        System.out.println("\nEmpleados con salario mayor a " + valorFiltro + ":");
        filtrados.forEach(System.out::println);

        List<Empleado> ordenados = empleados.stream()
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("\nEmpleados ordenados por salario (descendente):");
        ordenados.forEach(System.out::println);
    }
}
