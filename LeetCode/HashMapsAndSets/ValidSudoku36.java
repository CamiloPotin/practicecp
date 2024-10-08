package LeetCode.HashMapsAndSets;/*
Valid sudoku 36 de leetcode

Problema:
Se quiere saber si una matriz de 9x9 es un sudoku es valido para ello tiene que cumplir:
  -Las filas tienen una unica vez los valores de 1 a 9
  - La columnas tienen una unica vez los valores de 1 a 9
  - Las distintas cajas de 3x3 tienen una unica vez los valored de 1 a 9

Solucion:
Se recorre la matriz tres veces viendo si se cumple cada una de estas condiciones por separado.


*/


class Solution {
    public boolean isValidSudoku(char[][] board) {
        


        for(int i = 0 ; i < 9 ; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                 if(board[i][j]!='.'){
                    int num = board[i][j]-'0';
                    if(set.contains(num))
                        return false;
                    else set.add(num);
                    }
            }
        }

        for(int i = 0 ; i < 9 ; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                 if(board[j][i]!='.'){
                    int num = board[j][i]-'0';
                    if(set.contains(num))
                        return false;
                    else set.add(num);
                    }
            }
        }

        // Validate 3x3 Sub-grids
        int[][] starts = {{0, 0}, {0, 3}, {0, 6},
                          {3, 0}, {3, 3}, {3, 6},
                          {6, 0}, {6, 3}, {6, 6}};
        
        for (int[] start : starts) {
            Set<Integer> set = new HashSet<>();
            for (int i = start[0]; i < start[0] + 3; i++) {
                for (int j = start[1]; j < start[1] + 3; j++) {
                     if(board[j][i]!='.'){
                            int num = board[j][i]-'0';
                            if(set.contains(num))
                                return false;
                            else set.add(num);
                    }
                }
            }
        }

        return true;



    }
}
