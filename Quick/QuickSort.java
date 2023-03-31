package Quick;

import java.util.LinkedList;

public class QuickSort {
    private LinkedList<String[]> lista;          // ref to array theArray
    private String orden;
    private int comparaciones;
    private int intercambios;

    public QuickSort(LinkedList<String[]> lista, String orden)   {
      this.lista = lista;
      this.orden = orden;
      this.comparaciones = 0;
      this.intercambios = 0;
    }


    public void display() {
      for(int j=0; j<lista.size(); j++)    // for each element,
         System.out.print(lista.get(j) + " ");  // display it
      System.out.println("");
    }

    public void swap(int i, int j, int columna){
        String[] temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
    
    /* toma el ultimo elemento como pivote, 
    coloca el pivote en su posicion correcta del arreglo ordenado,
    coloca todos los valores mas pequeños (menores a los pivotes)
    a la izquierda del pivote y coloca todos los valores mas grandes 
    (mayores a los pivotes) a la derecha del pivote 
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
                swap(i, j, columna);
                intercambios++;
            }
            }catch(NumberFormatException error){
                if((lista.get(j)[columna].compareTo(pivotAlfabetico) < 0 && this.orden.equals("1")) || (lista.get(j)[columna].compareTo(pivotAlfabetico) > 0 && this.orden.equals("2"))){
                i++;
                swap(i, j, columna);
                intercambios++;
                }
            }   
            comparaciones++;
        }
        swap(i + 1, high, columna);
        intercambios++;
        return (i + 1);
    }
    
     /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
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

    public String getComparaciones(){
        return Integer.toString(comparaciones);
    }

    public String getIntercambios(){
        return Integer.toString(intercambios);
    }
}
