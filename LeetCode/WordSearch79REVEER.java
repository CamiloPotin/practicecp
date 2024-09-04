/*
79. Word Search

Problema:
Se quiere buscar una palabra especifica en una matriz de chars. Las letras se tienen que encontrar en orden y adyacentes entre si ya sea horizontal o vertical

Solucion:
Se usa recursive backtrack 

(Chatgpt repasar)
*/


class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Marca la celda como visitada

        boolean found = backtrack(board, word, row - 1, col, index + 1)
                || backtrack(board, word, row + 1, col, index + 1)
                || backtrack(board, word, row, col - 1, index + 1)
                || backtrack(board, word, row, col + 1, index + 1);

        board[row][col] = temp; // Desmarca la celda, restaurando su valor original

        return found;
    }
}
