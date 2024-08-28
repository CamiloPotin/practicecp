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
Repeated String de hackerrank

Problema:
Se tiene un String de longitud dada y un n dado y se quiere calcular la cantidad de 'a' que se encuentran en el String

Solucion:
Calcular primero la cantidad de As en el string


*/
class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
        long length = s.length();  // Longitud de la cadena
        long countAInString = 0;   // Contador para 'a' en la cadena
        long countAInRepeated = 0; // Contador para 'a' en la parte repetida
        
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                countAInString++;
            }
         }
        
        long fullRepeats = n / length;
        
        long remainder = n % length;
        countAInRepeated = fullRepeats * countAInString;
        
       for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                countAInRepeated++;
            }
        }
        
        return countAInRepeated;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
