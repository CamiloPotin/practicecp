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
Non-Divisible Subset de hackerrank

Problema:
Se quiere calcular el subset mas grande posible de numeros que sumados de a dos no son divisibles por k.

Solucion:
Se calculan los restos de cada numero y la cantidad que hay.

*/
class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
   int[] freq = new int[k];
        
        // Contar la frecuencia de cada resto
        for (int num : s) {
            int remainder = num % k;
            freq[remainder]++;
        }
        
        // Empezar con el maximo posible
        int count = Math.min(freq[0], 1); // Solo se puede tomar un elemento con resto 0
        
        // Elegir el maximo posible para cada par de restos
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(freq[i], freq[k - i]);
            }
        }
        
        // Manejar el caso especial cuando k es par
        if (k % 2 == 0) {
            count += 1; // Solo se puede tomar un elemento con resto k/2
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
