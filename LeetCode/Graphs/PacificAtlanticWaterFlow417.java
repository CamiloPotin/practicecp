/*
417. Pacific Atlantic Water Flow

Problema:
Se quiere saber cuales son los recorredos del flujo del agua que llega al oceano pacifico y atlantico en una
matriz de alturas donde el agua fluye de una celda de mayor altura a otra de menor.
El oceano pacifico se encuentra en los bodes izquierdo y superior y el pacifico en el otro.


SOlucion:
Se usa dfs
(chatgpt reveer)

*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
           List<List<Integer>> resultado = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return resultado;
        }

        int filas = heights.length;
        int columnas = heights[0].length;

        // Crear matrices para verificar qué celdas pueden llegar a cada océano
        boolean[][] pacifico = new boolean[filas][columnas];
        boolean[][] atlantico = new boolean[filas][columnas];

        // Realizar DFS desde las celdas del borde que tocan el Océano Pacífico
        for (int i = 0; i < filas; i++) {
            dfs(heights, pacifico, i, 0); // Primera columna (Pacífico)
            dfs(heights, atlantico, i, columnas - 1); // Última columna (Atlántico)
        }

        // Realizar DFS desde las celdas del borde que tocan el Océano Atlántico
        for (int j = 0; j < columnas; j++) {
            dfs(heights, pacifico, 0, j); // Primera fila (Pacífico)
            dfs(heights, atlantico, filas - 1, j); // Última fila (Atlántico)
        }

        // Recorrer la matriz y encontrar las celdas que pueden llegar a ambos océanos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (pacifico[i][j] && atlantico[i][j]) {
                    resultado.add(Arrays.asList(i, j));
                }
            }
        }

        return resultado;
    }

    private void dfs(int[][] heights, boolean[][] visitado, int i, int j) {
        int filas = heights.length;
        int columnas = heights[0].length;
        visitado[i][j] = true;

        // Movimientos posibles: arriba, abajo, izquierda, derecha
        int[] direccionesX = {-1, 1, 0, 0};
        int[] direccionesY = {0, 0, -1, 1};

        // Explorar las celdas vecinas
        for (int d = 0; d < 4; d++) {
            int nuevoX = i + direccionesX[d];
            int nuevoY = j + direccionesY[d];

            // Verificar si el vecino está dentro de los límites y si no ha sido visitado
            if (nuevoX >= 0 && nuevoX < filas && nuevoY >= 0 && nuevoY < columnas
                && !visitado[nuevoX][nuevoY]
                && heights[nuevoX][nuevoY] >= heights[i][j]) {
                dfs(heights, visitado, nuevoX, nuevoY);
            }
        }
    }
}
