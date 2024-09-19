/*
290. Word Pattern

Problema:
Se quiere saber si un patron pertenece a un string de palabras, se cumple si:
  - Cada letra del patron se mapea unicamente a una palabra del String
  - Cada palabra unica tiene exactamente una letra del patron
  - No hay dos letras que se mapeen a la misma palabra ni dos palabras a la misma letra

Solucion:
Se guarda en un hashmap la letra con la palabra y se consulta si existe por cada palabra y letra y sino se agrega

*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.trim().split("\\s+");
        
        if (pattern.length() != words.length) {
            return false; // Si no tienen la misma longitud, no puede ser una coincidencia.
        }

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(pChar)) {
                // Verificamos si el carácter mapeado coincide con la palabra actual
                if (!map.get(pChar).equals(word)) {
                    return false;
                }
            } else {
                // Verificamos si la palabra ya está mapeada a otro carácter
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(pChar, word); // Mapeamos el carácter a la palabra
            }
        }

        return true;
    }
}
