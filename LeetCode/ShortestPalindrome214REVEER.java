/*
214. Shortest Palindrome

Problema:
Se quiere calcular cual es el palindondromo mas corto que se puede armar a partir de un String solo agregando caracteres al inicio de la cadena

Solucion:
Se usa el algoritmo de KMP
CHATGPT reveer

*/

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        String revS = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + revS;
        
        int[] kmp = getKMPTable(newStr);
        int maxPrefixLength = kmp[kmp.length - 1];
        
        String suffixToAdd = revS.substring(0, revS.length() - maxPrefixLength);
        
        return suffixToAdd + s;
    }
    
    private int[] getKMPTable(String s) {
        int n = s.length();
        int[] kmp = new int[n];
        int j = 0;
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = kmp[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            kmp[i] = j;
        }
        
        return kmp;
    }
}
