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
Weighted Uniform Strings de hackerrank

Problema:
Se tiene una cadena de String 

*/
class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    // Write your code here
     Map<Integer, Boolean> weightMap = new HashMap<>();
        int acc = 0;
        char c = '\0'; 

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                acc += (s.charAt(i) - 'a') + 1;
            } else {
                acc = (s.charAt(i) - 'a') + 1;
                c = s.charAt(i);
            }
            weightMap.put(acc, true);
        }

        List<String> result = new ArrayList<>();
        for (int i : queries) {
            if (weightMap.containsKey(i)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }

        return result;
 }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
