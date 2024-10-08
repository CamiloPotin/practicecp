package LeetCode.ArraysAndStrings;

/*
Rotate image 48 de leetcode

Problema:
Se tiene una matriz de nxn y se quiere rotar los valores 90°

Solucion:
Se resuelve realizando dos operaciones sobre la matriz original.
  - Primero se hace una Transposición 
  - Se invierten de lugar las filas 

*/
class Solution {
    public void rotate(int[][] matrix) {


        for (int i = 0 ; i < matrix.length ; i++){
            for (int j = i ; j < matrix.length ; j++){
                int aux = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = aux;
            }
        }
        
    

          for (int i = 0 ; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix.length/2 ; j++){
                int aux =  matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
                matrix[i][j] = aux;
            }
        }
}
}
