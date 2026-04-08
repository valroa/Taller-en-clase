public class CMayorista extends Cliente  {
    private double CantiProductos;

    public CMayorista(){

    }

    public CMayorista(String identificacion, String nombre, double valorCompra, double cantiProductos) {
        super(identificacion, nombre, valorCompra);
        this.CantiProductos = cantiProductos;
    }

    public double getCantiProductos() {
        return CantiProductos;
    }

    public void setCantiProductos(double cantiProductos) {
        CantiProductos = cantiProductos;
    }

    @Override
    public String toString() {
        return "CMayorista{" +
                "CantiProductos=" + CantiProductos +
                '}';
    }

    //Metodos

    public double calcularTotalPagar() {
        double total;

        if (CantiProductos >= 50) {
            total = Descuento(0.50);
        } else if (CantiProductos >= 20) {
            total = Descuento(0.65);
        } else {
            total = aumentar(0.80);
        }
        if (total > 500000) {
            total = 500000;
        }

        return total;
    }
}
