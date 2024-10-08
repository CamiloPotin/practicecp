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
Divisible Sum Pairs from hackerrank

Se deben encontrar todos los pares que sumados son divisibles por k

revisar bien

*/

class Result {

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
     // Crear un array para contar restos
        int[] remainderCount = new int[k];
        
        // Contar los restos de cada elemento en el array
        for (int num : ar) {
            remainderCount[num % k]++;
        }
        
        // Inicializar el contador de pares
        int count = 0;
        
        // Pares (0,0) -> son aquellos que tienen resto 0
        /*
        Calcula las combinaciones posibles entre los numeros que son divisibles por k
        Por ejemplo si tengo 4 numeros divisibles por k
        Las combinaciones seran 4x3 que dan todas las combinaciones posibles entre esos numeros
        Y se divide por 2 para quedarte solo con la mitad (si no contarian todas las combinaciones posibles incluyendo las repetidas) 
        */
        count += (remainderCount[0] * (remainderCount[0] - 1)) / 2; 
        
        // Pares (i, k-i)
        /*
        Se cuentan los pares que completan la suma para que sean divisibles por k
        Si k = 3 y existe un i= 1 y un k=
        */
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += remainderCount[i] * remainderCount[k - i];
            }
        }
        
        // Si k es par, considerar los pares con restos iguales a k/2
        if (k % 2 == 0) {
            count += (remainderCount[k / 2] * (remainderCount[k / 2] - 1)) / 2;
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

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
