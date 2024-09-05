/*
695. Max Area of Island

Problema:
Se quiere saber el area maxima de una isla representada por una matriz de 1s y 0s (se suman los 1s de la isla)
Una isla esta rodeada por 0s

Solucion:
Se aplica la solucion de num de islas 200 pero retornan un int el dfs



*/



class Solution {
    public int maxAreaOfIsland(int[][] grid) {
     if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslas = 0; // Contador de islas
        int filas = grid.length;
        int columnas = grid[0].length;

        // Recorrer la matriz
        int max = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Si encontramos tierra (1), iniciamos una DFS
                if (grid[i][j] == 1) {
                   
                   int act =  dfs(grid, i, j);
                    if(act>max)
                        max=act;
                }
            }
        }

        return max;
    }

    // Método DFS para "sumergir" la isla
    private int dfs(int[][] grid, int i, int j) {
        // Comprobar los límites de la matriz y si la celda es agua ('0')
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Marcar la celda como visitada (convertirla en '0')
        grid[i][j] = 0;

        // Llamar recursivamente en las cuatro direcciones: arriba, abajo, izquierda, derecha
        return 1+dfs(grid, i - 1, j)+dfs(grid, i + 1, j)+dfs(grid, i, j - 1)+dfs(grid, i, j + 1);// arriba
        
        // derecha
    }    
    
}
