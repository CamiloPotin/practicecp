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
ACM ICPC TEeam de hackerrank

Problema:
Se tiene n personas para una final de una competencia cada una sabe sobre una cierta cantidad de topicos, se tiene un arreglo de Strings que contiene 1s y 0s en el cual 1 es que se sabe sobre ese topico y 0 no.
Se quiere saber cual es la combinacion de dos estudiantes que mas topicos saben entre ambos.

Solucion:
Solucion O(n*n) se recorre toda combinacion posible de estudiantes sumando para cada uno la cantidad de topicos total que suman entre los dos.

Observacion: Se puede mejorar usando directamente comparacion bit a bit OR en vez de la funcion esa y contarlos
   int combinedSkills = Integer.bitCount(topics[i] | topics[j]);
*/
class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
         int maxTopics = 0;
        int teamCount = 0;
        int n= topic.size();
        // Comparamos cada par de personas
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Contamos los temas combinados usando un bitwise OR
                int combinedSkills = countCombinedSkills(topic.get(i), topic.get(j));
                
                // Actualizamos el maximo de temas y el contador de equipos
                if (combinedSkills > maxTopics) {
                    maxTopics = combinedSkills;
                    teamCount = 1;
                } else if (combinedSkills == maxTopics) {
                    teamCount++;
                }
            }
        }
        
          // Devolvemos el resultado como un arreglo
            ArrayList<Integer> result = new ArrayList<>();
            result.add(maxTopics);
            result.add(teamCount);
            return result;
    }
    
    private static int countCombinedSkills(String person1, String person2) {
        int count = 0;
        for (int k = 0; k < person1.length(); k++) {
            if (person1.charAt(k) == '1' || person2.charAt(k) == '1') {
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

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
