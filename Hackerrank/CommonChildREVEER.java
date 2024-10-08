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
Common child de hackerrank

Problema:
Se tienen dos Strings de igual longitud y se quiere saber cual es el String hijo  (que sea el mismo String a partir de los dos) a partir de los dos que se puede construir:
  - Solo borrando letras
  - Y manteniendo el orden de las letras

Solucion:
Se usa una matriz para ir contando las coincidencias de las letras y se recorre por cada letra de uno todo el otro String en busca de coincidencias y se suma en su respectiva fila y columna en caso positivo.
Al final del recorrido en la posicion nxm se encontrara el valor maximo de coincidencias.
(Este es el enfoque por defecto para el tipo de problema subsecuencia común más larga (LCS))


REVISAR BIEN SOLUCION
*/
class Result {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
    // Write your code here
      int m = s1.length();
        int n = s2.length();
        // Crear la tabla DP de tamanio (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Llenar la tabla DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Si los caracteres coinciden, incrementar la longitud de la subsecuencia comun
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Si no coinciden, tomar el maximo de las opciones posibles
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // El valor en dp[m][n] es la longitud de la subsecuencia comun mas larga
        return dp[m][n];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
