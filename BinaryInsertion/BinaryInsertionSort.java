package BinaryInsertion;

import java.util.LinkedList;

public class BinaryInsertionSort {
 private int comparaciones;
 private int intercambios;

    public BinaryInsertionSort(){
        this.comparaciones = 0;
        this.intercambios = 0;
    }


    public void binaryInsertionSort(LinkedList<String[]> list, int columna, String orden) {
    

        for (int i = 1; i < list.size(); i++) {
            String[] currentNode = list.get(i);
            int currentNumerico = 0;
            String currentAlfabetico = null;
            try{
            currentNumerico = Integer.parseInt(list.get(i)[columna]);
            }catch (NumberFormatException error){
                currentAlfabetico = list.get(i)[columna];
            }
            int left = 0;
            int right = i - 1;
            int mid = 0;

            while (left <= right) {
                mid = (left + right) / 2;
                try{
                if ((Integer.parseInt(list.get(mid)[columna]) < currentNumerico) && (orden.equals("1"))) {
                    left = mid + 1;
                }
                else if(Integer.parseInt(list.get(mid)[columna]) > currentNumerico && orden.equals("2")){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }catch(NumberFormatException error){
                if((list.get(mid)[columna].compareTo(currentAlfabetico) < 0) && orden.equals("1")){
                    left = mid + 1;
                }
                else if((list.get(mid)[columna].compareTo(currentAlfabetico) > 0) && orden.equals("2")){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
              
            }
            }

            for (int j = i - 1; j >= left; j--) {
                list.set(j + 1, list.get(j));
                comparaciones++;
                intercambios++;
            }

            list.set(left, currentNode);
            comparaciones++;
        }
        

    }

    public String getComparaciones(){
        return Integer.toString(comparaciones);
    }

    public String getIntercambios(){
        return Integer.toString(intercambios);
    }
    
}