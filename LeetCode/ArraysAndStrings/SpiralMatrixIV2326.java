/*
2326. Spiral Matrix IV

Problema: 
Se quiere completar una matriz en forma de espiral con los valores de una lista
en caso de que se vacie la lista se completa el resto con -1

Solucion:
Se usa el mismo enfoque que Spiral Matrix, usando limites y recorriendo en 4 direcciones.
*/


class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Inicialización de los límites
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        
        int[][] result = new int[m][n];
        
        // Inicialización de todos los valores a -1
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        
        ListNode current = head;
        int values = 0;
        int total = m * n;
        
        while (top <= bottom && left <= right && values < total) {
            // Rellenar la fila superior
            for (int j = left; j <= right; j++) {
                if (current != null) {
                    result[top][j] = current.val;
                    current = current.next;
                } else {
                    result[top][j] = -1;
                }
                values++;
            }
            top++;
            
            // Rellenar la columna derecha
            for (int i = top; i <= bottom; i++) {
                if (current != null) {
                    result[i][right] = current.val;
                    current = current.next;
                } else {
                    result[i][right] = -1;
                }
                values++;
            }
            right--;
            
            // Rellenar la fila inferior
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    if (current != null) {
                        result[bottom][j] = current.val;
                        current = current.next;
                    } else {
                        result[bottom][j] = -1;
                    }
                    values++;
                }
                bottom--;
            }
            
            // Rellenar la columna izquierda
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (current != null) {
                        result[i][left] = current.val;
                        current = current.next;
                    } else {
                        result[i][left] = -1;
                    }
                    values++;
                }
                left++;
            }
        }
        
        return result;
    }
}
