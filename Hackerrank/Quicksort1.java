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
Quicksork 1 de hackerrank

Problema:
Se desea realizar el algoritmo de ordenamiento quicksort

SOlucion:
Siguiendo lo que dice en el enunciado se realizo el algoritmo.

*/
class Result {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
    
    int p = arr.get(0);
    
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    equal.add(p);
    for(int i=1 ; i < arr.size() ; i++ ) {
        if(arr.get(i)>p){
            right.add(arr.get(i));
        }
        else if(arr.get(i)<p){
                left.add(arr.get(i));
        } else equal.add(arr.get(i));
        
        
    }
    left.addAll(equal);
    left.addAll(right);
    return left;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
