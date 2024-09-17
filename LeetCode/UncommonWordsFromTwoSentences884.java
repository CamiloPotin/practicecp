/*
884. Uncommon Words from Two Sentences

Problema:
Se tiene dos oraciones y se quiere saber que palabras son las poco comunes, es decir,
que aparecen solo una vez en una oracion y no aparecen en la otra.

Solucion:
Se guardan todas las palabras en un map y se cuentan unicamente las que tengan frecuencia 1


*/


import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        int index = 0;
        Map<String, Integer> map = new HashMap<>();

        // Procesar la primera oración (s1)
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                String curr = s1.substring(index, i);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                index = i + 1;
            }
        }
        // Añadir la última palabra de s1
        String curr = s1.substring(index, s1.length());
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        // Reinicializar index para procesar la segunda oración (s2)
        index = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == ' ') {
                curr = s2.substring(index, i);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                index = i + 1;
            }
        }
        // Añadir la última palabra de s2
        curr = s2.substring(index, s2.length());
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        // Crear una lista para almacenar las palabras infrecuentes
        List<String> result = new ArrayList<>();

        // Filtrar palabras que solo aparezcan una vez
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        // Convertir la lista a un array de String
        return result.toArray(new String[0]);
    }
}
