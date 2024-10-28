/*
2501. Longest Square Streak in an Array

Problema:
Se tiene un arreglo de numeros y se quiere calcular la racha mas larga de un subarreglo que contenga los cuadrados continuos
de numeros:
  - El tamñao de la subsequencia es >2
  - La subsequencia contiene la raiz cuadrada del numero como anterior, excepto el primero

Solucion:
Reveer

*/

class Solution {
    public int longestSquareStreak(int[] nums) {
       Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                mp.put(num, mp.get(sqrt) + 1);
                res = Math.max(res, mp.get(num));
            } else {
                mp.put(num, 1);
            }
        }
        return res;
    }
}
