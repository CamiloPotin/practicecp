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
Separate the numbers de hackerrank

Problema:
Se quiere separar los numeros de un String y tienen que cumplir que:
 - Son un numero seguido de otro ej: 12345 es 1,2,3,4,5
 - Tiene que estar en orden

Solucion:
Se tiene que ir seleccionando todos posibles inicios y a partir de cada uno ver si se cumple o no.


*/

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
        int length = s.length();

        // Probar todas las posibles longitudes iniciales
        for (int i = 1; i <= length / 2; i++) {
            String firstNumber = s.substring(0, i);
            long number = Long.parseLong(firstNumber);
            StringBuilder sequence = new StringBuilder(firstNumber);

            // Generar secuencia consecutiva
            while (sequence.length() < length) {
                number++;
                sequence.append(number);
            }

            // Comparar secuencia generada con la cadena original
            if (sequence.toString().equals(s)) {
                System.out.println("YES " + firstNumber);
                return;
            }
        }
        System.out.println("NO");
       
       
        
    }

    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
