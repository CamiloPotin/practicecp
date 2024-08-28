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
Service Lane de hackerrank
Problema:
Se tiene un arreglo con el ancho de una carretera y otro con indices donde arranca y finaliza un servicio, se debe determinar cual es el ancho en el que un auto puede pasar con seguridad (minimo)

Solucion
Se recorre el arreglo de indices y se calcula el minimo en ese segmento, luego se agrega al arreglo de minimos final. Por ultimo se devuelve el arreglo de minimos conseguido

*/
class Result {

    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    public static List<Integer> serviceLane(int n, List<List<Integer>> cases,List<Integer> width) {

    List<Integer> result = new ArrayList<>();
    for(int i=0 ; i< cases.size();i++){
        int min=Integer.MAX_VALUE;
        for(int j=cases.get(i).get(0);j<=cases.get(i).get(1);j++){
            //System.out.println("width: "+width.get(j)+" j:"+j+" i:"+i);
            if(width.get(j)<min){
                min= width.get(j);
            }
        }
        result.add(min);
    }
    return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(n, cases,width);

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
