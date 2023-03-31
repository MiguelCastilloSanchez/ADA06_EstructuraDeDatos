package BinaryInsertion;

import java.util.Scanner;

public class BinaryInsertionSortApp {
    public static void main (String[] args) {

        Archivos archivo = new Archivos();
        archivo.recibirDatos(args[0]);
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el número de la columna a ordenar");
        int columna = Integer.parseInt(entrada.nextLine());
        archivo.generarSalida(columna, args[1]);
    }
}
