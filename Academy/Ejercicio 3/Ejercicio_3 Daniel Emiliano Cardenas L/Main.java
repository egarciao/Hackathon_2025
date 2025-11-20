import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Ana", 1500.50));
        clientes.add(new Cliente(2, "Luis", 5400.00));
        clientes.add(new Cliente(3, "María", 3250.75));
        clientes.add(new Cliente(4, "Carlos", 4100.00));
        clientes.add(new Cliente(5, "Elena", 2750.20));
        clientes.add(new Cliente(6, "Diego", 6200.40));

        if (clientes.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Cliente mayor = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.getSaldo() > mayor.getSaldo()) {
                mayor = c;
            }
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));

        System.out.println();
        System.out.println("Listado de clientes:");
        System.out.println("------------------------------------------------");
        System.out.printf("%-4s %-15s %12s%n", "ID", "Nombre", "Saldo");
        System.out.println("------------------------------------------------");
        for (Cliente c : clientes) {
            String saldo = nf.format(c.getSaldo());
            String marcador = (c == mayor) ? "  <== Mayor saldo" : "";
            System.out.printf("%-4d %-15s %12s%s%n", c.getId(), c.getNombre(), saldo, marcador);
        }
        System.out.println("------------------------------------------------");
        System.out.println();
    }
}
