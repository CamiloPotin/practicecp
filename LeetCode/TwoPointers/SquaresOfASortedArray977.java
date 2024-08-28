package LeetCode.TwoPointers;

/*
Squares of a sorted array 977 de leetcode

Problema:
Se tiene un arreglo ordenado de numeros con numeros positivos y negativos. Se quiere calcular los cuadrados de los numeros
manteniendo el orden.

Solucion:
Se usa un enfoque de dos punteros comparando los cuadrados de left y right y agregando los valores al final del nuevo arreglo.


*/
class Solution {
    public int[] sortedSquares(int[] nums) {
         int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        // Indice para llenar el array de resultados desde el final
        int pos = n - 1;
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }
        
        return result;
        
    }
}
