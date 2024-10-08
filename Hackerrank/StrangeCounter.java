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
Strange Counter de hackerrank

Problema:
Se tiene una cuenta de 1 hasta t. Y un contador que arranca en 3. Por cada unidad de tiempo el contador disminuye y cuando llega a 0 vuelve a 2*contadorInicial.
Y esto se repite hasta llegar a un tiempo t

Solucion:
Se va sumando de a ciclos enteros hasta llegar a t 


*/

class Result {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

    public static long strangeCounter(long t) {
    // Write your code here
     long cycleLength = 3;  // El largo inicial del ciclo
    long cycleStart = 1;   // El tiempo en que empieza el ciclo

    while (t > cycleLength + cycleStart - 1) {
        cycleStart += cycleLength;
        cycleLength *= 2;
    }

    return cycleLength - (t - cycleStart);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
