package Quick;

import java.util.LinkedList;

/**
 * Clase para realizar el Quick sort
 */
public class QuickSort {
    private LinkedList<String[]> lista;          // ref to array theArray
    private String orden;
    private int comparaciones;
    private int intercambios;

    /**
     * Constructor
     * @param lista Lista con los datos a ordenar
     * @param orden Orden para el ordenamiento
     */
    public QuickSort(LinkedList<String[]> lista, String orden)   {
      this.lista = lista;
      this.orden = orden;
      this.comparaciones = 0;
      this.intercambios = 0;
    }


    

    /**
     * Metodo que hace el intercambio de elementos
     * @param i Posicion del primer elemento
     * @param j Posicion del segundo elemento
     */
    public void swap(int i, int j){
        String[] temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
    
    /**
     * Metodo que hace la particion para encontrar las posiciones de los elementos
     * @param low Indice izquierdo
     * @param high Indice derecho
     * @param columna Numero de la columna en la que se basa el ordenamiento
     * @return Nueva posicion del elemento que se esta comparando
     */
    public int partition(int low, int high, int columna){
        String pivotAlfabetico = null;
        int pivotNumerico = 0;
        try{
        pivotNumerico = Integer.parseInt(lista.get(high)[columna]);
        }catch(NumberFormatException error){
            pivotAlfabetico = lista.get(high)[columna];
        }
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
    
        for(int j = low; j < high; j++){
            // If current element is smaller
            // than the pivot
            try{
            if ((Integer.parseInt(lista.get(j)[columna]) < pivotNumerico && this.orden.equals("1")) || (Integer.parseInt(lista.get(j)[columna]) > pivotNumerico && this.orden.equals("2"))){
                // Increment index of
                // smaller element
                i++;
                swap(i, j);
                intercambios++;
            }
            }catch(NumberFormatException error){
                if((lista.get(j)[columna].compareTo(pivotAlfabetico) < 0 && this.orden.equals("1")) || (lista.get(j)[columna].compareTo(pivotAlfabetico) > 0 && this.orden.equals("2"))){
                i++;
                swap(i, j);
                intercambios++;
                }
            }   
            comparaciones++;
        }
        swap(i + 1, high);
        intercambios++;
        return (i + 1);
    }
    

    /**
     * Metodo que inicia el Quick sort
     */
    void recQSort(int low, int high, int columna){
        if (low < high){
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(low, high, columna);
    
            // Separately sort elements before
            // partition and after partition
            recQSort(low, pi - 1, columna);
            recQSort(pi + 1, high, columna);
        }
   
    }

    /**
     * Metodo encargado de devolver las comparaciones realizadas por el ordenamiento
     * @return Cantidad de comparaciones
     */
    public String getComparaciones(){
        return Integer.toString(comparaciones);
    }

    /**
     * Metodo encargado de devolver los intercambios realizadas por el ordenamiento
     * @return Cantidad de intercambios
     */
    public String getIntercambios(){
        return Integer.toString(intercambios);
    }
}
