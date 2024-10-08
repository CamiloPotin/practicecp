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
Beautiful days at the movies hackerrank

Problema:::
Se tiene un arreglo de dias y se quiere saber cual es la cantidad de dias de los cuales la diferencia con su reverso es divisibles por K :
(dia-inv(dia))/k

Solucion
Se recorre la cantidad de dias y por cada uno se calcula el inverso, luego se hace la diferencia entre ambos y se divide por k.
Si el resto es 0 es divisible y se suma.
*/
class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    int count=0;
    for(int num=i; num<=j;num++){
        int aux= num;
        int numInv=0;
        while (aux != 0) {
            int digit = aux % 10;
            numInv= numInv * 10 + digit;
            aux = aux / 10;
        }
        int rest= Math.abs(num-numInv); 
        if(rest %k== 0 ){
            count++;
            
            
        }
        
    }
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
