package LeetCode.TwoPointers;/*
Two sum ii 167 de leetcode

Problema:
Se tiene un arreglo ordenado y se quiere devolver los dos indices de los numeros que suman un target.

Solucion:
Se usa el enfoque de dos punteros en el que se hace la suma entre los extremos y en base al resultado:
  - Si es igual al target devuelve los indices
  - Si es menor aumenta left
  . Si es mayor decrementa right
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        

        int left = 0 ;
        int right = numbers.length -1 ;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum== target)
                return new int[]{left+1,right+1};
            else if(sum<target) left++;
                 else right--;


        }
           return new int[] {-1, -1}; 
    }
}
