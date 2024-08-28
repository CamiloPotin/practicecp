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
Gemstones de hackerrank

Problema:
Una gemstone es una letra que se encuentra presente en todos los Strings de un array.

Solucion:
Se recorre el arreglo de Strings y por cada String se cuenta en un Set las letras encontrdas.
Luego de cada String se agrega en un HashMap las letras que se encontraron y se suman en 1 
Por ultimo se comprueba si esa letra encontrada tiene una frecuencia igual al tamaño del arreglo se suma una gemstone.

*/
class Result {

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
    // Write your code here
           // Inicializar un mapa para contar cuantas cadenas contienen cada letra
        Map<Character, Integer> gemPresence = new HashMap<>();
        
        // Recorrer cada cadena en la lista
        for (String str : arr) {
            // Usar un conjunto para almacenar letras unicas en la cadena actual
            Set<Character> uniqueLetters = new HashSet<>();
            
            for (char ch : str.toCharArray()) {
                uniqueLetters.add(ch);
            }
            
            // Actualizar la presencia de cada letra en la cadena
            for (char ch : uniqueLetters) {
                gemPresence.put(ch, gemPresence.getOrDefault(ch, 0) + 1);
            }
        }
        
        // Contar cuantas letras estan presentes en todas las cadenas
        int count = 0;
        for (int presenceCount : gemPresence.values()) {
            if (presenceCount == arr.size()) {
                count++;
            }
        }
        
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
