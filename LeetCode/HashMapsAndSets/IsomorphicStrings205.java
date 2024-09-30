/*
205. Isomorphic Strings

Problema:
Se quiere saber si una palabra es isomorfica. Si se puede crear otra palabra a partir de mapear un caracter a otro manteniendo el orden

Solucion:
Se mapea caracteres y si ya existe mapeado a otro caracter devuelve falso

*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Verifica si ch1 ya está mapeado
            if (!map.containsKey(ch1)) {
                // Si ch2 ya está asociado a otro carácter, no es isomórfico
                if (map.containsValue(ch2)) {
                    return false;
                }
                map.put(ch1, ch2); // Asocia ch1 con ch2
            } else if (!map.get(ch1).equals(ch2)) {
                return false; // Si ya está mapeado, verifica que coincida
            }
        }
        return true;
    }
}
