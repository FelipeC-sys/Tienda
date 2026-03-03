import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        do {
            System.out.println("\n      SISTEMA DE INVENTARIO");
            System.out.println("\n1. Registrar producto");
            System.out.println("2. Agregar unidades");
            System.out.println("3. Retirar unidades");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Mostrar productos con bajo stock");
            System.out.println("6. Buscar producto por código");
            System.out.println("7. Calcular valor total del inventario");
            System.out.println("8. Salir");
            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        System.out.print("Stock inicial: ");
                        int stock = sc.nextInt();

                        if (inventario.registrarProducto(codigo, nombre, precio, stock)) {
                            System.out.println("Producto registrado correctamente.");
                        } else {
                            System.out.println("Error al registrar producto.");
                        }
                        break;

                    case 2:
                        System.out.print("Código del producto: ");
                        codigo = sc.nextLine();

                        System.out.print("Cantidad a agregar: ");
                        int cantidadAgregar = sc.nextInt();

                        if (inventario.agregarUnidades(codigo, cantidadAgregar)) {
                            System.out.println("Stock actualizado.");
                        } else {
                            System.out.println("Error al agregar unidades.");
                        }
                        break;

                    case 3:
                        System.out.print("Código del producto: ");
                        codigo = sc.nextLine();

                        System.out.print("Cantidad a retirar: ");
                        int cantidadRetirar = sc.nextInt();

                        if (inventario.retirarUnidades(codigo, cantidadRetirar)) {
                            System.out.println("Venta realizada.");
                        } else {
                            System.out.println("No se pudo realizar la operación.");
                        }
                        break;

                    case 4:
                        for (Producto p : inventario.obtenerProductos()) {
                            System.out.println(p);
                        }
                        break;

                    case 5:
                        for (Producto p : inventario.productosBajoStock()) {
                            System.out.println(p);
                        }
                        break;

                    case 6:
                        System.out.print("Código: ");
                        codigo = sc.nextLine();
                        Producto encontrado = inventario.buscarProducto(codigo);
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;

                    case 7:
                        System.out.println("Valor total del inventario: $" +
                                inventario.calcularValorTotalInventario());
                        break;

                    case 8:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un dato válido.");
                sc.nextLine();
            }

        } while (opcion != 8);

        sc.close();
    }
}
