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
Super Reduced String

Problema:
Se tiene un String y se quiere ver el String resultanto de eliminar todos los caracteres adyacentes. En caso de que este vacio devuelve "Empty String"

Solucion
Se va guardando en una pila los caracteres y si aparecen dos iguales se borran.
Luego se devuelven los caracteres restantes en la pila.


*/
class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
     Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
           
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
          
                stack.push(currentChar);
            }
        }
        
       if (stack.isEmpty()) {
            return "Empty String";
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
