import java.util.Scanner;

import BinaryInsertion.*;
import Merge.*;
import Quick.*;
import Radix.*;

public class mainOrdenamiento {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el número de la columna a ordenar");
        int columna = Integer.parseInt(entrada.nextLine());
        System.out.println("Escriba 1 para orden ascendente. \nEscriba 2 para orden descendente.");
        String orden = entrada.nextLine();

        String nombreArchivo = args[0];
        

        BinaryInsertion.Archivos archivoBinaryInsertion = new BinaryInsertion.Archivos(orden);
        Merge.Archivos archivoMerge = new Merge.Archivos(orden);
        Quick.Archivos archivoQuick = new Quick.Archivos(orden);
        Radix.Archivo archivoRadix = new Radix.Archivo(orden);

        archivoBinaryInsertion.recibirDatos(nombreArchivo);
        archivoBinaryInsertion.generarSalida(columna, "BinaryInsertionSort_ordenado.csv");
        
        archivoMerge.recibirDatos(nombreArchivo);
        archivoMerge.generarSalida(columna, "MergeSort_ordenado.csv");

        archivoQuick.recibirDatos(nombreArchivo);
        archivoQuick.generarSalida(columna, "QuickSort_ordenado.csv");

        archivoRadix.recibirDatos(nombreArchivo);
        archivoRadix.generarSalida(columna, "RadixSort_ordenado.csv");
        
        
        
        

    }
}
