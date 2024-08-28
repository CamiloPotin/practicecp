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
Happy LadyBugs

Problema:
Se tiene un arreglo de chars que contienen solo letras mayusculas y "_". Y tiene que cumplir que:
  -Si tiene un "_" la celda esta vacia se puede intercambiar cualquier letra por esa celda
  - Tienen que estar al menos dos letras juntas para estar "felices" 
  -

Solucion
Se verifica si hay letras unicas primero
Despues se verifica si hay al menos un "_" y si se cumple devuelve YES
Por ultimo se verifica si ya no estan ordenadas y cumple

OBS: para "RBBR" creo que no anda

*/

class Result {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
   Map<Character, Integer> freqMap = new HashMap<>();
        boolean hasSingle = false;
        
       for (char ch : b.toCharArray()) {
            if (ch != '_') {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }
        
        for (int count : freqMap.values()) {
            if (count == 1) {
                hasSingle = true;
                break;
            }
        }
        
        if (hasSingle) {
            return "NO";
        }
        
       if (b.contains("_")) {
            return "YES";
        }
        
       for (int i = 0; i < b.length(); i++) {
            if (i > 0 && b.charAt(i) != b.charAt(i - 1)) {
                if (i < b.length() - 1 && b.charAt(i) != b.charAt(i + 1)) {
                    return "NO";
                }
            }
        }
        
        return "YES";
    }    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

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
