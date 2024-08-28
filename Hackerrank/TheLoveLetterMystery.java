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
The Love-Letter Mystery de hackerrank

Problema:
Se tiene un String y se quiere calcular cuantas operaciones son necesarias para que sea palindromo. 
  - Las letras solo pueden bajar ( de B pasa a A)

Solucion:
Se recorre el string hasta la mitad sumane el absoluto de la diferencia entre los dos extremos 

Ejemplo:
String  "asb"

La diferencia entre a-b es 1 por lo que se suma 1 y al llegar a la mitad del String termina de contar



*/

class Result {

    /*
     * Complete the 'theLoveLetterMystery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int theLoveLetterMystery(String s) {
    // Write your code here
    int count = 0 ;
    for( int i = 0 ; i < s.length() / 2 ; i++ ) {
        count+= Math.abs(s.charAt(s.length()-1-i) - s.charAt(i));
        
    }
    return count ;

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

                int result = Result.theLoveLetterMystery(s);

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
