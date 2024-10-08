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
Manasa and Stones

Problema:
Se tiene una persona que hace un n numeros de pasos y puede agarrar una piedra del tamaño a o de tamaño b por cada paso.
Arranca con 0 piedras y se quiere calcular todos los resultados posibles de cantidad de piedras final al dar n-1 pasos.

Solucion:
Se recorre hasta n calculando los posibles valores finales si elige i piedras de a y ademas n-1-i de b y se agrega al resultado final

obs: el set es para no repetir resultados

*/

class Result {

    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
    // Write your code here
      Set<Integer> stones = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int stone =  i * a + (n - 1 - i) * b;
            stones.add(stone);
        }

        ArrayList<Integer> result = new ArrayList<>(stones);
        Collections.sort(result);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.stones(n, a, b);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
