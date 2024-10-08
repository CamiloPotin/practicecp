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
Counting sort 1 de hackerrank

Problema:
Se quiere crear el algoritmo de ordenamiento que cuenta las frecuencias de los numeros y despues crea un nuevo arreglo con las mismas.
Solo se quiere crear la parte de las frecuencias

Solucion:
Se cuentan las frecuencias y devuelven. Se complica ya que hay que agregar los 100 

*/
class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        
   List<Integer> result = new ArrayList<>(100);
    for(int i = 0 ; i < 100;i++){
        result.add(0);
    }
    
    for(int i = 0 ; i < arr.size() ; i++){
        result.set(arr.get(i), result.get(arr.get(i))+1);
        
    } 
    return result;
    // Write your code here

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

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
