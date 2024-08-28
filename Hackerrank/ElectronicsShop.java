package Hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


/*
Electronics Shop problema de hackerank
Problema:
Se tienen dos arreglos uno de teclados y otro de USBs con precios de cada uno y se quiere averiguar la combinacion entre ambos mas alta que no exceda el limite de la variable b

Solución:
- Hay dos enfoques, el primero de fuerza bruta en el que se usan dos fors iterados para ver todas las combinaciones posibles y se compara con un maximo y de ahi se saca el valor
- La segunda usa n enfoque de dos punteros, primero se ordenan ambos arreglos y se comienza a recorrer el de teclados desde el mayor al menos y el de USBs de menos a mayor buscando las combinaciones posibles

Ejemplo:

b=60
------>
[40,50,60]

[5,8,12]
<------

1- 60+5 = 65 > 60 por ende se decrementa el indice de teclado
2- 50+5 = 55 <60 por ende nuevo maximo 55 y se aumenta indice usbs
3 - 50+8 = 58 <60 por ende nuevo maximo 58 y se aumenta indice usbs
4- 50+12 = 62 > 60 por ende se decrementa indice teclado
5- 40+12 = 52 <60 se compara el maximo pero no se actualiza y se aumenta indice usb
6- sale ya que el indice usbs<0 y retorna el maximo 58

*/

public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        int maxSpenth= -1;
        int j=0;
        int i= keyboards.length - 1;
        
        while(i>=0 &&  j < drives.length){
            int total= keyboards[i] + drives[j];
            if(total<= b){
                maxSpenth = Math.max(maxSpenth, total);
                j++;
            }
            else i--;
            
        }
         return maxSpenth;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
