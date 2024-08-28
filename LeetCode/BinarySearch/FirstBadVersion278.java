package LeetCode.BinarySearch;/*
First Bad Version 278 de leetcode

Problema:
Se quiere encontrar cual es la primer mala version de un sistema
Se tiene una funcion que devuelve si es o no una mala version

Solucion:
Se usa Binary search evaluando si es o no una mala version
y devuelve left
*/



/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
          int left = 1;
    int right = n;
    
    while (left <= right) {
        int mid = left + (right - left) / 2; // Para evitar desbordamiento
        
        if (!isBadVersion(mid)) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return left;  // `left` será la primera versión mala

    }
}
