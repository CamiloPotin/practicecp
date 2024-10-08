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
Bigger is greater de hackerrank

Problema:
Se quiere crear una palabra que siga el oden lexografico a partir de un String original cambiando algunas letras posicion o todas y que:
 - Sea mas grande que el String original
 -Tiene que ser la palabra mas pequeña que cumpla esa condicion

Solucion:
Se busca primero la letra que sea mas chica que la siguiente y en segundo lugar se busca una que cumpla


Revisar bien 

*/

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
        char[] chars = w.toCharArray();
        int n = chars.length;
        
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return "no answer";
        }
        
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        
        swap(chars, i, j);
        
       reverse(chars, i + 1, n - 1);
        
       return new String(chars);
    }

   private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

     private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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
