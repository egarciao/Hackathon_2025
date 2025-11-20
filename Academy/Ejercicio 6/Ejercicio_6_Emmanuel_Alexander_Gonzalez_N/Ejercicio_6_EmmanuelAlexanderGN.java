package Ejercicio_6_Emmanuel_Alexander_Gonzalez_N;
import java.util.ArrayList;
import java.util.List;
class Cuenta{
    private int id;
    private double saldo;

    public Cuenta(int id, double saldoInicical){
        this.id = id;
        this.saldo = saldoInicical;
    }
    public double getSaldo(){ return saldo; }
    public synchronized void depositar(double monto){
        saldo += monto;
    }
    public synchronized boolean retirar(double monto){
        if(saldo >= monto){
            saldo -= monto;
            return true;
        }
        return false;
    }
    public synchronized void transferir(Cuenta destino, double monto){
        if(this.retirar(monto)){
            destino.depositar(monto);
        }
    }
}
class Tranferencia implements Runnable{
    private Cuenta origen;
    private Cuenta destino;
    private double monto;
    public Tranferencia(Cuenta origen, Cuenta destino, double monto){
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }
    @Override
    public void run(){
        origen.transferir(destino, monto);
    }
}
public class Ejercicio_6_EmmanuelAlexanderGN {
    public static void main(String[] args) throws InterruptedException {
        Cuenta c1 =  new Cuenta(1,10000);
        Cuenta c2 =  new Cuenta(2,20000);
        Cuenta c3 =  new Cuenta(3,30000);
        double saldoInicialTotal =  c1.getSaldo() + c2.getSaldo() + c3.getSaldo();
        System.out.println("Saldo inicial: " + saldoInicialTotal);


        List<Thread> hilos = new ArrayList<>();
        //Simulacion de 1000 transferencias
        for(int i = 0; i<1000; i++){
            Cuenta origen = (i % 2 == 0)?c1:c2;
            Cuenta destino = (i % 2 == 0)?c3:c1;

            Thread t = new Thread(new Tranferencia(origen,destino,10));
            hilos.add(t);
            t.start();
        }

        for (Thread t : hilos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double saldoFinal = c1.getSaldo() + c2.getSaldo() + c3.getSaldo();
        System.out.println("Saldo finales de c1: " + c1.getSaldo() + " c2: " +  c2.getSaldo() + " c3: " + c3.getSaldo());
        System.out.println("Saldo Total Final: " + saldoFinal);
    }
}
