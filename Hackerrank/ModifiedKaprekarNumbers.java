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
Modified Kaprekar Numbers

Problema:
Se quiere calcular el numero Kaprekar. Este cumple con que los digitos resultantes de n*n sumados dan el numero. 
Por ejemplo: n=9   -> 9*9=81 -> digitos= 8 y 1 -> 8+1 =9

Solucion
Para cada i en el rango [p,q] se calcula su cuadrado y la suma de los digitos del mismo

*/

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
     boolean found = false;

        for (int i = p; i <= q; i++) {
            long square = (long) i * i;
            String strSquare = Long.toString(square);
            int len = strSquare.length();
            int d = Integer.toString(i).length();

            String rightPart = strSquare.substring(len - d);
            String leftPart = (len - d > 0) ? strSquare.substring(0, len - d) : "0";

            int left = Integer.parseInt(leftPart);
            int right = Integer.parseInt(rightPart);

            if ((left + right) == i) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("INVALID RANGE");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
