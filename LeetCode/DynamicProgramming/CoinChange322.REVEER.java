/*
322. Coin Change

Problema:
Se quiere saber cual es el minimo de monedas necesarias para conseguir un monto x usando las monedas de un arreglo

Solucion:
Se usa programacion dinamica

chatgpt reveer

*/


class Solution {
    public int coinChange(int[] coins, int amount) {
          // Definir dp y llenarlo con un valor máximo
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // La cantidad 0 se puede formar con 0 monedas
        dp[0] = 0;
        
        // Calcular el mínimo número de monedas para cada cantidad
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // Si no fue posible formar la cantidad, devolver -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
