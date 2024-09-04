/*
78. Subsets

Problema:
Se quiere saber todos los posibles subsets de un arreglo sin contener subsets duplicados

Solucion:
Se usa Recursive Backtracking para hacerlo
*/




class Solution {
     public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Agrega una copia del subconjunto actual
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Incluye el elemento en el subconjunto actual
            backtrack(result, tempList, nums, i + 1); // Llama recursivamente para el siguiente elemento
            tempList.remove(tempList.size() - 1); // Excluye el último elemento para explorar el siguiente subconjunto
        }
    }
}
