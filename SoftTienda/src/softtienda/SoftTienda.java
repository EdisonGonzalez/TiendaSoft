package softtienda;

import java.util.Scanner;

public class SoftTienda {
    //Variables estaticas para ingresar a la función principal
    static Producto arreglo[] = new Producto[256];
    static Scanner Lector = new Scanner(System.in);
    static int c=0,posicion=0,pos_venta,cant_venta,cant_new,sel, pos_vent;
    static String nombre;
    static double Ventas_Totales=0;

    //Funciones para Agregar, buscar, eliminar y mostrar producto.
    //Adicional se tiene un sistema contable capaz de realizar ventas y mostrar ganancias totales
    
    static void agregar(int pos){
        if (pos<256){
            arreglo[pos] = new Producto();
            arreglo[pos].CreateProduct();
        }
        else {
            System.out.println("Su lista de productos se encuentra completa (256 productos)");
        }
    }
    
    static void buscar(String nombre){
        int i=0, ban=0;
        while (i<posicion){
            if (nombre.equals(arreglo[i].getNombre())){
                System.out.println("En su lista de productos, este producto ocupa el lugar numero: "+(i+1));
                arreglo[i].ShowProduct();
                ban=1;
                i=posicion;
            }
            else{
                i++;
            }
        }
        if(ban==0)
            System.out.println("Este producto no existe en el inventario, regresando al menu."); 
    }
    
    static void eliminar(String nombre){
        int i=0, ban=0;
        while (i<posicion){
            if (nombre.equals(arreglo[i].getNombre())){
                System.out.println("Se elimino de su lista de productos, el producto que ocupa el lugar numero: "+(i+1));
                arreglo[i]=arreglo[(posicion-1)];
                ban=1;
                i=posicion;
                posicion--;
            }  
            else{
                i++;
            }
        }
        if(ban==0)
            System.out.println("Este producto no existe en el inventario, regresando al menu.");
    }
    
    static void ShowInventory(){
        System.out.println("Lista de productos.");
        for(c=0;c<posicion;c++){
            System.out.println("\n"+(c+1)+". ");
            arreglo[c].ShowProduct();
        }
        c=0;
    }
    
    static void ventas(){
        int i=0, ban=0;
        System.out.println("Ingrese el nombre del producto");
        nombre=Lector.next();
        while (i<posicion){
            if (nombre.equals(arreglo[i].getNombre())){
                System.out.println("En su lista de productos, este producto ocupa el lugar numero: "+(i+1));
                arreglo[i].ShowProduct();
                System.out.println("Ingrese la cantidad que desea comprar del producto");
                cant_venta=Lector.nextInt();
                arreglo[i].setCantidad_venta(cant_venta);
                cant_new=arreglo[i].getCantidad()-arreglo[i].getCantidad_venta();
                arreglo[i].setCantidad(cant_new);
                System.out.println("Ahora la cantidad de este producto es: "+arreglo[i].getCantidad());
                i=posicion;
                ban=1;
            }
            else{
                i++;
            }
        }
        if(ban==0)
            System.out.println("Este producto no existe en el inventario, regresando al menu."); 
    }
    
    static void Show_Gain_Total(){
        for(c=0;c<posicion;c++){
            arreglo[c].Show_Ventas();
            Ventas_Totales=Ventas_Totales+arreglo[c].getValor_total_venta();
        }
        c=0;
        System.out.println("\nY LAS VENTAS TOTALES (TODOS LOS PRODUCTOS) SON: $"+Ventas_Totales);
        Ventas_Totales=0;
    }
     
    
    public static void main(String[] args) {
        
        do {
            System.out.println("\nBienvenido a TiendaSoft");
            System.out.println("Por favor ingrese una de las siguientes opciones según su necesidad:");
            System.out.println("\n1.Agregar Producto.\n2.Buscar Producto.\n3.Eliminar Producto."
                    + "\n4.Mostrar Inventario.\n5.Realizar Venta.\n6.Mostrar Ganancias Totales.\n7.Salir.");
            sel=Lector.nextInt();
        
            switch(sel){
                case 1:
                    agregar(posicion);
                    posicion++;
                break;
                case 2:
                    System.out.println("\nIngrese el nombre del producto a buscar: ");
                    nombre=Lector.next();
                    buscar(nombre);
                break;
                case 3:
                    System.out.println("\nIngrese el nombre del producto a eliminar: ");
                    nombre=Lector.next();
                    eliminar(nombre);
                break;
                case 4:
                    ShowInventory();
                break;
                case 5:
                    ventas();
                break;
                case 6:
                    Show_Gain_Total();
                break;
                case 7:
                    sel=0;
                break;
                default:
                    System.out.println("El valor ingresado fue incorrecto, intentelo de nuevo");
                break;
            }
        } while (sel != 0);
    }
}