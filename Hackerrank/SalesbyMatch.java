package Hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;otl
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;t



/*
Sales by match de hackerrank

Problema: Te dan un arreglo con tipos de calcetines y tenes que ir sumando los pares de cada uno

Solucion: ir guardando en un arreglo para cada tipo de calcetin la cantidad y dsps recorrer la estructura calculando los pares y sumando al total

*/


class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
            int[] aux= new int[101];
            int count=0;
            for(int i : ar){
                aux[i]++;
            }
            for(int i: aux){
                if(i/2!=0){
                    
                    count+= i/2;
                    //count+= i%2;
                    //System.out.println(count+" "+(i/2)+" "+(i%2)+" "+i);
                    
                }
            }
            return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
