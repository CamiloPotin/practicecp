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
Anagram de hackerrank

Problema:
Se tiene un String que se quiere dividir en dos y ver cuantas letras se deberian cambiar para que sean un anagrama (una palabra se puede formar con las letras de la otra).

Solucion:
Se divide el String y se cuentan las frecuencias de la primer palabra. Luego se restan las frecuencias de la otra palabra.
Por ultimo se contabiliza por cada letra se suma si queda >0.


*/

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;  // No puede ser un anagrama si la longitud es impar
        }

        int mid = s.length() / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid);

        int[] charCount = new int[26];

        for (int i = 0; i < left.length(); i++) {
            charCount[left.charAt(i) - 'a']++;
        }

       
        for (int i = 0; i < right.length(); i++) {
            charCount[right.charAt(i) - 'a']--;
        }

        int changes = 0;
        
        for (int count : charCount) {
            if (count > 0) {
                changes += count;
            }
        }

        return changes;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
