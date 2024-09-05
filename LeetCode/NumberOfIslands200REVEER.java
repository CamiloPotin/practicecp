/*
200. Number of Islands

Problema:
Se quiere saber el numero de islas que existen en una matriz de 1s y 0s
Se cuenta una isla cuando esta rodeada de 0s

Solucion:
Se usa dfs y se va recorriendo la matriz desde un punto en todas las direcciones marcando lo visitado en 0 
(chatgpt reveer)
*/


class Solution {
    public int numIslands(char[][] grid) {
     // Verificar si la matriz es válida
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslas = 0; // Contador de islas
        int filas = grid.length;
        int columnas = grid[0].length;

        // Recorrer la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Si encontramos tierra (1), iniciamos una DFS
                if (grid[i][j] == '1') {
                    numIslas++; // Encontramos una nueva isla
                    // Realizamos DFS para marcar todas las tierras conectadas
                    dfs(grid, i, j);
                }
            }
        }

        return numIslas;
    }

    // Método DFS para "sumergir" la isla
    private void dfs(char[][] grid, int i, int j) {
        // Comprobar los límites de la matriz y si la celda es agua ('0')
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Marcar la celda como visitada (convertirla en '0')
        grid[i][j] = '0';

        // Llamar recursivamente en las cuatro direcciones: arriba, abajo, izquierda, derecha
        dfs(grid, i - 1, j); // arriba
        dfs(grid, i + 1, j); // abajo
        dfs(grid, i, j - 1); // izquierda
        dfs(grid, i, j + 1); // derecha
    }    
    
}
