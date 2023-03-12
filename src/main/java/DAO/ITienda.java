package DAO;

import DTO.Cliente;
import DTO.Producto;
import java.util.List;

public interface ITienda {
    public List<Cliente> retornarClientes();
    public List<Producto> retornarProductos();
    public Cliente retornarCliente(int id);
    public Producto retornarProducto(int id);
    public void crearCliente(Cliente c);
    public void crearProducto(Producto p);
    public void modificarCliente(Cliente c, int id);
    public void modificarProducto(Producto p, int id);
    public void eliminarProducto(Producto p);
    public void eliminarCliente(Cliente c);
}
