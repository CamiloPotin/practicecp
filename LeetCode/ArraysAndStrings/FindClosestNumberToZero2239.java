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
        int head = Integer.MIN_VALUE, tail = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) 
                return nums[i];
            if(nums[i] < 0 && nums[i] > head) 
                head = nums[i];
            if(nums[i] > 0 && nums[i] < tail)
                tail = nums[i];
        }
        if(head == Integer.MIN_VALUE)
            return tail;
        else if(tail == Integer.MAX_VALUE)
            return head;
        head *= -1;
        if(head >= tail)
            return tail;
        return head * -1;
    }
}
