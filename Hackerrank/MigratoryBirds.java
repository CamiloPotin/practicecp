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
Migratory birds hackerrank
Problema:
Se tiene un arreglo de tipos de aves y se quiere saber cual es el tipo de ave que mas se ve. Cuando se tienen dos tipos de aves que se vieron la misma cantidad de veces se queda con la menor.
Se tienen [1,5] tipos de aves y  n avistamientos (arreglo)

Solucion
Se cuentan la frecuencia de cada ave y dsps se recorre el arreglo de frecuencias comparando los numeros.


*/

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        
         int[] frequency = new int[6]; // Para los tipos de aves de 1 a 5
          
          
           for (int num : arr) {
            frequency[num]++;
        }

       
        int maxCount = 0;
        int birdWithMaxCount = Integer.MAX_VALUE;

        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] > maxCount || (frequency[i] == maxCount && i < birdWithMaxCount)) {
                maxCount = frequency[i];
                birdWithMaxCount = i;
            }
        }

        return birdWithMaxCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
