/*
39. Combination Sum

Problema:
Se quiere saber todas las posibles combinaciones que sumadas dan un target


Solucion:
Usando reverse backtrack pero teniendo en cuenta que se puede repetir el mismo numero y se agrega la suma como parametro
(Es modificar dos cosas en el algoritmo original de reverse backtrack)


*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0,0,target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start,int sum, int target) {
        if(sum==target){
            result.add(new ArrayList<>(tempList)); // Agrega una copia del subconjunto actual
        }
        else if(sum<target){
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // Incluye el elemento en el subconjunto actual
                backtrack(result, tempList, nums, i,sum+nums[i],target); // Llama recursivamente para el siguiente elemento
                tempList.remove(tempList.size() - 1); // Excluye el último elemento para explorar el siguiente subconjunto
            }
        }
    }
}
