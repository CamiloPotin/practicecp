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
Sherlock and Anagrams de hackerrank

Problema:
Se tiene un String y se quiere calcular a partir de dos substrings la cantidad de anagramas posibles.

Solucion:
Se calcula la cantidad de subcadenas ordenadas que hay en el String y despues se recorre y calcula por cada una se suma al total.


*/
class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
         int n = s.length();
        int count = 0;
        Map<String, Integer> substrMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                char[] chars = s.substring(i, j).toCharArray();
                Arrays.sort(chars);
                String sortedSubstr = new String(chars);

                substrMap.put(sortedSubstr, substrMap.getOrDefault(sortedSubstr, 0) + 1);
            }
        }

       for (String key : substrMap.keySet()) {
            int k = substrMap.get(key);
            count += (k * (k - 1)) / 2;
        }

        return count;
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

                int result = Result.sherlockAndAnagrams(s);

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
