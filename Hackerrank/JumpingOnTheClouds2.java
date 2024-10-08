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
Jumping on the Clouds problema de hackerrank

Problema:
Se quiere saltar un array de nubes de 0s y 1s las nubes en 1 no se pueden pisar, buscar la cantidad de saltos minima para saltar hasta el final del arreglo (no hay dos nubes en 1 seguidas) y se salta de 1 o 2 posiciones

Solucion:
Preguntar si la nube siguiente haciendo dos pasos esta en 1 si no es el caso salto 2 y si no salto 1

*/

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
    int jumps=0;
    int i=0;
    do{
        if(i+2<c.size() && c.get(i+2)!=1){
            System.out.println("Para i: "+i+" salta 2 "+jumps);
            i+=2;
            
        } else {
            System.out.println("Para i: "+i+" salta 1 "+jumps);
            i++;}
        jumps++;
     }while(i<c.size()-1);
     return jumps;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
