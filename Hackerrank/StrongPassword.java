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
Strong Password de hackerrank

Problema:
Se verifica si una contreña cumple:
- Tiene al menos 6 caracteres
- Tiene una minuscula
- Tiene una mayuscula
- Tiene un caracter especial
- Tiene un numero
Se debe devolver la cantidaad de caracteres que le faltan para que sea segura

Solucion:
Se corrobora que tenga todos los caracteres necesarios la contraseña y en caso de que falte 1 se suma en el total
Luego se devuelve el maximo entre los encontrados y los que faltarian si no llega a 6.

*/
class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
       
        String specialCharacters = "!@#$%^&*()-+";
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (specialCharacters.indexOf(c) != -1) hasSpecial = true;
        }

        int countMissing = 0;
        if (!hasDigit) countMissing++;
        if (!hasLower) countMissing++;
        if (!hasUpper) countMissing++;
        if (!hasSpecial) countMissing++;

       return Math.max(countMissing, 6 - n);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
