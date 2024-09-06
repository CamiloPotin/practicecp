/*
62. Unique Paths

Problema:
Se quieren saber todos los caminos posibles de una matriz de nxm desde 0,0 hasta n-1,m-1 

Solucion:
reveer
*/


class Solution {
    public int uniquePaths(int m, int n) {
           int[][] dp = new int[m][n];
        // Inicializamos la primera fila y la primera columna con 1, ya que solo hay una forma de llegar a esas celdas
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Rellenamos la tabla dp con la suma de las celdas anteriores (arriba y a la izquierda)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // El resultado está en la esquina inferior derecha de la tabla
        return dp[m - 1][n - 1];
    }
}
