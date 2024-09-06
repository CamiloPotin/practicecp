/*
746. Min Cost Climbing Stairs

Problema:
Se quiere calcular el costo minimo de subir una escalera de n escalones con un costo cost[i] 
se quiere saber cual es el costo minimo desde cualquier escalon hasta la cima

Solucion:
Se usa la solucion iterativa de fibonacci sumando los costos hasta el final

*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];  // dp[i] es el costo mínimo para llegar al escalón i

        // Inicializamos los dos primeros valores de dp
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Rellenamos dp desde el tercer escalón en adelante
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // El costo mínimo para llegar al último escalón es el mínimo entre dp[n-1] y dp[n-2]
        return Math.min(dp[n - 1], dp[n - 2]);
         }
 }
