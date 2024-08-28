package LeetCode.BinarySearch;

/*
Search a 2D matrix 74 de leetcode

Problema:
Se quiere realizar una busqueda en una matriz

Solucion:
Hay que manejar la matriz como un solo arreglo y usar busqueda binaria

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
      int i = matrix.length;           // Número de filas
    int j = matrix[0].length;        // Número de columnas
    int left = 0;
    int right = i * j - 1;           // Número total de elementos menos 1

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Calcular los índices de fila y columna
        int midRow = mid / j;
        int midCol = mid % j;

        // Mostrar la depuración
        //System.out.println(mid + " " + matrix[midRow][midCol] + " " + left + " " + right);

        if (matrix[midRow][midCol] == target) {
            return true;
        } else if (matrix[midRow][midCol] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return false;
    }
}
