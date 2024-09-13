/*
1310. XOR Queries of a Subarray

Problema:
Se tiene un arreglo de numeros y un arreglo de queries con indices del arreglo.
Se quiere devolver un arreglo y en cada posicion i tener un xor entre los elementos el arreglo original en el rango queries[i][0], queries[i][1]

Solucion:
Se usa prefix sum pero en vez de suma se hace un xor
*/


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
          int[] prefixXOR = new int[arr.length + 1];  // Arreglo de suma acumulada

        int [] result = new int [queries.length];
        // Construir el arreglo de suma acumulada
        for (int i = 1; i <= arr.length; i++) {
             prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
             //System.out.println(i+" "+prefixXOR[i]);
        }

        for(int i = 0 ; i < queries.length ; i++){
            result[i] = prefixXOR[queries[i][1]+1] ^  prefixXOR[queries[i][0]];

        }
        return result;


    }
}
