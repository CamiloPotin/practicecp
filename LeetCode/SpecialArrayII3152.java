/*
3152. Special Array II

Problema:
Se quiere calcular si un arreglo contiene pares de numeros que cumplen que son uno par y otro impar en un rango dado por un arreglo de queries

Solucion:
Se realiza prefix sum en la que se va acumulando los que no cumplen y luego se hace una diferencia para ver si cumplen
*/


class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
     int[] prefix = new int[nums.length+1];
     boolean[] result  = new boolean[queries.length];
     prefix[0] = 0;
    
     for(int i = 1 ;  i < prefix.length-1; i ++){
        prefix[i] = (nums[i] % 2 == nums[i - 1] % 2) ?  prefix[i - 1] + 1 : prefix[i - 1];
        //System.out.println(prefix[i]);

     }
     for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            result[i] = prefix[end] - prefix[start] == 0;
        }

        return result;
    }
}
