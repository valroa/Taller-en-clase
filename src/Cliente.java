public class Cliente {
    protected String identificacion;
    protected String nombre;
    protected double ValorCompra;

    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, double valorCompra) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        ValorCompra = valorCompra;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorCompra() {
        return ValorCompra;
    }

    public void setValorCompra(double valorCompra) {
        ValorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ValorCompra=" + ValorCompra +
                '}';
    }


    //METODOS
    public void mostrarDatos(double costoFinal) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + identificacion);
        System.out.println("Costo base: " + ValorCompra);
        System.out.println("costo final: " + costoFinal);
    }


    public double calcularTotalPagar() {
        return ValorCompra;
    }

    public double Descuento(double porcentaje) {
        double desc = ValorCompra * porcentaje;
        return ValorCompra - desc;
    }

    public double aumentar(double porcentaje) {
        double rec = ValorCompra * porcentaje;
        return ValorCompra + rec;
    }

    public boolean CompraAlta() {
        return ValorCompra > 500000;
    }
}
