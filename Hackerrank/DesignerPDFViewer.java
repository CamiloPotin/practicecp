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
Designer PDF viewer de hackerrank se quiere hacer un pdf viewer (se resalta una palabra) y para ello se tiene que calcular el area de una palabra.
Se tiene un arreglo de numeros que representa la altura de cada letra y otra variable con una palabra. Se quiere averiguar el area de esa palabra (se calcula con mayor altura  multiplicado por el total de palabras).

Solucion
Se recorre la palabra y se compara la altura del caracter con una altura maxima
luego de recorrer se calcula y devuelve el area
(La dificultad esta en hacer bien la conversion de la letra al numero que lo representa, es decir, restarle a la letra 'a' para conseguir el numero de la misma)



*/

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
    // Write your code here
        int max=0;
     for(int i=0; i <word.length();i++){
         int aux= h.get(word.charAt(i)-'a');
         if(aux>max){
             max=aux;
         }
     }
     return max*word.length();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
