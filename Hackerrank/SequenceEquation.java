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
SequenceEquation

Problema: 
Se tiene un arreglo que representa una funcion donde 
x es el indice del arreglo y f(x) es el contenido del arreglo
Se quieren calcular un arreglo en el cual f(f(y)) = x

Es decir:
 Si tengo el arreglo de 1 a n [2,3,1]

Mi explicacion:
x representa la posicion 1 y el y que coincide con este es f(3) por lo tanto tenemos que encontrar la Y donde se encuentra la posicion X entonces ahora debemos imprimir el Y que signifique la posicion de esta
x=1 -> f(3) -> f(f(2)) = f(f(y))  por lo tanto imprimimos 2
x=2 -> f(1) -> f(f())



*/

class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
            int n = p.size();
            List<Integer> pInverted = new ArrayList<>(n);
      
           // Agrega la cantidad de 0 igual a N nose si es necesario (sirve para asegurar que no tenga basura las posiciones)    
            for (int i = 0; i < n; i++) {
                pInverted.add(0);
            }

           // Se invierte el arreglo entre Xs e Ys
            for (int i = 0; i < n; i++) {
                pInverted.set(p.get(i) - 1, i + 1);
            }

            // Se invierte nuevamente el arreglo
            List<Integer> result = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                result.add(pInverted.get(pInverted.get(j) - 1));
            }

            return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
