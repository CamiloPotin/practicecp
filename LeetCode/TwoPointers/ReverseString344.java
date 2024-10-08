package LeetCode.TwoPointers;/*
Reverse String 344 de leetcode

Problema:
Se quiere invertir un String

Solucion:
Se usa el enfoque de dos punteros y se va intercambiando los valores luego se modifican ambos punteros

*/


class Solution {
    public void reverseString(char[] s) {
        
     int left = 0 ;
     int right = s.length-1;

     while(left<right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;


     }
    }
}
