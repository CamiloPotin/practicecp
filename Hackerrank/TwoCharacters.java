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
Two Characters de hackerrank

Problema:
Se debe encontrar dentro de un String una secuencia de dos caracteres que van alternando y se debe encontrar la longitud maxima de estos subStrings validos (sin que se repita el mismo caracter dos veces). 


Solucion:
 - Primero se buscan todos los caracteres individuales presentes
 - Luego para todas las combinaciones posibles de caracteres se calcula si existe una longitud maxima de subarray
 - Si el subString es invalido devuelve 0 

*/
class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
      Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int maxLength = 0;

        for (char c1 : uniqueChars) {
            for (char c2 : uniqueChars) {
                if (c1 != c2) {
                    int length = checkAlternateLength(s, c1, c2);
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    private static int checkAlternateLength(String s, char c1, char c2) {
        int count = 0;
        char lastChar = 0;
        for (char c : s.toCharArray()) {
            if (c == c1 || c == c2) {
                if (c == lastChar) {
                    return 0;
                }
                count++;
                lastChar = c;
            }
        }
        return count;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
