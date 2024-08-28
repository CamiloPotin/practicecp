package LeetCode.TwoPointers;/*
Valid Palindrome 125

Problema:
Se tiene un String con cualquier caracter ASCII y se quiere saber si es palindromo sacando todos
los caracteres no alfanumericos y los espacios.

Solucion
Se recorre usando el enfoque de dos punteros y busca un caracter valido de cada lado y se compara

OBS: se puede hacer mas rapido si la comparacion de si el caracter es digito, mayuscula o miniscula se hace directamente.


*/

class Solution {
    public boolean isPalindrome(String s) {
             int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Obtener y convertir los caracteres a minúsculas
            char chLeft = Character.toLowerCase(s.charAt(left));
            char chRight = Character.toLowerCase(s.charAt(right));

            // Verificar si chLeft es una letra o dígito
            if (!Character.isLetterOrDigit(chLeft)) {
                left++;
                continue;
            }
            
            // Verificar si chRight es una letra o dígito
            if (!Character.isLetterOrDigit(chRight)) {
                right--;
                continue;
            }
            
            // Comparar los caracteres
            if (chLeft != chRight) {
                return false;
            }
            
            // Mover los punteros hacia el centro
            left++;
            right--;
        }
        
        return true;
    }
}
