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
Sherlock and Squares hackerrank
Problema:
Se tiene dos numeros a y b y se quiere calcular la cantidad de cuadrados que se encuentran en medio de ellos

Solucion:
Mi solucion fue iterar e ir comparando si daban los cuadrados pero es ineficiente para numeros grandes.
Por lo que la solucion hace un calculo sencillo entre ambos limites. Se calcula el cuadrado mas proximo al valor a  y el cuadrado mas proximo a b
Para a=3 y b=9

sqrt(3) =  1,73205080757 se redondea para arriba usando ceil lo que da 2. Es la primer raiz dentro de ese rango que cumple por lo que arranca desde 2
sqrt(9) = 3  Es el ultimo valor que cumple dentro del rango.

Por lo tanto la diferencia entre ambos seran la cantidad de raices que se con

La diferencia es sencilla ya que solo hay que calcular los numeros enteros entre los que se encuentran los limites y dsps la diferencia entre los mismos}
Si a= 4 y b= 81
Inicio sera 2 y el final 9 por lo que contendran 8 valores enteros en total
2 3 4 5 6 7 8 9  


*/
class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {

    int start = (int) Math.ceil(Math.sqrt(a));
    
    int end = (int) Math.floor(Math.sqrt(b));
    
  
    return (end - start) + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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
