/*
53. Maximum Subarray

Problema.
Se quiere calcular el subarray con la suma maxima de un arreglo

Solucion:
Se utiliza el algoitmo de Kadane para el calculo

*/


class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide si incluir el número actual en la subarray o empezar de nuevo
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Actualiza el máximo encontrado
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
