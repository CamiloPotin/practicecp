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
Running Time of Algorithms de hackerrank

Problema:
Se tiene un algoritmo de ordenamiento y se quiere devolver la cantidad de rotaciones que se hacen entre los elementos

Solucion:
Es el mismo que Correctness and the loop invariant pero con una variable count

*/

class Result {

    /*
     * Complete the 'runningTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int runningTime(List<Integer> arr) {
    // Write your code here
    int count = 0 ;
    for(int i = 1 ; i < arr.size() ; i++){
        int value = arr.get(i);
        int j = i - 1;
        while(j>=0 && arr.get(j)> value){
            arr.set(j+1,arr.get(j));
            j--;
            count++;
        }
 
            arr.set(j+1, value);
          
            
          for(int n: arr){
            System.out.print(n+" ");
        }  System.out.println();
        
    }
    return count;
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

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
