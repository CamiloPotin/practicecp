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
Day of the programmer hackerrank

Problema:
El dia del programador es el dia 256 del mes, dependiendo el año sera el 12 de septiempre o el 13. Se desea calcular el dia del programador en base al año
Los años van de 1700 a 2700, 
desde 1700 a 1917 cuenta el calendario juliano:
  -El año es bisiesto si cumple que es divisible por 400 o es divisible por 4 y no por 100

desde 1918
  - Es el unico año especial en el que el dia del programador es 26.09.1918
desde 1919 es calendario gregoriano
  - El año es bisiesto si cumple que es divisible por 4

Solucion:
Primero se ve en que calendario esta y en base a eso se hacen los calculos de si es año bisiesto o no. Por ultimo se devuelve en base a eso

*/

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
    // Caso especial
    if (year == 1918) {
            return "26.09.1918";
        }
        
        boolean leap = false;
        // Si es calendario juliano y es bisiesto
       if (year < 1918) {
            leap = (year % 4 == 0);
        } 
        else {
            // Si es calendario gregoriano y bisiesto
            leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }

       return leap ? "12.09." + year : "13.09." + year;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
