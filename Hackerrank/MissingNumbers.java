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
Missing Numbers de hackerrank

Problema:
Se tienen dos arreglos de numeros arr y brr y se quiere encontrar los valores  que se encuentran en arr pero no en brr

Solucion:
Se agrega en un Map por cada arreglo la frecuencia y dsps se recorre los maps contando si la frecuencia de arr es mayor a la de brr se agrega el numero.
(Esto es asi ya que hay mas de un mismo numero por lo que no se puede resolver solo buscando)

*/
class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        Map<Integer, Integer> arrCount = new HashMap<>();
        Map<Integer, Integer> brrCount = new HashMap<>();
        
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }

         for (int num : brr) {
            brrCount.put(num, brrCount.getOrDefault(num, 0) + 1);
        }

       List<Integer> missingNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : brrCount.entrySet()) {
            int num = entry.getKey();
            int countInBrr = entry.getValue();
            int countInArr = arrCount.getOrDefault(num, 0);
            
            if (countInBrr > countInArr) {
                missingNumbers.add(num);
            }
        }

       Collections.sort(missingNumbers);
        return missingNumbers;
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
