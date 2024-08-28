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
Pickin numbers de hackerrank

Problema:
Se tiene un arreglo de numeros de 1<=a[i]<=101 y se quieren calcular el maximo subarray con diferencia menor igual a 1 entre dos numeros seguidos. 
No necesariamente son seguidos los numeros

Solucion:
Se cuentan las frecuencias de cada numero y dsps se calcula la suma de frecuencias entre dos numeros seguidos ya que son los que tenran como diferencia  <=1
y se calcula el maximo entre el actual y la suma calculada.
*/
class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
    int[] frequency = new int[101]; 
    
        for (int number : a) {
            frequency[number]++;
        }

        int maxLength = 0;

      
        for (int i = 1; i < 101; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
