import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_3CitlalyLizethCruzGomez {
    private int id;
    private String nombre;
    private double saldo;

    public Ejercicio_3CitlalyLizethCruzGomez (int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public double getSaldo () {
        return saldo;
    }

    public String getNombre () {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {   
        Scanner scanner = new Scanner(System.in);
        int opcionCase;
        
        //Lista de clientes
        ArrayList<Ejercicio_3CitlalyLizethCruzGomez> clientes = new ArrayList<>();
        clientes.add(new Ejercicio_3CitlalyLizethCruzGomez(1, "Saul", 50000));
        clientes.add(new Ejercicio_3CitlalyLizethCruzGomez(2, "Ian", 40000));
        clientes.add(new Ejercicio_3CitlalyLizethCruzGomez(3, "Ricardo", 37800));
        clientes.add(new Ejercicio_3CitlalyLizethCruzGomez(4, "Fabiola", 98000));
        clientes.add(new Ejercicio_3CitlalyLizethCruzGomez(5, "Ignacio", 24000));

        do {
            System.out.println("\n ------  Bienvenido al registro de clientes ------");
            System.out.println("1. Listar clientes. ");
            System.out.println("2. Mostrar cliente con mayor saldo. ");
            System.out.println("3. Eliminar todos los clientes. ");
            System.out.println("4. Añadir cliente. ");
            System.out.println("5. Salir ");
            opcionCase = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionCase) {
                case 1:
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                        break;
                    }

                    System.out.println ("Actualmente los clientes existentes son:");

                    for (Ejercicio_3CitlalyLizethCruzGomez cl : clientes) {
                            System.out.println (cl.getNombre() + " con un saldo de " + cl.getSaldo() );
                    }

                    break;

                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                        break;
                    }
                    
                    System.out.println("\nEl cliente con mayor saldo es:");
                    clientes.sort ((cl1,cl2) -> Double.compare(cl2.getSaldo(), cl1.getSaldo()));
                    System.out.println(clientes.get(0).getNombre() + " con un saldo de " + clientes.get(0).getSaldo());
                    break;

                case 3:
                    clientes.clear();
                    System.out.println("\nSe eliminaron todos los clientes correctamente.");
                    
                    break;

                case 4:
                    System.out.println("Favor de proporcionar el nombre del cliente:");
                    String nombreCliente = scanner.nextLine();

                    System.out.println("Favor de proporcionar el saldo del cliente:");
                    double saldoCliente = scanner.nextDouble();
                    scanner.nextLine(); // limpiar buffer


                     int nuevoId = clientes.size() + 1;

                    Ejercicio_3CitlalyLizethCruzGomez nuevoCliente = new Ejercicio_3CitlalyLizethCruzGomez(nuevoId, nombreCliente, saldoCliente);
                    clientes.add(nuevoCliente);

                    System.out.println("\nCliente añadido correctamente:");
                    System.out.println(nombreCliente + " con saldo de " + saldoCliente);
                    break;
                case 5:
                    System.out.println("Que tengas un lindo dia :)");
                    break;

                default:
                    System.out.println("\n Opcion no valida");
                    break;
            }

        } while ( opcionCase != 5);
        
        scanner.close();}
}
