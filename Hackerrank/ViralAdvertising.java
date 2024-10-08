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
Viral advertising de hackerrank

Problema: 
Una empresa quiere hacer un anuncio para un producto y el primer dia lo comparte solamente a 5 personas en redes sociales de los cuales la mitad le da like y lo comparte a 3 personas. 
El primer dia la mitad (redondeando abajo)lo comparte a 3 personas. Por lo tanto el segundo dia lo veran son la mitad de las personas a las cuales lo compartieron y los 3 a los que lo comparten. 

Se desea saber la cantidad de likes


Solucion:
Se debe recorrer cada dia contando la cantidad de likes (compartidos/2) y preparando los compartidos del dia siguiente
1-  De 5 personas la mitad lo comparte a 3: 2x3 = 6 personas veran el anuncio el dia siguiente
2- De 6 la mitad ve el anuncio y lo comparte a 3 : 3x3 = 9 personas veran el anuncio el dia siguiente
3- De 9 la mitad (redondeando abajo) lo comparte a  3 : 4x3 = 12 personas veran el anuncio al dia siguiente

Likes: 2+3+4 = 10
*/

class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
    // Write your code here
        int shared = 5; // initial people who see the ad
        int likes = 0;

        for (int i = 1; i <= n; i++) {
            int liked = shared / 2; // people who like the ad
            likes += liked;
            shared = liked * 3; // people who will see the ad the next day
        }

        return likes;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
