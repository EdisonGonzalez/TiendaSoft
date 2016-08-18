package softtienda;

import java.util.Scanner;

public class Producto {
    //Atributos
    private String nombre;
    private int cantidad, cantidad_venta;
    private double valor, valor_total_venta;
    private final Scanner Lector = new Scanner(System.in);
    
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    } 
    
    public void ShowProduct(){
        System.out.println("Nombre: "+nombre+"\nCantidad: "+cantidad+"\nValor Individual: "+valor);
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public double getValor_total_venta() {
        return valor_total_venta;
    }
     
    public void Show_Ventas(){
        valor_total_venta=this.getValor()*this.getCantidad_venta();
        System.out.println("Nombre: "+nombre+"\nCantidad del producto: "+cantidad+"\nValor Individual: "
                            +valor+"\nCantidad de venta: "+cantidad_venta+"\nValor total de la venta: $"
                            +valor_total_venta);
    }
            
    public void CreateProduct(){
        System.out.println("Por favor ingrese el nombre del producto");
        nombre=Lector.next();
        System.out.println("Por favor ingrese la cantidad del producto");
        cantidad=Lector.nextInt();
        System.out.println("Por favor ingrese el valor del producto");
        valor=Lector.nextDouble();
    }
}