package LeetCode.SlidingWindow;/*
424. Longest Repeating Character Replacement de leetcode

Problema:
Se tiene un String de letras mayusculas y se quiere saber cual es el Substring mas largo de caracteres iguales
que se puede hacer cambiando k caracteres para que todos sean iguales

Solucion:
Usando ventana deslizante se cuentan las frecuencias y cuando se pasa de K se achica la ventan
(igual al problema 1004)


*/





class Solution {
    public int characterReplacement(String s, int k) {
      int[] count = new int[26];  // Para contar la frecuencia de cada carácter
    int maxCount = 0;  // Frecuencia del carácter más común en la ventana actual
    int left = 0;  // Límite izquierdo de la ventana
    int maxLength = 0;  // Longitud máxima de la subcadena válida

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        count[ch - 'A']++;  // Incrementa la frecuencia del carácter actual
        maxCount = Math.max(maxCount, count[ch - 'A']);

        // Si la ventana no es válida (requiere más de k reemplazos)
        while (right - left + 1 - maxCount > k) {
            count[s.charAt(left) - 'A']--;  // Reduce la frecuencia del carácter en la posición left
            left++;  // Contrae la ventana moviendo left a la derecha
        }

        // Actualiza la longitud máxima de la subcadena válida
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
    }
}
