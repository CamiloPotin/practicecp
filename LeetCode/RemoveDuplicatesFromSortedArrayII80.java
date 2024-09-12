/*
80. Remove Duplicates from Sorted Array II

Problema:
Se quiere remover los duplicados de un arreglo ordenado sin usar espacio adicional, trabajando sobre el mismo arreglo dejando un arreglo resultante
con como maximo 2 de cada elemento 

Solucion
Se recorre el arreglo y si se cuentan mas de dos 2 elementos se intercambia con una posicion inicial
*/



class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int insertPosition = 1;  // Posición donde se insertarán los elementos únicos
        int count = 1;  // Contador para el número de apariciones del valor actual

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;  // Reiniciar el contador si el número cambia
            }

            // Solo permitimos hasta dos apariciones del mismo número
            if (count <= 2) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        return insertPosition;  // El nuevo tamaño del array sin duplicados
    }
}
