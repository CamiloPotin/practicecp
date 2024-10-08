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
Game of Thrones - I

Problema:
Se tiene un String y se quiere saber si se puede armar un palindromo a partir del mismo.

Solucion:
Se cuenta la frecuencia de los caracteres. Se debe corroborar que la misma sea par para cada letra o en caso de que no que la longitud sea impar (solo puede haber un numero de frecuencia impar en este caso)



*/
class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    // Write your code here
    boolean impar = false;
    if(s.length()%2 != 0){
       // System.out.println("es impar "+s.length());
        impar = true;
    }
    char [] chars = new char[26];
    for(int i= 0 ; i< s.length() ; i++){
        chars[s.charAt(i)-'a']++;
        
    }
    
    for(int i= 0 ; i< chars.length ; i++){
        if(chars[i]%2!=0 && impar){
            //System.out.println("entro "+ i);
             impar = false;
        } else if(chars[i]%2!=0 && !impar) {
                    return "NO";
        }
        
    }
    return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
