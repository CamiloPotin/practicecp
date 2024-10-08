package LeetCode.ArraysAndStrings;
/*
Spiral Matrix 54 de leetcode

Problema: 
Se quiere recorrer una matriz en forma de espiral y guardar los elementos en un arreglo.

Solucion:
Se recorre cada parte de la matriz manejando los limites hasta encontrar todos los elementos


*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<>();

int i = 0, j = 0;
int n = matrix.length * matrix[0].length;
int elementos = 0;
int limiteDerechoArriba = matrix[0].length - 1;
int limiteDerechoAbajo = matrix.length - 1;
int limiteIzquierdoArriba = 0;
int limiteIzquierdoAbajo = 0;

while (elementos < n) {
    // Moverse de izquierda a derecha
    while (j <= limiteDerechoArriba && elementos < n) {
        result.add(matrix[i][j]);
        elementos++;
        j++;
    }
    j--;
    i++;
    limiteIzquierdoArriba++;
    
    // Moverse de arriba hacia abajo
    while (i <= limiteDerechoAbajo && elementos < n) {
        result.add(matrix[i][j]);
        elementos++;
        i++;
    }
    i--;
    j--;
    limiteDerechoArriba--;
    
    // Moverse de derecha a izquierda
    while (j >= limiteIzquierdoAbajo && elementos < n) {
        result.add(matrix[i][j]);
        elementos++;
        j--;
    }
    j++;
    i--;
    limiteDerechoAbajo--;
    
    // Moverse de abajo hacia arriba
    while (i >= limiteIzquierdoArriba && elementos < n) {
        result.add(matrix[i][j]);
        elementos++;
        i--;
    }
    i++;
    j++;
    limiteIzquierdoAbajo++;
}

return result;


    }
}
