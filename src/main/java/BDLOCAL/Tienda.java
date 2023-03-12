package BDLOCAL;

import DAO.ITienda;
import DTO.Cliente;
import DTO.Producto;
import java.util.ArrayList;
import java.util.List;

public class Tienda implements ITienda{

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    @Override
    public List<Cliente> retornarClientes() {
        return clientes;
    }

    @Override
    public List<Producto> retornarProductos() {
        return productos;
    }

    @Override
    public Cliente retornarCliente(int id) {

        return buscarCliente(id);
    }

    @Override
    public Producto retornarProducto(int id) {
        return buscarProducto(id);
    }

    @Override
    public void crearCliente(Cliente c) {
        clientes.add(c);
    }

    @Override
    public void crearProducto(Producto p) {
        productos.add(p);
    }

    @Override
    public void modificarCliente(Cliente c, int id) {
        int tmpIndex = clientes.indexOf(buscarCliente(id));
        clientes.set(tmpIndex, c);
    }

    @Override
    public void modificarProducto(Producto p, int id) {
        int tmpIndex = productos.indexOf(buscarProducto(id));
        productos.set(tmpIndex, p);
    }

    @Override
    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    @Override
    public void eliminarCliente(Cliente c) {
        clientes.remove(c);
    }

    public Cliente buscarCliente(int id) {
        Cliente tmp = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                tmp = clientes.get(i);
                return tmp;
            }
        }
        return null;
    }

    public Producto buscarProducto(int id) {
        Producto tmp = null;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProd() == id) {
                tmp = productos.get(i);
                return tmp;
            }
        }
        return null;
    }
}
