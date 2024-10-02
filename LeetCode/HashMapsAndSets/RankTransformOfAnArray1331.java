/*
1331. Rank Transform of an Array

Problema:
Se quiere reemplazar los valores de un arreglo por su valor en un ranking ordenado arrancando de 1

Solucion:
Se usa un hash y un arreglo copia del original, se va guardando en cada valor del hash su posicion en el ranking y
por ultimo se recorre el original cambiando su valor por su posicion
*/


class Solution {
    public int[] arrayRankTransform(int[] arr) {
            if (arr.length == 0) {
            return new int[0]; // Caso borde: si el arreglo está vacío
        }
        
        // Crear un mapa para almacenar los rangos
        Map<Integer, Integer> map = new HashMap<>();
        
        // Crear una copia del arreglo original y ordenarlo
        int[] result = arr.clone();
        Arrays.sort(result);
        
        // Asignar rangos a cada número
        int rank = 1;
        for (int i = 0; i < result.length; i++) {
            if (!map.containsKey(result[i])) { // Solo asignar rango si el número aún no tiene uno
                map.put(result[i], rank);
                rank++;
            }
        }
        
        // Reemplazar los valores en el arreglo original con sus rangos
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}
