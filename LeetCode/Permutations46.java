/*
46. Permutations

Problema:
Se quieren saber todas las permutaciones posibles de un array

Solucion:
Se usa reverse backtracking y se va marcando los elementos que fueron usados y 

*/




class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    
private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
        result.add(new ArrayList<>(tempList)); // Agrega la permutación completa a los resultados
    } else {
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Salta los elementos que ya han sido utilizados
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, used); // Llama recursivamente para el siguiente elemento
            used[i] = false;
            tempList.remove(tempList.size() - 1); // Realiza el backtracking
        }
    }
}
}
