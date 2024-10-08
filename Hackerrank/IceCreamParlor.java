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
Ice Cream Parlor de hackerrank

Problema:
Se quiere encontrar dos numeros dentro de un arreglo que la suma llega a k.

Solucion:
Se almacenan todos los numeros del arreglo y sus indices en un map y dsps se busca dentro del map si se encuentra la combinacion de indices correcta.

*/
class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    // Write your code here
    
    Map<Integer,Integer> map = new HashMap<>();
    
    for(int i = 0 ; i < arr.size() ; i++) {
        map.put(arr.get(i), i+1);
        
    }
    List<Integer> result = new ArrayList<>();
     for (int i = 0; i < arr.size(); i++) {
            int complement = m - arr.get(i);
            if (map.containsKey(complement) && map.get(complement) != i + 1) {
                result.add(i + 1); 
                result.add(map.get(complement));
                break;
            }
        }
    Collections.sort(result);
 return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
