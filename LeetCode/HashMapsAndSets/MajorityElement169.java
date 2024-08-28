package LeetCode.HashMapsAndSets;/*
Majority Element 169 de leetcode

Problema:
Se quiere recorrer un arreglo y devolver el elemento que mas veces aparece 

Solucion:
Se usa el enfoque de contar la frecuencia del elemento y si vuelve a 0 se actualiza un nuevo candidato.



*/


class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int value = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            
            if(nums[i]==value) count++;
            else {
            count--;
            if(count==0){
                value = nums[i];
                count++;
            }
            }

        }
    return value;
    }
}
