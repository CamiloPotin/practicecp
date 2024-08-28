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
CamelCase de hackerrank

Problema:
Se tiene un string con palabras todas seguidas donde la primera empieza con minuscula  y cuando arranca una neuva aparece una mayuscula.
Se quiere saber el numero total de palabras.

Solucion:
Se arranca contando de una y se va buscanndo en el String por cada mayuscula se suma 1 en el contador

Ej:
estoEsUnEjemplo tiene 4 palabras

*/


class Result {

    /*
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int camelcase(String s) {
    // Write your code here
    int count = 1;
    for( int i = 0 ; i<s.length() ; i++) {
         if(s.charAt(i)>='A' && s.charAt(i)<= 'Z'  )
            count++;
        
    }
    return count ; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
