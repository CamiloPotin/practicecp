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
The Time in words hackerrank

Problema:
Se debe imprimir el tiempo en horas y tener en cuenta que:
Si m=1 se imprime one past
si m=15 se imprime tanto
 y asi varios casos

Solucion
Se guarda un string con todas las horas hasta 30 y se imprime segun sea
*/
class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
    // Write your code here
       String[] numbers = {
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "twenty one", "twenty two", "twenty three",
                "twenty four", "twenty five", "twenty six", 
                "twenty seven","twenty eight", "twenty nine"
        };

        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 1) {
            return "one minute past " + numbers[h];
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[(h % 12) + 1];
        } else if (m == 59) {
            return "one minute to " + numbers[(h % 12) + 1];
        } else if (m < 30) {
            return numbers[m] + " minutes past " + numbers[h];
        } else {
            return numbers[60 - m] + " minutes to " + numbers[(h % 12) + 1];
        }
            
        }

}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
