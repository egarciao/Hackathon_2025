class Cliente{
    private int id;
    private String nombre;
    private double saldo;

    public Cliente(int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSaldo() { return saldo; }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', saldo=" + saldo + "}";
    }
}