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
Caesar Cipher de hackerrank

Problema:
Se tiene un String y se quiere encriptar usando una rotacion de letra un numero dado por cada letra del String y cuando se pasa vuelve a emppezar por 'a'.

Solucion
Se recorre el String cambiando las letras haciendo una rotacion circular.

*/
class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    
    StringBuffer aux = new StringBuffer();
    for(int i = 0 ; i< s.length() ; i++){
        if(s.charAt(i)>='a' && s.charAt(i) <='z'){
            
                    aux.append((char)((s.charAt(i) - 'a' + k) % 26 + 'a'));
               
        
        }
        else if(s.charAt(i)>='A' && s.charAt(i) <='Z') {
                    
                 aux.append((char)((s.charAt(i) - 'A' + k) % 26 + 'A'));
                }
                else aux.append(s.charAt(i));
        
    }
    return new String(aux);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
