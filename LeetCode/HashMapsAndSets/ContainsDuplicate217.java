package LeetCode.HashMapsAndSets;/*
Contains duplicate 217 de leetcode

Problema:
Se quiere saber si un arreglo de numeros contiene duplicados

Solucion:
Se va guardando los numeros en un set y si ya contiene al numero esta duplicado
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> uniqueNum = new HashSet<>();

        for (int i : nums){
            if(!(uniqueNum.contains(i))){
                    uniqueNum.add(i);
            }
            else return true;

        }
        return false;
        
    }
}
