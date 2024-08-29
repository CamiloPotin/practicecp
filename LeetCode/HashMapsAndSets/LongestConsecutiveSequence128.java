package LeetCode.HashMapsAndSets;/*
Longest Consecutive Sequence 128 de leetcode

Problema:
Se quiere encontrar la secuencia consecutiva mas larga de un arreglo

Solucion:
Se guarda el arreglo completo en un set y se recorre el set buscando los elementos consecutivos y calculando el maximo
Solo se procesan los inicios de secuencias.

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i< nums.length ; i++) {
            set.add(nums[i]);

        }


     int longestStreak = 0;

        for (int num : set) {
            // Solo comienza una secuencia si 'num' es el inicio de una secuencia
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    streak += 1;
                }

                longestStreak = Math.max(longestStreak, streak);
            }
        }

        return longestStreak;

    }
}
