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
Halloween Sale de hackerrank
Problema:
Se quiere comprar juegos con s plata cada juego tiene un precio inicial p y disminuye en d unidades hasta llegar a un minimo m
Se quiere calcular cuantos juegos se pueden comprar

Solucion
Se debe ir haciendo la resta de la plata mientras se va sumando la cantidad 

*/

class Result {

    /*
     * Complete the 'howManyGames' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER d
     *  3. INTEGER m
     *  4. INTEGER s
     */

    public static int howManyGames(int p, int d, int m, int s) {
    // Return the number of games you can buy
        int cant = 0;
    while (s >= p) {
        s -= p;
        cant++;
        p = Math.max(p - d, m);  // Asegurarse de no decrementar el precio por debajo de m
       // System.out.println("Presupuesto restante: " + s + ", Precio actual: " + p + ", Juegos comprados: " + cant);
    }
    return cant;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
