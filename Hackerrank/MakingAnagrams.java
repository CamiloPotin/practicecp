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
Making anagrams de hackerrank

Problema:
Se tienen dos Strings de diferentes longitudes, se quiere saber cuantos caracteres hay que borrar de cada uno para hacer un anagrama

Solucion
Se recorre cada uno contando las frecuencias, primero se suman las del primero y dsps se restan las del segundo. Luego se suma la diferencia abs de estas frecuencias.


*/
class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here 
    int[] charCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
        }

       
        for (int i = 0; i < s2.length(); i++) {
            charCount[s2.charAt(i) - 'a']--;
        }

        int changes = 0;
        
        for (int count : charCount) {
            if (count != 0) {
                changes+= Math.abs(count);
            }
        }

        return changes;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
