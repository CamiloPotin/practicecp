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
Drawing Book

Problema:
Se tiene un libro de n paginas y se quiere llegar a la pagina p desde el inicio o final. Se debe averiguar cuantas paginas hay que pasar para llegar a la hoja
Se debe elegir la cantidad de hojas minima

Solucion
Se resuelve con dos formulas:
  Para el incio: p / 2

  Para el final: (n / 2) - (p / 2)

*/

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
     
    int vueltas_desde_inicio = p / 2;

    int vueltas_desde_final = (n / 2) - (p / 2);

   return Math.min(vueltas_desde_inicio, vueltas_desde_final);
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
