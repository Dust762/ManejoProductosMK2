package mx.com.gm.manejoproductosmk2;

import BDLOCAL.Tienda;
import DAO.ITienda;
import DTO.Cliente;
import DTO.Producto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManejoProductosMK2 {
    
    static ITienda tienda = new Tienda();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int sel = -1;
        do {
            System.out.println("Bienvenido a la tienda");
            System.out.println("1.Gestion de clientes");
            System.out.println("2.Gestion de Productos");
            System.out.println("3.Salir");
            try {
                sel = Integer.parseInt(bf.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ingrese un valor, que sea valido");
            }
            switch (sel) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuProductos();
                    break;
                case 3:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
            
        } while (sel != 3);
        bf.close();
    }
    
    private static void menuClientes() throws IOException {
        int sel = -1;
        do {
            System.out.println("Bienvenido al menu clientes");
            System.out.println("1.Listar clientes");
            System.out.println("2.Crear cliente");
            System.out.println("3.Modificar cliente");
            System.out.println("4.Eliminar cliente");
            System.out.println("5.Mostrar factura");
            System.out.println("6.Agregar producto a un cliente");
            System.out.println("7.Modificar lista de productos de un cliente");
            System.out.println("8.Eliminar el producto de una lista");
            System.out.println("9.Salir");
            try {
                sel = Integer.parseInt(bf.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
            switch (sel) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    crearCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    mostrarFactura();
                    break;
                case 6:
                    agregarProductosCliente();
                    break;
                case 7:
                    modificarListaProductos();
                    break;
                case 8:
                    eliminarProdLista();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (sel != 9);
    }
    
    private static void menuProductos() throws IOException {
        int sel = -1;
        do {
            System.out.println("Bienvenido al menu productos");
            System.out.println("1.Listar Productos");
            System.out.println("2.Crear producto");
            System.out.println("3.Modificar producto");
            System.out.println("4.Eliminar producto");
            System.out.println("5.Salir");
            try {
                sel = Integer.parseInt(bf.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
            switch (sel) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    crearProducto();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (sel != 5);
    }
    
    private static void listarClientes() {
        System.out.println("Listando clientes");
        if (tienda.retornarClientes().size() > 0) {
            for (int i = 0; i < tienda.retornarClientes().size(); i++) {
                System.out.println(tienda.retornarClientes().get(i).toString());
            }
        } else {
            System.out.println("No hay clientes");
            System.out.println("");
        }
    }
    
    private static void crearCliente() throws IOException {
        String nombre, apellido;
        do {
            System.out.println("Ingrese el nombre");
            nombre = bf.readLine().trim();
        } while (nombre.isEmpty());
        do {
            System.out.println("Ingrese el apellido");
            apellido = bf.readLine().trim();
        } while (apellido.isEmpty());
        Cliente c = new Cliente(nombre, apellido);
        tienda.crearCliente(c);
    }
    
    private static void modificarCliente() throws IOException {
        String nombre, apellido;
        int id = 0, op = 0;
        listarClientes();
        try {
            System.out.println("Ingrese el id del cliente a modificar");
            id = Integer.parseInt(bf.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un id valido");
        }
        Cliente tmp = tienda.retornarCliente(id);
        if (tmp != null) {
            do {
                System.out.println("Que desea modificar?");
                System.out.println("1.Nombre");
                System.out.println("2.Apellido");
                System.out.println("3.Salir");
                try {
                    op = Integer.parseInt(bf.readLine().trim());
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Ingrese un numero valido");
                }
                switch (op) {
                    case 1:
                        do {
                            System.out.println("Ingrese el nombre");
                            nombre = bf.readLine().trim();
                        } while (nombre.isEmpty());
                        tmp.setNombre(nombre);
                        break;
                    case 2:
                        do {
                            System.out.println("Ingrese el apellido");
                            apellido = bf.readLine().trim();
                        } while (apellido.isEmpty());
                        tmp.setApellido(apellido);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
            } while (op != 3);
            tienda.modificarCliente(tmp, id);
            System.out.println("Se modifico el cliente");
        } else {
            System.out.println("No existe ese cliente");
        }
    }
    
    private static void eliminarCliente() {
        int id = 0;
        listarClientes();
        try {
            System.out.println("Ingrese el id del cliente a eliminar");
            id = Integer.parseInt(bf.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un id valido");
        }
        Cliente tmp = tienda.retornarCliente(id);
        if (tmp != null) {
            tienda.eliminarCliente(tmp);
            System.out.println("Se elimino el cliente");
        } else {
            System.out.println("No existe ese cliente");
        }
    }
    
    private static void mostrarFactura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static void agregarProductosCliente() {
        int id = 0, idProd = 0, cantPro = 0;
        listarClientes();
        try {
            System.out.println("Ingrese el id del cliente para agregar productos");
            id = Integer.parseInt(bf.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un id valido");
        }
        Cliente tmp = tienda.retornarCliente(id);
        if (tmp != null) {
            listarProductos();
            try {
                System.out.println("Ingrese el id del producto para agregar productos");
                idProd = Integer.parseInt(bf.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ingrese un id valido");
            }
            do {
                try {
                    System.out.println("Cantidad de productos que desea");
                    cantPro = Integer.parseInt(bf.readLine().trim());
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Ingrese un numero valido");
                }
            } while (cantPro > 0);
            
            Producto temp = tienda.retornarProducto(idProd);
            if (temp != null) {
                //Se debe crear un objeto temporal con el id y la cantidad, para realizar los calculos y descontar las unidades disponibles
                // con temp se debe crear un objeto con solo 3 atributos, id, nombre y cantidad
                Producto tempo = new Producto(temp.getIdProd(), temp.getNombre(), cantPro);
                
                tmp.agregarProducto(temp);
                tienda.descontarProducto(cantPro, temp.getIdProd());
                System.out.println("Se agrego el producto");
            } else {
                System.out.println("El producto no existe");
            }
        } else {
            System.out.println("No existe ese cliente");
        }
    }
    
    private static void modificarListaProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static void eliminarProdLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static void listarProductos() {
         System.out.println("Listando de productos");
        if (tienda.retornarProductos().size() > 0) {
            for (int i = 0; i < tienda.retornarProductos().size(); i++) {
                System.out.println(tienda.retornarProductos().get(i).toString());
            }
        } else {
            System.out.println("No hay productos");
            System.out.println("");
        }
    }
    
    private static void crearProducto() throws IOException {
        String nombre, marca;
        int cantidad = 0, precio = 0;
        do {
            System.out.println("Ingrese el nombre del producto");
            nombre = bf.readLine().trim();
        } while (nombre.isEmpty());
        do {
            System.out.println("Ingrese la marca del producto");
            marca = bf.readLine().trim();
        } while (marca.isEmpty());
        do {
            try {
                System.out.println("Ingrese la cantidad del producto");
                cantidad = Integer.parseInt(bf.readLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido");
            }

        } while (cantidad <= 0);

        do {
            try {
                System.out.println("Ingrese el precio del producto");
                precio = Integer.parseInt(bf.readLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido");
            }

        } while (precio <= 0);
        Producto p = new Producto(nombre, marca, cantidad, precio);
        tienda.crearProducto(p);
        System.out.println("Se creo el producto");
        System.out.println("");
    }
    
    private static void modificarProducto() throws IOException {
        String nombre, marca;
        int cantidad = 0, id = 0, op = 0, precio = 0;
        listarProductos();
        try {
            System.out.println("Ingrese el id del producto");
            id = Integer.parseInt(bf.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un id valido");
        }
        Producto tmp = tienda.retornarProducto(id);
        if (tmp != null) {
            do {
                System.out.println("Que desea modificar?");
                System.out.println("1.Nombre");
                System.out.println("2.Marca");
                System.out.println("3.Cantidad");
                System.out.println("4.Precio");
                System.out.println("5.Salir");
                try {
                    op = Integer.parseInt(bf.readLine().trim());
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Ingrese un numero valido");
                }
                switch (op) {
                    case 1:
                        do {
                            System.out.println("Ingrese el nombre");
                            nombre = bf.readLine().trim();
                        } while (nombre.isEmpty());
                        tmp.setNombre(nombre);
                        break;
                    case 2:
                        do {
                            System.out.println("Ingrese el marca");
                            marca = bf.readLine().trim();
                        } while (marca.isEmpty());
                        tmp.setMarca(marca);
                        break;
                    case 3:

                        do {
                            System.out.println("Ingrese la cantidad de producto");
                            try {
                                cantidad = Integer.parseInt(bf.readLine().trim());
                            } catch (Exception e) {
                                System.out.println("Ingrese un numero valido");
                            }
                            tmp.setCantidad(cantidad);
                        } while (cantidad <= 0);

                        break;
                    case 4:
                        do {
                            System.out.println("Ingrese el precio del producto");
                            try {
                                cantidad = Integer.parseInt(bf.readLine().trim());
                            } catch (Exception e) {
                                System.out.println("Ingrese un numero valido");
                            }
                            tmp.setPrecio(precio);
                        } while (precio <= 0);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
            } while (op != 5);
            tienda.modificarProducto(tmp, id);
            System.out.println("Se modifico el producto");
        } else {
            System.out.println("El producto no existe");
        }
    }
    
    private static void eliminarProducto() {
        int id = 0;
        listarProductos();
        try {
            System.out.println("Ingrese el id del producto a eliminar");
            id = Integer.parseInt(bf.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ingrese un id valido");
        }
        Producto tmp = tienda.retornarProducto(id);
        if (tmp != null) {
            tienda.eliminarProducto(tmp);
            System.out.println("Se elimino el Producto");
        } else {
            System.out.println("No existe ese Producto");
        }
    }
}
