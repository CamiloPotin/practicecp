/*
77. Combinations

Problema:
Se quiere saber todas las combinaciones posibles de n numeros hasta k elementos no se tienen en cuenta las repetidas ( [1,2] si pero [2,1] no va)

Solucion:
Usando recursive backtrack se va revisando todas las combinaciones posibles y agregando
(copie y pegue lo que venia haciendo y le cambie una cosa y funciono)


*/


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), n, 1,k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int start, int k) {
         //System.out.println(tempList.toString()+" "+start);
        if(tempList.size() == k){
            result.add(new ArrayList<>(tempList)); // Agrega una copia del subconjunto actual
        }
        else {
        for (int i = start; i <= n; i++) {
           // System.out.println(i);
            tempList.add(i); // Incluye el elemento en el subconjunto actual
            backtrack(result, tempList, n, i + 1,k); // Llama recursivamente para el siguiente elemento
            tempList.remove(tempList.size() - 1); // Excluye el último elemento para explorar el siguiente subconjunto
        }
        }
    }
}
