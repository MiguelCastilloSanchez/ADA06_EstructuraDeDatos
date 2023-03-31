package Merge;

import java.util.LinkedList;


/**
 * Clase encarga de realizar el ordenamiento por Merge Sort
 */
public class MergeSort {
   private LinkedList<String[]> lista;
   private int columna;
   private String orden;
   private LinkedList<String[]> workspace;
   private int comparaciones;
   private int intercambios;

   /**
   * Constructor
   * @param lista lista la cual se va a ordenar 
   * @param orden tipo de ordenamiento a realizar
   * @param columna columna de la lista a ordenar
   */
   public MergeSort(LinkedList<String[]> lista, String orden, int columna)   {
      this.lista = lista;
      this.orden = orden;
      this.columna = columna;
      this.comparaciones = 0;
      this.intercambios = 0;
   }
   



   /**
   * Metodo encargado de iniciar el ordenamiento Merge sort
   */
   public void mergeSort() {
      workspace = new LinkedList<String[]>();
      for(int i = 0; i<lista.size(); i++){
         workspace.add(lista.get(i));
      }
      recMergeSort(0, lista.size()-1);
   }

   /**
   * Metodo encargado de realizar el ordenamiento 
   * @param lowerBound dato de primero
   * @param upperBound dato de segundo
   */
   private void recMergeSort(int lowerBound, int upperBound){
      if(lowerBound == upperBound)            // if range is 1,
         return;                              // no use sorting
      else {                                    
         int mid = (lowerBound+upperBound) / 2; // find midpoint        
         recMergeSort(lowerBound, mid); // sort low half
         recMergeSort(mid+1, upperBound); // sort high half
         merge( lowerBound, mid+1, upperBound); // merge them
      }  // end else
   }  // end recMergeSort()


   /**
    * Metodo encargado de unir las dos partes ordenadas del MergeSort
    * 
    */
   private void merge(int lowPtr, int highPtr, int upperBound) {
      int j = 0;                             // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr-1;
      int n = upperBound-lowerBound+1;       // # of items

      while(lowPtr <= mid && highPtr <= upperBound)
      try{
         if( (Integer.parseInt(lista.get(lowPtr)[columna]) < Integer.parseInt(lista.get(highPtr)[columna]) && orden.equals("1")) || (Integer.parseInt(lista.get(lowPtr)[columna]) > Integer.parseInt(lista.get(highPtr)[columna]) && orden.equals("2"))){
            workspace.set(j++, lista.get(lowPtr++));
            comparaciones++;
         }
         else{
            workspace.set(j++, lista.get(highPtr++));
            comparaciones++;
            intercambios++;
            }
      }catch(NumberFormatException error){
         if( ((lista.get(lowPtr)[columna].compareTo(lista.get(highPtr)[columna]) <= 0)  && orden.equals("1")) || ((lista.get(lowPtr)[columna].compareTo(lista.get(highPtr)[columna]) >= 0)  && orden.equals("2"))){
            workspace.set(j++, lista.get(lowPtr++));
            comparaciones++;
         }
         else{
            workspace.set(j++, lista.get(highPtr++));
            comparaciones++;
            intercambios++;
            }
      }
        
      while(lowPtr <= mid){
      workspace.set(j++, lista.get(lowPtr++));
      intercambios++;
      }
      while(highPtr <= upperBound){
      workspace.set(j++, lista.get(highPtr++));
      intercambios++;   
      }
      for(j=0; j<n; j++)
      lista.set(lowerBound+j, workspace.get(j));
     
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
