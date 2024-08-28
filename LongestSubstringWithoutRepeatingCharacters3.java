/*
Longest Substring Without Repeating Characters 3

Problema:
Se quiere saber el substring mas largo de un String sin repetir caractres

Solucion:
Es una mezcla entre usar un Map y usar una ventana deslizante.
Se va agregando caracteres hasta encontrar uno repetido y cuando se encuentra 
se calcula el maximo entre el actual y la longitud del substring encontrado luego se actualiza
left con el nuevo valor del indice

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
        char ch = s.charAt(right);

        if (map.containsKey(ch)) {
            left = Math.max(left, map.get(ch) + 1);
         }

        max = Math.max(max, right - left + 1);
        map.put(ch, right);
        right++;
        
        }

        return max;
    }
}
