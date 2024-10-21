/*
1593. Split a String Into the Max Number of Unique Substrings

Problema:
Se quiere calcular todos los posibles substrings unicos con los que se puede volveer a formar el string original

Solucion:
Se usa backtracking y se va guardando en un set los distintos substring y se agrega hasta encontrar todas las combinaciones posibles que sumadas del el string original
*/


class Solution {
    int res = 0;
    Set<String> set;

    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        backtracking(new StringBuilder(), s, 0);
        return res;
    }

    private void backtracking(StringBuilder result, String s, int start) {
        if (start == s.length()) {
            res = Math.max(res, set.size());
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (!set.contains(substring)) {
                set.add(substring);
                result.append(substring);
                backtracking(result, s, i + 1);
                result.setLength(result.length() - substring.length());
                set.remove(substring);
            }
        }
    }
}
