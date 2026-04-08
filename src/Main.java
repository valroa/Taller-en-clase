import java.util.*;
void main() {

    Scanner teclado = new Scanner(System.in);
    List<Cliente> lista = new ArrayList<>();

    int opcion;

    do {
        System.out.println("  MENU  ");
        System.out.println("1 Registrar cliente regular");
        System.out.println("2 Registrar cliente frecuente");
        System.out.println("3 Registrar cliente mayorista");
        System.out.println("4 Buscar cliente por documento");
        System.out.println("5 Mostrar todos los clientes ");
        System.out.println("6 Mostrar clientes por tipo");
        System.out.println("7 Calcular total de compra ");
        System.out.println("8 Mostrar compras altas");
        System.out.println("9 Mostrar cliente que mas pago");
        System.out.println("10 Salir");

        opcion = teclado.nextInt();

        switch (opcion) {

            case 1 -> {
                System.out.println("  Cliente regular  ");
                System.out.print("Nombre: ");
                String nombre = teclado.next();
                System.out.print("Documento: ");
                String identificacion = teclado.next();
                System.out.print("Valor de la compra: ");
                double ValorCompra = teclado.nextDouble();

                lista.add(new CRegular(identificacion, nombre, ValorCompra));
            }

            case 2 -> {
                System.out.println("  Cliente Frecuente  ");
                System.out.print("Nombre: ");
                String nombre = teclado.next();
                System.out.print("Documento: ");
                String identificacion = teclado.next();
                System.out.print("Valor de la compra: ");
                double ValorCompra = teclado.nextDouble();
                System.out.print("Numero de compras que hizo: ");
                double numCompras = teclado.nextDouble();

                lista.add(new CFrecuente(identificacion, nombre, ValorCompra, numCompras));
            }
            case 3 -> {
                System.out.println("  Cliente Mayorista  ");
                System.out.print("Nombre: ");
                String nombre = teclado.next();
                System.out.print("Documento: ");
                String identificacion = teclado.next();
                System.out.print("Valor de la compra: ");
                double ValorCompra = teclado.nextDouble();
                System.out.print("Cantidad de productos: ");
                double CantiProductos = teclado.nextDouble();

                lista.add(new CMayorista(identificacion, nombre, ValorCompra, CantiProductos));
            }

            case 4 -> {
                System.out.println("Ingrese el numero de identificacion del paciente");
                String id = teclado.next();

                Cliente encontrado = null;

                for (Cliente c : lista) {
                    if (c.getIdentificacion().equals(id)) {
                        encontrado = c;
                    }
                }

                if (encontrado != null) {
                    encontrado.mostrarDatos(encontrado.calcularTotalPagar());
                } else {
                    System.out.println("Paciente no encontrado");
                }
            }
            case 5 -> {
                for (Cliente c : lista) {
                    c.mostrarDatos(c.calcularTotalPagar());
                    System.out.println("");
                }
            }
            case 6 -> {
                int op;
                do {
                    System.out.println("1 Cliente regular");
                    System.out.println("2 Cliente frecuente");
                    System.out.println("3 Cliente mayorista");
                    System.out.println("4 Salir");

                    op = teclado.nextInt();

                    switch (op) {

                        case 1 -> {
                            for (Cliente c : lista) {
                                if (c instanceof CRegular) {
                                    c.mostrarDatos(c.calcularTotalPagar());
                                }
                            }
                        }

                        case 2 -> {
                            for (Cliente c : lista) {
                                if (c instanceof CFrecuente) {
                                    c.mostrarDatos(c.calcularTotalPagar());
                                }
                            }
                        }

                        case 3 -> {
                            for (Cliente c : lista) {
                                if (c instanceof CMayorista) {
                                    c.mostrarDatos(c.calcularTotalPagar());
                                }
                            }
                        }

                        default -> System.out.println("Opcion invalida");
                    }

                } while (op != 4);
            }

            case 7 -> {
                System.out.print("Documento: ");
                String id = teclado.next();

                for (Cliente c : lista) {
                    if (c.getIdentificacion().equals(id)) {
                        System.out.println("Costo final: " + c.calcularTotalPagar());
                    }
                }
            }
            case 8 -> {
                for (Cliente c : lista) {
                    if (c.CompraAlta()) {
                        c.mostrarDatos(c.calcularTotalPagar());
                    }
                }
            }
            case 9 -> {
                if (lista.isEmpty()) {
                    System.out.println("No hay pacientes");
                } else {

                    Cliente mayor = lista.get(0);

                    for (Cliente c : lista) {
                        if (c.calcularTotalPagar() > mayor.calcularTotalPagar()) {
                            mayor = c;
                        }
                    }

                    System.out.println("Paciente que mas pago:");
                    mayor.mostrarDatos(mayor.calcularTotalPagar());
                }
            }
            default-> System.out.println("Opcion invalida");
        }
    }
    while (opcion != 10);

}
