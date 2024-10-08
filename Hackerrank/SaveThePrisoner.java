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

class Result {

    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */
     
     /*
      Problema:
      Se tiene n prisioneros y m caramelos, se quiere repartir caramelos para todos los prisioneros empezando desde la silla s. Pero el del final tendra un caramelo con sabor feo. Averiguar cual es el ultimo prisionero que recibe un caramelo


    Solucion:
    Es un problema con solución circular:

    La solucion circular es 0 indexada (comienza desde 0) ya que al hacer el modulo el primero si hago n%n = 0 
    en cambio aca los prisioneros se numeran de 1 a n y por ende la posicion inicial tambien iniciara en 1
    por ende para poder aplicar esta solucion se les resta 1 a ambas variables 
    
     */

    public static int saveThePrisoner(int n, int m, int s) {
    // Write your code here
     return ((s-1+m-1)%n)+1;

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

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

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
