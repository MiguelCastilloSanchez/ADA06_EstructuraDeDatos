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

        String nombreArchivo = "archivoAOrdenar.csv";

        BinaryInsertion.Archivos archivoBinaryInsertion = new BinaryInsertion.Archivos(orden);
        Merge.Archivos archivoMerge = new Merge.Archivos(orden);
        Quick.Archivos archivoQuick = new Quick.Archivos(orden);
        Radix.Archivos archivoRadix = new Radix.Archivo(orden);

        archivoBinaryInsertion.recibirDatos(nombreArchivo);
        archivoMerge.recibirDatos(nombreArchivo);
        archivoQuick.recibirDatos(nombreArchivo);
        archivoRadix.recibirDatos(nombreArchivo);

        archivoBinaryInsertion.generarSalida(columna, "BinaryInsertionSort_ordenado.csv");
        archivoMerge.generarSalida(columna, "MergeSort_ordenado.csv");
        archivoQuick.generarSalida(columna, "QuickSort_ordenado.csv");
        archivoRadix.generarSalida(columna, "MergeSort_ordenado.csv");
    }
}
