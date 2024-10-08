package LeetCode.HashMapsAndSets;/*
Two Sums 1 de leetcode

Problema:
Se quiere saber los indices de dos numeros que sumados dan un target.

Solucion:
Se va guardando los numeros y se calcula el numero que falta restando el de posicion i y si existe devuelve los indices de ambos
Sino agrega el nuevo numero

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {

     Map<Integer,Integer> map = new HashMap<>();

     for(int i =  0 ; i < nums.length ; i++){
         int complement = target - nums[i];
            
            // Verificar si el complemento ya está en el HashMap
            if (map.containsKey(complement)) {
                // Retornar los índices de los dos números que suman al target
                return new int[]{map.get(complement), i};
            }
            
            // Agregar el número actual y su índice al HashMap
            map.put(nums[i], i);
     }
    return null;
    }
}
