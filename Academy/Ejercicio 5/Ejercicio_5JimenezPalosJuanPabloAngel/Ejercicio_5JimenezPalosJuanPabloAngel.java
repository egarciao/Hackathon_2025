import java.util.Scanner;

public class Ejercicio_5JimenezPalosJuanPabloAngel {
    
    private double montoActual;

    public Ejercicio_5JimenezPalosJuanPabloAngel(double montoInicial) {
        this.montoActual = montoInicial;
    }

    public double obtenerMonto() {
        return montoActual;
    }

    public void actualizarMonto(double nuevoMonto) {
        this.montoActual = nuevoMonto;
    }

    // Método para validar entrada numérica
    public static double pedirCantidad(Scanner entrada, String texto) {
        double valor;

        while (true) {
            System.out.print(texto);

            if (entrada.hasNextDouble()) {
                valor = entrada.nextDouble();

                if (valor >= 0) {
                    return valor; 
                } else {
                    System.out.println("No se permiten cantidades negativas.");
                }
            } else {
                System.out.println("Error: escribe un número válido.");
                entrada.next(); 
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int opcion;

        Ejercicio_5JimenezPalosJuanPabloAngel cliente = new Ejercicio_5JimenezPalosJuanPabloAngel(5000);

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1) Ver saldo disponible");
            System.out.println("2) Agregar dinero");
            System.out.println("3) Sacar dinero");
            System.out.println("4) Terminar programa");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Saldo actual: " + cliente.obtenerMonto());
                    break;

                case 2:
                    double agregar = pedirCantidad(teclado, "Ingresa la cantidad a agregar: ");
                    cliente.actualizarMonto(cliente.obtenerMonto() + agregar);
                    System.out.println("Nuevo saldo: " + cliente.obtenerMonto());
                    break;

                case 3:
                    double quitar = pedirCantidad(teclado, "Ingresa la cantidad a retirar: ");
                    
                    if (quitar > cliente.obtenerMonto()) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        cliente.actualizarMonto(cliente.obtenerMonto() - quitar);
                    }

                    System.out.println("Saldo actualizado: " + cliente.obtenerMonto());
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
            }

        } while (opcion != 4);

        teclado.close();
    }
}
