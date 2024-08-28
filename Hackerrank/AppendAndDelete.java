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
Apprend and delete de hackerrank

Problema:
Se pueden hacer dos operaciones sobre strings, borrar la ultima letra y agregar una letra cualquiera al final. Se tienen dos Strings s y t y una cantidad k de operaciones
se debe averiguar si es posible convertir s a t usando exactamente k operaciones.

Solucion
Se cuentan primero los prefijos en comun
Dsps se calcula el total de operaciones necesarias:
      totalOperationsNeeded = sLength + tLength - 2 * prefix
Al total de longitud entre ambos le restamos el prefijo en comun (2*prefix) por lo que quedaria el total de operaciones de borrado y agregado (se borran (sLength-prefix) y se agregan (tLength-prefix))
Luego se comprueba si las operaciones finales son pares para cumplir con hacer exactamente k operaciones:
  (k - totalOperationsNeeded) % 2
Por ultimo se comprueba se comprueba si alcanza directamente k para borrar s entero y agregar t
sLength + tLength <= k

*/
class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
       int i = 0;
        int prefix = 0;
        int sLength = s.length();
        int tLength = t.length();
        
       
        while (i < sLength && i < tLength && s.charAt(i) == t.charAt(i)) {
            prefix++;
            i++;
        }
        
        
        int totalOperationsNeeded = sLength + tLength - 2 * prefix;
        
       
        if (totalOperationsNeeded <= k && (k - totalOperationsNeeded) % 2 == 0 || sLength + tLength <= k) {
            return "Yes";
        }
        
        return "No";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
