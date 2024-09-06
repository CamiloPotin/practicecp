/*
70. Climbing Stairs

Problema:
Se quiere saber de cuantas maneras es posible subir una escalera de n altura dando 1 o 2 pasos

Solucion:
Se usa la solucion iterativa de fibonacci pero cambiando el inicio
Se va guardando en el arreglo la cantidad de posibilidades para cada n


*/


class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
 
