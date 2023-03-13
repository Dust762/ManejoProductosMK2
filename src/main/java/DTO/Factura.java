package DTO;

public class Factura {
    static private int contadorFactura;
    private int idFactura;
    private String nombreCliente;
    private int total;
    
    private Factura(String nombreCliente, int total){
        this.idFactura = ++contadorFactura;
        this.nombreCliente = nombreCliente;
        this.total = total;
    }
    public Factura(){}
    public Factura generarFactura(Cliente c){
        int total = 0;
        int sumTemp = 0;
        String nombreCliente = c.getNombre() + " " + c.getApellido();
        for (int i = 0; i < c.getProductos().size(); i++) {
            total = total + c.getProductos().get(i).getCantidad() * c.getProductos().get(i).getPrecio();
        }
        Factura fac = new Factura(nombreCliente, total);
        return fac;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getTotal() {
        return total;
    }

    public int getIdFactura() {
        return idFactura;
    }
    
    
}
