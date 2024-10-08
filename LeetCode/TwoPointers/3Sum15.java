package LeetCode.TwoPointers;
/*
3Sum 15 de leetcode

Problema:
Se tiene un arreglo de numeros negativos y positivos y se quieren devolver los triples que sumados den 0

Solucion
Se recorre el arreglo y por cada elemento se busca hacia la derecha usando el enfoque de dos punteros los otros dos valores si existen para formar
el triplet

*/


import java.util.*;

 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultado = new ArrayList<>();
        Arrays.sort(nums); // Ordenar el array
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Saltar valores duplicados para el primer elemento del triplete
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int izquierda = i + 1;
            int derecha = nums.length - 1;
            
            while (izquierda < derecha) {
                int suma = nums[i] + nums[izquierda] + nums[derecha];
                
                if (suma == 0) {
                    resultado.add(Arrays.asList(nums[i], nums[izquierda], nums[derecha]));
                    
                    // Saltar duplicados para el segundo elemento
                    while (izquierda < derecha && nums[izquierda] == nums[izquierda + 1]) izquierda++;
                    // Saltar duplicados para el tercer elemento
                    while (izquierda < derecha && nums[derecha] == nums[derecha - 1]) derecha--;
                    
                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }
        
        return resultado;
    }
}
