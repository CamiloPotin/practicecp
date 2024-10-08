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
Closest Numbers de hackerrank

Problema:
Se tiene un arreglo que se quiere ordenar y encontrar la menor diferencia entre dos elemntos ordenados. 
Si existen mas elementos con la menor diferencia tambien se incluyen.
Se devuelve un array con los elementos que tienen la menor diferencia

Solucion:
Se ordena el arreglo (lo quise hacer pero queda n2 y se pasa de tiempo) y dsps se buscan los posibles minimos guardando los valores
por cada nuevo minimo encontrado

*/

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
    
    
    Collections.sort(arr);
    
    int min = Integer.MAX_VALUE;
    List<Integer> index = new ArrayList<>();
    for(int i = 0 ; i < arr.size()-1 ; i++){
        
        int sum = arr.get(i+1)-arr.get(i);
        if(sum < min){
             min = sum;
             index.clear();
             index.add(arr.get(i));
             index.add(arr.get(i+1));
            } else if(sum==min){
                    index.add(arr.get(i));
                    index.add(arr.get(i+1));
            }
    }
    return index;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
