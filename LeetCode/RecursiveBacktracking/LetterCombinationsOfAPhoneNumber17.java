/*
17. Letter Combinations of a Phone Number

Problema:
Se quiere saber todas las combinaciones posibles para un numero de telefono dado.
Se tiene un numero y cada digito es una letra siguiendo el patron de un telefono viejo 
2: a, b, c
3: d, e, f
4: g, h, i
5: j, k, l
6: m, n, o
7: p, q, r, s
8: t, u, v
9: w, x, y, z

Solucion:
Se modifica el algoritmo de recursive backtrack para que recorra el String y pruebe las combinaciones
por cada letra 

*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        backtrack(result, new StringBuilder(), digits, 0, map);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder tempList, String digits, int start, Map<Character, Character[]> map) {
        if (tempList.length() == digits.length()) {
            result.add(tempList.toString()); // Agrega la combinación completa a los resultados
        } else {
            for (int i = start; i < digits.length(); i++) {
                char ch = digits.charAt(i);
                Character[] letters = map.get(ch);
                if (letters != null) {
                    for (Character c : letters) {
                        tempList.append(c); // Añade el carácter actual
                        backtrack(result, tempList, digits, i + 1, map); // Llama recursivamente para el siguiente dígito
                        tempList.deleteCharAt(tempList.length() - 1); // Realiza el backtracking
                    }
                }
            }
        }
    }
}
