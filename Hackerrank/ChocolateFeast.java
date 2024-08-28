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
Chocolate feast de hackerrank

Problema: 
Quieren comprar una cantidad de chocolate y por cada m envoltorios que tengan consiguen un chocolate gratis. Se tiene n plata y los chocolates cuestan c.
Si se tiene 15 3 2
Se compran 5 chocolates y se tienen 5 envoltorios
Por los 5 envoltorios se pueden comprar 2 chocolates y sobra 1 
Ahora quedan 3 envoltorios se puede comprar un chocolate mas y sobra 1 
Por ultimo quedan 2 envoltorios y se puede comprar 1 chocolate mas

Solucion
Calcular en un while la cantidad de chocolates y envoltorios por cada iteracion hasta que queden menos envoltorios de los que consiguen un chocolate.

*/

class Result {

    /*
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    public static int chocolateFeast(int n, int c, int m) {
    // Write your code here
    int chocolates = n/c;
    int wrappers =  chocolates;
    
    while(wrappers>=m){
       int additionalChocolates = wrappers / m;
        chocolates += additionalChocolates;
        wrappers = wrappers % m + additionalChocolates; 
    }
    return chocolates;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.chocolateFeast(n, c, m);

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
