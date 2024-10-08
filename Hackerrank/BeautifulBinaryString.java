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
Beautiful Binary String de hackerrank

Problema:
Se tiene un String de 1s y 0s y se quiere evitar cualquier cadena "010". Se debe devolver el numero de cambios minimos necesarios para que sea posible.

Solucion:
Se recorre el String en busca de todas las cadenas "010" posibles. Por cada una encontrada se suma un cambio

*/
class Result {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
    // Write your code here
         int changes = 0;    // Contador de cambios
        int i = 0;          // indice para recorrer la cadena
        
        // Recorrer la cadena
        while (i <= b.length() - 3) {
            // Buscar el patron "010"
            if (b.substring(i, i + 3).equals("010")) {
                changes++;      // Contar el cambio
                i += 3;        // Saltar al indice despues del patron "010"
            } else {
                i++;          // Avanzar al siguiente indice
            }
        }
        
        return changes;     // Devolver el numero de cambios necesarios
     
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = Result.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
