package DTO;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    static private int contadorCliente;
    private List<Producto> productos = new ArrayList<>();
    
    public Cliente(String nombre, String apellido){
        this.id = ++Cliente.contadorCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public void agregarProducto(Producto p){
        this.productos.add(p);
    }
    public void eliminarProducto(Producto p){
        this.productos.remove(p);
    }
    @Override
    public String toString() {
        
        String datosCliente = "ID: " + id + "\n" +
        "Nombre del cliente: " + nombre + " " + apellido + "\n" +
        "Productos: " + productos;
        return datosCliente;
    }
}
