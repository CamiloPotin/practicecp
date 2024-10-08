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
The full counting sort de hackerrank

Problema:
Se tiene un array que continene un indice y un string. Se quiere usar el counting sort para ordenarlo
Y luego imprimirlo en orden. Tambien se quiere reemplazar la primera mitad del orden por "-"

Solucion:
Se usa un arreglo bidimensional en el que se lleva por cada indice una lista con los indices dentro del arreglo  original o con -1 en caso de que sea un "-"
Luego se arma el String final (si se imprime directo consume mucho mas tiempo)

*/
class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
    // Write your code here
     List<List<Integer>> output = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            output.add(new ArrayList<>());
        }
        
        for (int i = 0; i < arr.size(); i++) {
            int index = Integer.parseInt(arr.get(i).get(0)); 
            
            
            
            if (i < arr.size() / 2) {
                output.get(index).add(-1);
            } else {
               output.get(index).add(i);
            }
        }
        
                StringBuilder result = new StringBuilder();
        for (List<Integer> list : output) {
            for (Integer idx : list) {
                if (idx == -1) {
                    result.append("- ");
                } else {
                   
                    result.append(arr.get(idx).get(1)).append(" ");
                }
            }
        }
        
        System.out.println(result.toString().trim());

 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
