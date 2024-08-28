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
Two Strings de hackerrank

Probelma:
Se tienen dos Strings y se quiere saber si existe una subcadena de uno en el otro

Solucion:
Se recorre el primer String guardando todos los caracteres en un Set y luego se recorre el segundo buscando si contiene los caracteres de s2.





Solucion:


  // Write your code here
    for (int i = 0 ;i < s1.length() ; i++){
        if(s2.contains(s1.substring(i,i+1))){
            return "YES";
        }
        
    }
    return "NO";
Esta solucion no funciona ya que el contains del String recorre el otro String en busca de la coincidencia por lo que el orden final sera O(n*m) n lenght de s1 , m lenght de s2

En cambio la solucion al guardar en un set se tiene acceso O(1) por cada elemento por lo que el orden final sera O(n+m)
*/
class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
   Set<Character> charsInS1 = new HashSet<>();
   
    for (int i = 0; i < s1.length(); i++) {
        charsInS1.add(s1.charAt(i));
    }
    
   
    for (int i = 0; i < s2.length(); i++) {
        if (charsInS1.contains(s2.charAt(i))) {
            return "YES";
        }
    }
    
    return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
