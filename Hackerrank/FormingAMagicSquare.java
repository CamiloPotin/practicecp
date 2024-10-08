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
Forming a Magic Square hackerrank
Problema: 
Se tiene una matriz de 3x3 de numeros entre 1 y 9 y se debe conseguir el costo cuadrado magico consta de una matriz en la que sumados cualquier fila columna o diagonal da el numero magico. EL costo se calcula con la diferencia entre el numero a y b


Solucion:
La solucion es de fuerza bruta y sirve para un tamaño fijo ya si es variable nose como seria.

Dado que es un numero fijo de filas y columnas de la matriz se pueden hacer 8 combinaciones posibles donde queda una matriz determinada que cumple el numero magico
Por lo tanto se usa espacio para definir estas combinaciones y se recorre matriz por matriz comparando las filas y columnas de cada una con la dada para calcular el costo, luego se suma ese costo al total y al final se compara con el de otra matriz magica
Por ultimo se devuelve el minCost obtenido.

*/

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
     
     // Son todas las combinaciones posibles del Magic Square
      int[][][] magicSquares = {          // Combinaciones posibles de matrices magicas
        {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},     // Una posible matriz magica
        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},    // Otra
        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
        {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };
    
          int minCost = Integer.MAX_VALUE;
            
        
        for (int[][] magic : magicSquares) {      // Por cada matriz magica
            int cost = 0;
            for (int i = 0; i < 3; i++) {        
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s.get(i).get(j) - magic[i][j]); // Calculo el costo para cada elemento de la matriz con la original
                }
            }
            minCost = Math.min(minCost, cost);  // Se compara el costo total de esa matriz con el min
        }

        return minCost;  

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
