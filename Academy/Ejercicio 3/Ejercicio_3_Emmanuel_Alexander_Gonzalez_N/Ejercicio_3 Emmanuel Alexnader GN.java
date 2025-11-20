package Ejercicio_3_Emmanuel_Alexander_Gonzalez_N;
import java.util.ArrayList;
import java.util.List;
class Cliente{
    private int id;
    private String nombre;
    private double saldo;

    public  Cliente(int id, String nombre, double saldo){
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public double getSaldo(){
        return saldo;
    }
    @Override
    public String toString(){
        return "ID: " + id + " - " + nombre + " - Saldo: $" + saldo;
    }
}

public class GestionClientes {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<Cliente>();


        listaClientes.add(new Cliente(1, "Juan", 1500.50));
        listaClientes.add(new Cliente(2, "Maria", 5000.00));
        listaClientes.add(new Cliente(3, "Carlos", 3200.00));
        listaClientes.add(new Cliente(4, "Ana", 8500.75));
        listaClientes.add(new Cliente(5, "Pedro", 100.00));
//        System.out.println("Lista de clientes:");
//        listaClientes.forEach(System.out::println);

        System.out.println("Cliente con Mayor Saldo:");
        Cliente ClienteConMayorSaldo = null;
        double mayorSaldoActual = -1.0;

        for(Cliente cliente : listaClientes){
            if(cliente.getSaldo() > mayorSaldoActual){
                mayorSaldoActual = cliente.getSaldo();
                ClienteConMayorSaldo = cliente;
            }
        }

        if(ClienteConMayorSaldo!=null){
            System.out.println("El cliente con mayor saldo:"+ ClienteConMayorSaldo);
        }else{
            System.out.println("Problema con la lista o esta vacia");
        }
    }
}
