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
String construction de hackerrank

Problema:
Se tiene un String y se quiere crear otro String "p" a partir de este. Se puede realizar dos operaciones:
  - Copiar una letra del original a p que cuesta 1
  - Copiar un substring de p al final del mismo por costo 0.

Solucion:
Se cuentan los caracteres unicos presentes en el String original y el resultado sera el tamaño de ese Set.
(Ya que si esta presente la letra se puede agregar por costo 0 despues de agregarla por primera vez)

*/
class Result {

    /*
     * Complete the 'stringConstruction' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int stringConstruction(String s) {
    // Write your code here
       Set<Character> uniqueChars = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
        uniqueChars.add(s.charAt(i));
    }

     return uniqueChars.size();
        
    }
    
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.stringConstruction(s);

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
