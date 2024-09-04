/*
22. Generate Parentheses

Problema:
Se quiere saber la cantidad de combinaciones de parentesis validos que puede contener un String de n longitud

Solucion:
Se usa recursive backtrack donde se lleva la cuenta de los parentesis abiertos y cerrados
*/


class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
