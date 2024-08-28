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
Subarray Division problem from hackerrank
Input:
n-> int
array[int]
d-> int m-> int

expected output
count-> num of times that the sum of a sequence in the array of length m is equal to d

Resolucion:
Para poder cumplir la suma se debe utilizar la "ventana deslizante" para cumplir con ir comprobando las secuencias 
5
[1,2 1 3 2]
3 2

Se va comprobando en una ventana de tamaño m que se va desplazando de a una vez hacia la derecha
 [1,2]
 [2,1]
  ...
*/







class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
    
      int count = 0;
    int n = s.size();
    
    // Manejo de casos donde la longitud del array es menor que m
    if (n < m) {
        return count;
    }
    
    int sum = 0;
    
    // Calcular la suma de los primeros m elementos
    for (int i = 0; i < m; i++) {
        sum += s.get(i);
    }
    
    // Si la suma inicial es igual a d, incrementa el contador
    if (sum == d) {
        count++;
    }
    
    // Ventana deslizante
    for (int i = m; i < n; i++) {
        sum += s.get(i) - s.get(i - m); // Ajustar la suma para la nueva ventana
        if (sum == d) {
            count++;
        }
    }
    
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
