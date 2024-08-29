package LeetCode.ArraysAndStrings;/*
Find Closest Number 2239 de Leetcode

Problema:
Se quiere encontrar el numero mas cercano a 0 dentro de un arreglo.
En caso de encontrar dos numeros cercanos se queda con el mas grande.

Solucion
Se recorre buscando el minimo y en caso de tener un minimo igual se queda con el positivo


*/

class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int i : nums){

            if(Math.abs(i)<Math.abs(min))
                min= i;
            else if(Math.abs(i)==Math.abs(min))
                min = i > min ? i : min;

        }

        return min;
    }
}
