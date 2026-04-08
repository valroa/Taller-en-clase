public class CRegular extends Cliente {

    public CRegular() {
    }

    public CRegular(String identificacion, String nombre, double valorCompra) {
        super(identificacion, nombre, valorCompra);
    }
//Metodos

    public double calcularTotalPagar() {
    double total;

        if (ValorCompra > 300000) {
            total = Descuento(0.8);
        } else if (ValorCompra >= 150000) {
            total = Descuento(0.5);
        } else if (ValorCompra <= 60000) {
            total = aumentar(0.06);
        } else {
            total = ValorCompra;
        }

        return total;
    }
}
