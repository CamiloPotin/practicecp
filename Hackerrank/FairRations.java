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
Fair rotation de hackerrrank

Problema:
Se quiere repartir rodajas de pan entre un arreglo n y se deben cumplir las siguientes reglas:
  1. Cada vez que se da una rodaja de pan i se debe dar una a i-1 o a i+1
  2. Al final de la distribucion de pan todas las personas deben tener un numero par de rodajas

Solucion:
Se recorre el arreglo dando rodajas a los impares y a i+1 y al final se compara si el ultimo tiene numero impar se devuelve NO y sino el numero contado

*/

class Result {

    /*
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> panes) {
      int n = panes.size();
        int panesNecesarios = 0;

         for (int i = 0; i < n - 1; i++) {
            
            if (panes.get(i) % 2 != 0) {
                
                panes.set(i, panes.get(i) + 1);
                panes.set(i + 1, panes.get(i + 1) + 1);
                panesNecesarios += 2;
            }
        }

        if (panes.get(n - 1) % 2 != 0) {
            return "NO";
        }

        return Integer.toString(panesNecesarios);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
