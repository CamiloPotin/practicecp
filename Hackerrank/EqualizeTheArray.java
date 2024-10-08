package Hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/*
Equalize the array de hackerrank

Problema:
Se tiene un arreglo de int y se quiere calcular cuantos se deberian eliminar para dejar solo el numero que mas se repite

Solucion:
Se recorre el arreglo contando la frecuencia de cada numero en una variable auxiliar y luego se recorre la misma buscando cual es el maximo. 
Por ultimo se devuelve el tamaño del arreglo - esa cantidad maxima.

*/

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
        int maxCount = 0;
        int[] countArray = new int[Collections.max(arr) + 1]; 
        for (int i : arr) {
            countArray[i]++;
        }

       for (int count : countArray) {
            if (count > maxCount) {
                maxCount = count;
            }
        }


        return arr.size() - maxCount;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
