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
Sherlock and Array

Problema:
Se quiere encontrar un punto en el arreglo en el que la suma de un subArreglo de la izquierda sea igual a la suma de un subArreglo de la derecha

Solucion:
Se hace primero la suma total y luego se recorre el arreglo sumando los valores y comparando con la suma total menos ese valor.

*/
class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here

          int totalSum = 0;
        int leftSum = 0;
        
        
        for (int num : arr) {
            totalSum += num;
        }
        
        
        for (int i = 0; i < arr.size(); i++) {
           
            int rightSum = totalSum - leftSum - arr.get(i);
            
           
            if (leftSum == rightSum) {
                return "YES";
            }
            
            
            leftSum += arr.get(i);
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
