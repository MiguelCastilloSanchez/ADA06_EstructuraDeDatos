package Radix;

import Radix.Archivo;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class RadixSortApp {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
        Archivo archivo = new Archivo();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el numero de la columna a ordenar");
        int columna = Integer.parseInt(entrada.nextLine());
        
        archivo.recibirDatos(args[0]);
        archivo.generarSalida(columna, args[1]);
        

          
    }
    
}
