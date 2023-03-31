package Merge;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/**
 * Clase para manejar los archivos de entrada y salida
 */
public class Archivos {
    private LinkedList<String[]> lista = new LinkedList<String[]>();
    private LinkedList<String[]> listaMetricas = new LinkedList<String[]>();
    private String orden;

    public Archivos(String orden){
        this.orden = orden;
    }
    /**
     * Recibe los datos del dataset
     * @param archivoEntrada Nombre del archivo csv con los datos de entrada
     */
    public void recibirDatos(String archivoEntrada){
        BufferedReader br = null;
        String linea = "";
        String separador = ",";
        try {
            br = new BufferedReader(new FileReader(archivoEntrada));
            linea = br.readLine();
            while(linea != null){
                String[] datos = linea.split(separador);
                lista.add(datos);
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
            br = new BufferedReader(new FileReader("MetricasOrdenamiento.csv"));
            linea = br.readLine();
            while(linea != null){
                String[] datos = linea.split(separador);
                listaMetricas.add(datos);
                linea = br.readLine();
            }
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
   /**
    * Metodo encargado de generar o modificar el archivo con la lista ordenada
    * @param columna columna a ordenar
    * @param archivoSalida nombre del archivo ordenado
    */
    public void generarSalida(int columna, String archivoSalida){
        //Primero se ordenan los datos
       
        MergeSort mSort = new MergeSort(lista, orden, columna);
        long inicio = System.currentTimeMillis();
        mSort.mergeSort();
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        listaMetricas.get(2)[1] = Long.toString(tiempo);
        listaMetricas.get(2)[2] = mSort.getComparaciones();
        listaMetricas.get(2)[3] = mSort.getIntercambios();
        this.guardarMetricas();
        
       

        //Se crea el archivo con los datos ordenados
        File salida = new File(archivoSalida);
        if(salida.exists() == false){
            try {
                salida.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            salida.delete();
            try {
                salida.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(salida);
            for(int i = 0; i<lista.size(); i++){
                for(int j = 0; j<(lista.get(i).length); j++){
                    escribir.print(lista.get(i)[j] + ",");
                }
                escribir.print("\n");
            }
            escribir.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
   /**
    * Metodo encargado de guardar las métricas del archivo con estas
    */
    public void guardarMetricas(){
        File salida = new File("MetricasOrdenamiento.csv");
        if(salida.exists() == false){
            try {
                salida.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            salida.delete();
            try {
                salida.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(salida);
            for(int i = 0; i<listaMetricas.size(); i++){
                for(int j = 0; j<(listaMetricas.get(i).length); j++){
                    escribir.print(listaMetricas.get(i)[j] + ",");
                }
                escribir.print("\n");
            }
            escribir.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}