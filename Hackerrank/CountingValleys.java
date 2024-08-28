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
Counting Valleys problem from Hackerrank

Estan haciendo hikking 
Se tiene un arreglo con caracteres "D" y "U" cuando aparece un "D" baja un nivel y cuando aparece U sube un nivel, arranca en nivel del mar 0 y cuando baja del mismo entra en un valle


Solucion
Contar las veces que entro a un valle ( nivel del mar <0) y salio cuando pasa de nivel del mar negativo a 
0

Ejemplo de hickin grafico:

_/\      _
   \    /
    \/\/

Cuando hace dos pasos entra en el valle a partir de un nivel de mar -1 y cuando sale casi al final del mismo por lo tanto hay un solo valle
*/


class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
     
     int seaLevel=0;
     int countValey=0;
     boolean valey= false;
     for(int i=0;i < path.length();i++){
         char ch= path.charAt(i);
         if(ch == 'U')
            seaLevel++;
            else seaLevel--;
        
        if(seaLevel<0)
            valey = true;
        
        if(seaLevel== 0 && valey){
            countValey++;
            valey = false;
            }
            
     }
     return countValey;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
