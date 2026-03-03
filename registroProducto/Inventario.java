import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public boolean registrarProducto(String codigo, String nombre, double precio, int stock) {

        if (precio < 0 || stock < 0) {
            return false;
        }

        if (buscarProducto(codigo) != null) {
            return false;
        }

        Producto nuevo = new Producto(codigo, nombre, precio, stock);
        productos.add(nuevo);
        return true;
    }
public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean agregarUnidades(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null && cantidad > 0) {
            p.aumentarStock(cantidad);
            return true;
        }
        return false;
    }

    public boolean retirarUnidades(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            return p.disminuirStock(cantidad);
        }
        return false;
    }

    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }

    public ArrayList<Producto> productosBajoStock() {
        ArrayList<Producto> bajos = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getStock() < 5) {
                bajos.add(p);
            }
        }
        return bajos;
    }

    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularValorTotal();
        }
        return total;
    }
}
