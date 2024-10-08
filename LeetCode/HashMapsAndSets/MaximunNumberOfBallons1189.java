package LeetCode.HashMapsAndSets;/*
Maximun number of ballons 1189 de leetcode

Problema:
Se quiere contar cuantas veces aparece la palabra "balloon" en un texto

Solucion:
Se cuentan todos los caracteres y dsps se devuelve el minimo de los caracteres que forman la palabra

OBS: Es mas lento pq usa un hashmap

*/

class Solution {
    public int maxNumberOfBalloons(String text) {
         // Paso 1: Contar las letras en text
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
        }

        // Paso 2: Calcular cuántas veces podemos formar "balloon"
        // La palabra "balloon" tiene: b:1, a:1, l:2, o:2, n:1
        int countB = letterCount.getOrDefault('b', 0);
        int countA = letterCount.getOrDefault('a', 0);
        int countL = letterCount.getOrDefault('l', 0) / 2; // "l" aparece dos veces en "balloon"
        int countO = letterCount.getOrDefault('o', 0) / 2; // "o" aparece dos veces en "balloon"
        int countN = letterCount.getOrDefault('n', 0);

        // La cantidad máxima de veces que podemos formar "balloon"
        return Math.min(Math.min(countB, countA), Math.min(countL, Math.min(countO, countN)));
   
    }
}
