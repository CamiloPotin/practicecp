package LeetCode.ArraysAndStrings;/*
Longest Common Prefix 14 de Leetcode

Problema:
Se tiene un arreglo de Strings y se quiere encontrar el prefijo en comun mas largo

Solucion:
Se ordena el String y se comparan el de mayor longitud con el de menor y se devuelve l prefijo que tengan en comun 



*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String left= strs[0];
        String right= strs[strs.length-1];
        int i=0;
        while(i<left.length()){
            if(left.charAt(i)==right.charAt(i)){
                i++;
            } else break;
        }
        return left.substring(0,i);
        
    }
}
