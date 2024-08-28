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
Extra Long Factorial de hackerrank

Problema:
Calcular el factorial de un numero, se complica ya que para n>20 long (64 bits) ya no sirve por lo que en java se usa BigInt que es un quilombo de usar

Solucion:
Calcular el factorial


*/

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
    // Write your code here
    BigInteger total = BigInteger.valueOf(1);
    while(n!=0){
        //System.out.println(total+" "+n);
        total= total.multiply(BigInteger.valueOf(n));
        n-=1;
        
    }
    System.out.println(total);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
