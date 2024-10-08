package LeetCode.ArraysAndStrings;

/*Merge String 1768 de Leetcode

Problema:
Se quiere crear un nuevo String a partir de dos Strings intercalando las letras del mismo

Solucion:
Se recorre agregando la letra de cada uno al nuevo String y cuando sale del bucle
se revisa si falta de alguno y se agrega al final

*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0,j=0;
        while(i<word1.length() && j<word2.length()){
              result.append(word1.charAt(i++));
              result.append(word2.charAt(j++));
             
             
            
        }
        if(i<word1.length())
            result.append(word1.substring(i));
        else if(j<word2.length())
                 result.append(word2.substring(j));
        return result.toString();
    }
}
