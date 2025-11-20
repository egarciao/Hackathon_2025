import java.util.ArrayList;

public class Ejercicio_4CitlalyLizethCruzGomez {

    public static class Transaccion {
        private String tipo;   
        private double monto;
        private String fecha;

        public Transaccion(String tipo, double monto, String fecha) {
            this.tipo = tipo;
            this.monto = monto;
            this.fecha = fecha;
        }

        public String getTipo() {
            return tipo;
        }
    }

    private ArrayList<Transaccion> transacciones = new ArrayList<>();

    public void agregarTransaccion(Transaccion t) {
        transacciones.add(t);
    }

    public int totalDepositos() {
        int total = 0;
        for (Transaccion t : transacciones) {
            if (t.getTipo().equalsIgnoreCase("Deposito")) {
                total++;
            }
        }
        return total;
    }

    public int totalRetiros() {
        int total = 0;
        for (Transaccion t : transacciones) {
            if (t.getTipo().equalsIgnoreCase("Retiro")) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Ejercicio_4CitlalyLizethCruzGomez registro = new Ejercicio_4CitlalyLizethCruzGomez();

        registro.agregarTransaccion(new Transaccion("Deposito", 1000, "2025-11-19"));
        registro.agregarTransaccion(new Transaccion("Retiro", 500, "2025-11-19"));
        registro.agregarTransaccion(new Transaccion("Deposito", 200, "2025-11-19"));

        System.out.println("Total depósitos: " + registro.totalDepositos());
        System.out.println("Total retiros: " + registro.totalRetiros());
    }
}
