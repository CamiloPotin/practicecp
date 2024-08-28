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
Library Fine hackerrank

Problema:
Se tiene una libreria y se quiere saber si un libro se devuelve a tiempo o no. Se tiene las dos fechas, la de devolucion y la esperada.
Si se devuelve un año tarde se carga 10000
Si se devuelve un mes tarde se carga 500*difMes
Si se devuelve dias taarde se carga 15*diasDif

Solucion
Se compmara primero el año y se carga
Y si no se compara los meses y por ultimo los dias

Se debe realizar la comparacion de años y meses en los demas ifs ya que puede darse que sea un año anterior o un mes anterior al esperado.

*/

class Result {

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    // Write your code here
      if (y1 > y2) {
        return 10000;
    }
    
    if (y1 == y2 && m1 > m2) {
        return 500 * (m1 - m2);
    }
    
    if (y1 == y2 && m1 == m2 && d1 > d2) {
        return 15 * (d1 - d2);
    }
    
    return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
