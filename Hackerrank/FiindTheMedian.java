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
Find the Median de hackerrank

Problema:
Ordenar el arreglo y encontrar la mediana. El arreglo siempre es impar

SOlucion:
Se ordena y devuelve el valor en size/2

*/
class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
    // Write your code here
    /*
    No sirve pq es n2 y pasa el tiempo limite del problema
    for(int i = 0 ; i < arr.size() ; i++) {
        int value = arr.get(i);
        int j = i - 1;
        while(j >= 0 && arr.get(j) > value) {
            arr.set(j+1,arr.get(j));
            j--;
        }
        arr.set(j+1, value);
        
        
    }*/
    Collections.sort(arr);
    return arr.get(arr.size()/2);

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

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
