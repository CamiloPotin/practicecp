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
Funny String de hackerrank

Problema:
Un String es "Funny" si la diferencia absoluta entre dos caracteres adyacentes y la diferencia del reverso son iguales.

Solucion
Se saca el String reverso primero, dsps se calcula dos arreglos con las diferencias de cada adyacente de ambos String.
Por ultimo se compara si los dos arreglos resultantes son iguales.

*/
class Result {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
    // Write your code here
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        
        List<Integer> result = new ArrayList<>();
        List <Integer> result1= new ArrayList<>();
        
        for(int i= 1 ; i< s.length(); i++){
            result.add(Math.abs(s.charAt(i)-s.charAt(i-1)));
            result1.add(Math.abs(reversed.charAt(i)-reversed.charAt(i-1)));
        }
        
        for(int i = 0 ; i < result.size() ; i++){
            if(result.get(i) != result1.get(i))
                return "Not Funny";
            
        }
        return "Funny";
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

                String result = Result.funnyString(s);

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
