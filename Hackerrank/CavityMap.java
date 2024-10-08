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
Cavity Map 

Problema:
Se tiene un arreglo de strings de numeros, se quiere reemplazar por X a los numeros que cumplen con:
  - Si no estan en el borde
  - Y se cumple que todos los numeros adyacentes son menores al candidato.

Solucion
Se recorre la matriz en busca de los reemplazos desde 1 hasta n-1


*/
class Result {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
    int n = grid.size();
    char[][] updatedGrid = new char[n][n];

    // Copiar el contenido original a updatedGrid
    for (int i = 0; i < n; i++) {
        updatedGrid[i] = grid.get(i).toCharArray();
    }

    // Procesar cada celda (excepto los bordes)
    for (int i = 1; i < n - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
            char current = updatedGrid[i][j];
            if (updatedGrid[i - 1][j] < current && 
                updatedGrid[i + 1][j] < current &&
                updatedGrid[i][j - 1] < current && 
                updatedGrid[i][j + 1] < current) {
                updatedGrid[i][j] = 'X';
            }
        }
    }

    // Convertir el grid actualizado a ArrayList<String>
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        result.add(new String(updatedGrid[i]));
    }

    return result;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
