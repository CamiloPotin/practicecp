package LeetCode.ArraysAndStrings;

/*
IsSubsequence 392 de leetcode

Problema:
Se tiene dos Strings y se quiere saber si uno se encuentra en otro borrandole caracteres.
Por lo que el mismo se debe encontrar en orden dentro del otro.

Solucion:
Se recorre de forma secuencial el String subsequencia mientras se busca si coincide la letra en el principal

*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        
            int j = 0;
            int i = 0;
            while (i < s.length()) {
            // Buscar la siguiente coincidencia de s[i] en t
            while (j < t.length() && s.charAt(i) != t.charAt(j)) {
            j++;
            }
            // Si j ha llegado al final de t sin encontrar coincidencia
            if (j >= t.length()) return false;

            // Avanzar ambos índices si hay coincidencia
            i++;
            j++;
            }
            return true;

    }
}
