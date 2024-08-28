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
Mars Exlporation de hackerrank

Problema:
Un explorador especial esta mandando señales de ayuda. Se recibe un String con mensajes SOS pero algunas letras se vieron alteradas
averiguar cuantas de estas letras se modificaron.

Solucion:
Se recorre el Stringo comparando cada letra con la que deberia ser del mensaje "SOS"

*/
class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
    // Write your code here
                int count = 0;
                String sos = "SOS";

                for (int i = 0; i < s.length(); i++) {
                 if (s.charAt(i) != sos.charAt(i % 3)) {
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

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
