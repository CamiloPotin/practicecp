package Hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
Jumping on the clouds problema de hackerrank
Problema:
Alguien esta saltando de nube en nube una distancia K y tiene una energia e, por cada salto pierde 1 de energia y si encuentra una nube con valor 1 pierde 2 de energia termina de recorrer cuando vuelve al inicio

Solucion
Recorrer el arreglo de forma circular restando la energia y cada vez que encuentre una nube en 1 resta dos.
*/
public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        
        int i =0;
        int e=100;
        int n= c.length;
        do {
        
            e--;
          
            if (c[i] == 1) {
                e -= 2;
            }
          
            //System.out.println("Energa: " + e + ", ndice: " + i); 
            i = (i + k) % n;
        } while (i != 0); 
        
        return e;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
