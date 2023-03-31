package Radix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase para manejar los archivos de entrada y salida
 */
public class Archivo {
    public LinkedList<String[]> lista = new LinkedList<String[]>();
    private LinkedList<String[]> listaMetricas = new LinkedList<String[]>();
    private String orden;

    public Archivo (String orden){
        this.orden = orden;
    }

    /**
     * Recibe los datos del dataset y los de las metricas
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
     * Método encargado de realizar el ordenamiento e imprimir los resultados en el archivo csv con la lista ordenada
     * @param columna Número de columna a ordenar 
     * @param archivoSalida Nombre del archivo con la lista ordenada
     */
    public void generarSalida(int columna, String archivoSalida){
        
        String datos = "";
        for(int i=0;i<lista.size();i++){
            datos = datos + lista.get(i)[columna] + ",";
        }
        
        String[] datosColumna = datos.split(",");
        
               
        
        long startTime = System.currentTimeMillis();
        switch (Integer.parseInt(orden)){
            case 1:
            try{
                RadixSort.radixSort(datosColumna);   
            }catch(NumberFormatException error){
                RadixSort.radixSortAlphabetical(datosColumna);
            }       
                break;
            case 2:
            try{
                RadixSort.radixSortReverse(datosColumna);
            }catch(NumberFormatException error){
                RadixSort.radixSortAlphabeticalReverse(datosColumna);
            }
                break;
        } 
        long executionTime = System.currentTimeMillis() - startTime;
    
        
        listaMetricas.get(3)[1] = Long.toString(executionTime);
        listaMetricas.get(3)[2] = "0";
        listaMetricas.get(3)[3] = "0";
        this.guardarMetricas();
        
        
        Comparator<String[]> comparador = new Comparator<String[]>() {
            @Override
            public int compare(String[] fila1, String[] fila2) {
                int index1 = Arrays.asList(datosColumna).indexOf(fila1[columna]);
                int index2 = Arrays.asList(datosColumna).indexOf(fila2[columna]);
                return Integer.compare(index1, index2);
            }
        };
        
        lista.sort(comparador);        
        
        
        //Se crea el archivo con los datos ordenados
        File salida2 = new File(archivoSalida);
        if(salida2.exists() == false){
            try {
                salida2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            salida2.delete();
            try {
                salida2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter escribir2;
        try {
            escribir2 = new PrintWriter(salida2);
            for(int i = 0; i<lista.size(); i++){
                for(int j = 0; j<(lista.get(i).length); j++){
                    escribir2.print(lista.get(i)[j] + ",");
                }
                escribir2.print("\n");
            }
            escribir2.close();
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