import java.util.*;

class Cliente {
    private int id;
    private String nombre;
    private double saldo;

    public Cliente(int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Ejercicio_3JimenezPalosJuanPabloAngel {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Ana", 2500.50));
        clientes.add(new Cliente(2, "Luis", 3200.75));
        clientes.add(new Cliente(3, "María", 1800.00));

        Cliente clienteMayorSaldo = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.getSaldo() > clienteMayorSaldo.getSaldo()) {
                clienteMayorSaldo = c;
            }
        }

        System.out.println("Cliente con mayor saldo:");
        System.out.println("ID: " + clienteMayorSaldo.getId());
        System.out.println("Nombre: " + clienteMayorSaldo.getNombre());
        System.out.println("Saldo: $" + clienteMayorSaldo.getSaldo());
    }
}