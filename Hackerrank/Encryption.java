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
Encryption de hackerrank
Problema:
Se quiere encriptar un String, se recibe el String sin espacios. Y se forma una grilla (matriz) de c x f donde las columnas es raiz(L(string)) redondeado abajo
y las filas son lo mismo pero redondeado para arriba. El String encriptado sera todos los caracteres de la primer columna mas un espacio y los de la segundas y se 
repite hasta el final.
Ejemplo: Para el string feedthedog    

Desde la matriz: 
  feed
  thed
  og
Resultado: fto ehg ee dd

Solucion:
Primero se calcula el tamaño correcto de la matriz y luego no es necesrio crearla sino que se recorre el mismo String buscando en las posiciones especificas
y se agregan al resultado final.

*/
class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    int L = s.length();
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        
        if (rows * cols < L) {
            rows++;
        }
        
        StringBuilder encrypted = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int index = r * cols + c;
                if (index < L) {
                    encrypted.append(s.charAt(index));
                }
            }
            encrypted.append(" ");
        }
        
       return encrypted.toString().trim();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
