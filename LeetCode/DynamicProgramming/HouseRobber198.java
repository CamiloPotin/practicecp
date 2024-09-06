/*
198. House Robber

Problema:
Se quiere saber cual es el maximo posible de robos a casas (no se puede robar dos casas seguidas) se tiene un arreglo con el dinero en cada casa

Solucion:
Se usa el mismo algoritmo que fibonacci pero se va sumando el maximo y se devuelve el maximo final
*/


class Solution {
    public int rob(int[] nums) {
        if(nums.length== 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n + 1];  // dp[i] es el costo mínimo para llegar al escalón i

        // Inicializamos los dos primeros valores de dp
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Rellenamos dp desde el tercer escalón en adelante
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        // El costo mínimo para llegar al último escalón es el mínimo entre dp[n-1] y dp[n-2]
         return dp[n - 1];
         }


    }
