public class CFrecuente extends Cliente {
    private double numCompras;

    public CFrecuente(){

    }

    public CFrecuente(String identificacion, String nombre, double valorCompra, double numCompras) {
        super(identificacion, nombre, valorCompra);
        this.numCompras = numCompras;
    }

    public double getNumCompras() {
        return numCompras;
    }

    public void setNumCompras(double numCompras) {
        this.numCompras = numCompras;
    }

    @Override
    public String toString() {
        return "CFrecuente{" +
                "numCompras=" + numCompras +
                '}';
    }

    //Metodos
    public double calcularTotalPagar() {
        double porcentaje;
        double total;

        if (ValorCompra >= 300000) {
            porcentaje = 0.25;
        } else if (ValorCompra >= 80000) {
            porcentaje = 0.20;
        } else {
            porcentaje = 0.30;
        }

        total = ValorCompra * porcentaje;

        if (CompraAlta()) {
            total = total - (total * 0.05);
        }

        return total;
    }
}

