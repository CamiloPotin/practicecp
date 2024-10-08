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
Minimun distances hackerrank

Problema: 
Se tiene un array y se quiere calcular la distancia minima entre dos elementos. EN caso de que no exista una distancia se devuelve -1

Solucion
Se crea un hashMap donde se almacena el indice donde se encontro el ultimo valor de un elemento.
Si se encuentra otro se calcula la distancia y se compara con el minimo. Luego se actualiza la distancia y se continua recorriendo el array.

*/
class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);
            if (map.containsKey(current)) {
                int aux = map.get(current);
                if (min > (i - aux)) {
                    min = i - aux;
                }
            }
            map.put(current, i);
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
