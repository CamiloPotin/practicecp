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
Inertion sort - Part 2

Problema:
Se debe ordenar un arreglo

Solucion
Se recorre el arreglo y por cada numero se compara y mueve el resto hacia la derecha para posicionar correctamente el mismo. Luego se imprime

*/

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
    
    for (int i = 1; i < n; i++) {
        int num = arr.get(i);
        int j = i - 1;

        while (j >= 0 && arr.get(j) > num) {
            arr.set(j + 1, arr.get(j));
            j--;
        }

        arr.set(j + 1, num);

        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
    
    }
  }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
