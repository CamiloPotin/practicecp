/*
3042. Count Prefix and Suffix Pairs I

Problema:
Se quiere saber si una palabra de un Sting de palabras es sufijo y prefijo de otra palabra j del mismo String

Solucion:
Se compara para cada par de palabras que cumplen i < j si word[i] es prefijo y sufijo de word[j] y se va contando
la cantidad

*/

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length;i++){
            for(int j = i+1 ; j < words.length ; j++){
                   // System.out.println(words[i]+" "+ words[j]);
                    if(isPrefixAndSuffix(words[i],words[j]))
                    count++;
            }
        }
        return count;
    }

     public boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
