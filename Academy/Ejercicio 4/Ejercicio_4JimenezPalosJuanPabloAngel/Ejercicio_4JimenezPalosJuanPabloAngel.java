import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaccion {
    private String tipo; // "deposito" o "retiro"
    private double monto;
    private LocalDate fecha;

    public Transaccion(String tipo, double monto, LocalDate fecha) {
        if (!tipo.equals("deposito") && !tipo.equals("retiro")) {
            throw new IllegalArgumentException("Tipo inválido. Debe ser 'deposito' o 'retiro'.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String obtenerTipo() {
        return tipo;
    }

    public double obtenerMonto() {
        return monto;
    }

    public LocalDate obtenerFecha() {
        return fecha;
    }

    public String descripcion() {
        return tipo.toUpperCase() + " de $" + monto + " el " + fecha;
    }
}

class Registro {
    private List<Transaccion> transacciones;

    public Registro() {
        this.transacciones = new ArrayList<Transaccion>();
    }

    public double obtenerSaldoActual() {
        return calcularTotalDepositos() - calcularTotalRetiros();
    }

    public void agregarTransaccion(String tipo, double monto, LocalDate fecha) {
        if (tipo.equals("retiro") && monto > obtenerSaldoActual()) {
            System.out.println("No se puede retirar más del saldo disponible. Saldo actual: $" + obtenerSaldoActual());
            return;
        }
        try {
            Transaccion t = new Transaccion(tipo, monto, fecha);
            transacciones.add(t);
            System.out.println("Transacción registrada: " + t.descripcion());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calcularTotalDepositos() {
        double total = 0;
        for (Transaccion t : transacciones) {
            if (t.obtenerTipo().equals("deposito")) {
                total += t.obtenerMonto();
            }
        }
        return total;
    }

    public double calcularTotalRetiros() {
        double total = 0;
        for (Transaccion t : transacciones) {
            if (t.obtenerTipo().equals("retiro")) {
                total += t.obtenerMonto();
            }
        }
        return total;
    }

    public void mostrarTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (Transaccion t : transacciones) {
                System.out.println(t.descripcion());
            }
        }
    }
}

public class Ejercicio_4JimenezPalosJuanPabloAngel {
    public static void main(String[] args) {
        Registro registro = new Registro();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de transacciones");
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione tipo de transacción:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Retiro");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine().trim();

            String tipo;
            if (opcion.equals("1")) {
                tipo = "deposito";
            } else if (opcion.equals("2")) {
                tipo = "retiro";
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese monto: ");
            double monto;
            try {
                monto = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Debe ser un número.");
                continue;
            }

            LocalDate fecha = LocalDate.now();
            registro.agregarTransaccion(tipo, monto, fecha);

            System.out.print("¿Desea ingresar otra transacción? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s");
        }

        System.out.println("\nTransacciones registradas:");
        registro.mostrarTransacciones();

        System.out.println("\nTotal depósitos: $" + registro.calcularTotalDepositos());
        System.out.println("Total retiros: $" + registro.calcularTotalRetiros());
        System.out.println("Saldo final: $" + registro.obtenerSaldoActual());

        scanner.close();
    }
}