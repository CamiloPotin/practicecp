/*
567. Permutation in String

Problema:
Se quiere encontrar si un String s2 contiene una permutacion de s1 

Solucion:
Se usa ventana deslizante y se va contando las frecuencias, se cuenta las frecuencias iniciales de ambos en la longitud de s1
se hace una primera comparacion y dsps se va deslizando la ventana y contando. En caso de encontrar que tengan la misma frecuencia de letras ambos
devuelve true


*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Counts, s2Counts)) return true;

        for (int i = n1; i < n2; i++) {
            s2Counts[s2.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i - n1) - 'a']--;
            if (Arrays.equals(s1Counts, s2Counts)) return true;
        }

        return false;
    }
}
