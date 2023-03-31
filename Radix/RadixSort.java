package Radix;


/**
 *
 *Clase que implementa el algoritmo de ordenamiento RadixSort para ordenar arreglos de Strings o enteros.
 *
 *Permite ordenar en orden ascendente o descendente y también alfabéticamente.
 */
public class RadixSort {
    
     
/**
 * Método que ordena un arreglo de enteros en orden ascendente utilizando el algoritmo de RadixSort
 * @param arr Arreglo de Strings a ordenar
 */
public static void radixSort(String[] arr) {
    
    
    
    int n = arr.length;

    // Convirtiendo los valores del arreglo de String a int
    int[] intArr = new int[n];
    for (int i = 0; i < n; i++) {
        intArr[i] = Integer.parseInt(arr[i]);
    }

    // Encontrando el valor máximo en el arreglo
    int maxVal = intArr[0];
    for (int i = 1; i < n; i++) {
        if (intArr[i] > maxVal) {
            maxVal = intArr[i];
        }
    }

    // Realizando el ordenamiento radix
    for (int exp = 1; maxVal / exp > 0; exp *= 10) {
        int[] count = new int[10];

        // Contando la cantidad de elementos con el dígito actual
        for (int i = 0; i < n; i++) {
            count[(intArr[i] / exp) % 10]++;
        }

        // Sumando las cantidades de los dígitos anteriores
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construyendo el arreglo ordenado
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(intArr[i] / exp) % 10] - 1] = intArr[i];
            count[(intArr[i] / exp) % 10]--;
        }

        // Copiando el arreglo ordenado de vuelta al original
        for (int i = 0; i < n; i++) {
            intArr[i] = output[i];
        }
    }

    // Copiando los valores ordenados de vuelta al arreglo de String
    for (int i = 0; i < n; i++) {
        arr[i] = Integer.toString(intArr[i]);
    }
    

}


/**
 *
 *Método que ordena un arreglo de Strings en orden alfabético utilizando el algoritmo de RadixSort.
 *
 *@param arr Arreglo de Strings a ordenar.
 */
public static void radixSortAlphabetical(String[] arr) {
    long startTime = System.currentTimeMillis();    
    int n = arr.length;

    // Encontrando la longitud máxima de una cadena
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i].length() > maxLen) {
            maxLen = arr[i].length();
        }
    }

    // Haciendo el ordenamiento basado en cada carácter
    for (int i = maxLen - 1; i >= 0; i--) {
        int[] count = new int[256];

        // Contando la cantidad de elementos con el carácter actual
        for (int j = 0; j < n; j++) {
            int charVal = 0;
            if (i < arr[j].length()) {
                charVal = (int) arr[j].charAt(i);
            }
            count[charVal]++;
        }

        // Sumando las cantidades de los caracteres anteriores
        for (int j = 1; j < 256; j++) {
            count[j] += count[j - 1];
        }

        // Construyendo el arreglo ordenado
        String[] output = new String[n];
        for (int j = n - 1; j >= 0; j--) {
            int charVal = 0;
            if (i < arr[j].length()) {
                charVal = (int) arr[j].charAt(i);
            }
            output[count[charVal] - 1] = arr[j];
            count[charVal]--;
        }

        // Copiando el arreglo ordenado de vuelta al original
        for (int j = 0; j < n; j++) {
            arr[j] = output[j];
            }
        }
    

    }

/**
 *
 *Método que invierte el orden del arreglo de enteros ordenados.
 *
 *@param arr Arreglo de Strings a invertir orden.
 */
    public static void radixSortReverse(String[] arr) {
        radixSort(arr);
        reverse(arr);
    }
    
/**
 *
 *Método que invierte el orden del arreglo de palabras ordenadas alfabéticamente.
 *
 *@param arr Arreglo de Strings a invertir orden.
 */
    public static void radixSortAlphabeticalReverse(String[] arr) {
        radixSortAlphabetical(arr);
        reverse(arr);
    }
    
/**
 *
 *Método que invierte el orden de un arreglo.
 *
 *@param arr Arreglo de Strings a invertir.
 */
    private static void reverse(String[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

