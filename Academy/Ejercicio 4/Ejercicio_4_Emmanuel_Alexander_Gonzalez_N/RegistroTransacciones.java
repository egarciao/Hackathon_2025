package Ejercicio_4_Emmanuel_Alexander_Gonzalez_N;

import java.util.ArrayList;
import java.util.List;

class Transaccion {
    private String tipo;
    private double monto;
    private String fecha;

    public Transaccion(String tipo, double monto, String fecha){
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }
    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }

    @Override
    public String toString(){
        return fecha + " | " + tipo + " | $" + monto;
    }
}

class CalculadoraBalance {
    public double sumarPorTipo(List<Transaccion> transacciones, String tipoBuscado) {
        double total = 0;
        for (Transaccion t : transacciones) {
            if (t.getTipo().equalsIgnoreCase(tipoBuscado)) {
                total += t.getMonto();
            }
        }
        return total;
    }
    public double calcularBalanceNeto(List<Transaccion> transacciones) {
        double depositos = sumarPorTipo(transacciones, "Deposito");
        double retiros = sumarPorTipo(transacciones, "Retiro");
        return depositos - retiros;
    }
}


public class RegistroTransacciones {
    public static void main(String[] args) {
        List<Transaccion> historial = new ArrayList<>();
        historial.add(new Transaccion("Deposito", 1000.00, "01/11/2025"));
        historial.add(new Transaccion("Retiro", 200.00, "02/11/2025"));
        historial.add(new Transaccion("Deposito", 500.00, "03/11/2025"));
        historial.add(new Transaccion("Retiro", 100.00, "05/11/2025"));
        historial.add(new Transaccion("Pago", 50.00, "06/11/2025")); // Tipo desconocido

        System.out.println("Historial de transacciones");
        for (Transaccion t : historial){
            System.out.println(t);
        }

        System.out.println("\n Balance General");

        CalculadoraBalance calc = new CalculadoraBalance();

        double totalDepositos = calc.sumarPorTipo(historial, "Deposito");
        double totalRetiros = calc.sumarPorTipo(historial, "Retiro");
        double balanceFinal = calc.calcularBalanceNeto(historial);

        System.out.println("Total Depósitos: " + totalDepositos);
        System.out.println("Total Retiros:   " + totalRetiros);
        System.out.println("Balance Neto:    " + balanceFinal);
    }
}