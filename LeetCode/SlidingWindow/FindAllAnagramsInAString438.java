/*
438. Find All Anagrams in a String

Este problema no esta en los de la pagina guia

Problema:
Se quiere encontrar los indices de todos los anagramas de p que se encuentren en s

Solucion:
Se usa la ventana deslizante y se cuenta la frecuencia de caracteres en caso de que coincidan las frecuencias se agrega al arreglo


*/



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
          int n1 = p.length();
        int n2 = s.length();
        List<Integer> result = new ArrayList<>();
        if (n1 > n2) return result;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        // Inicializar contadores para s1 y la primera ventana de s2
        for (int i = 0; i < n1; i++) {
            s1Counts[p.charAt(i) - 'a']++;
            s2Counts[s.charAt(i) - 'a']++;
        }

        // Verificar la primera ventana
        if (Arrays.equals(s1Counts, s2Counts)) {
            result.add(0);
        }

        // Deslizar la ventana sobre s2
        for (int i = n1; i < n2; i++) {
            s2Counts[s.charAt(i) - 'a']++; // Añadir nuevo carácter a la ventana
            s2Counts[s.charAt(i - n1) - 'a']--; // Eliminar carácter que sale de la ventana
            
            // Verificar si la ventana actual es un anagrama
            if (Arrays.equals(s1Counts, s2Counts)) {
                result.add(i - n1 + 1);
            }
        }

        return result;
    }
}
