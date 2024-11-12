/*
2070. Most Beautiful Item for Each Query

Problema:
Se quiere saber cual es el item con mayor belleza de un arreglo de items[price][belleza] que tenga la belleza maxima y un precio menor al de 
un arreglo de queries.

Solucion:
Primero se hace un arreglo con bellezas maximas en cada posicion.
Luego se recorre la lista de items buscando si esta el precio de la querie 
y si lo encuentra actualiza el valor con la belleza maxima para ese precio.


*/

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Preprocesamos un arreglo con el máximo valor de belleza acumulado hasta cada precio.
        int[] maxBeauty = new int[items.length];
        maxBeauty[0] = items[0][1];  // La belleza del primer item es la máxima al principio
        
        for (int i = 1; i < items.length; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        
        // Para cada consulta, realizamos una búsqueda binaria para encontrar el valor máximo de belleza
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            
            // Búsqueda binaria para encontrar el índice del item con el precio más cercano y <= query
            int left = 0, right = items.length - 1;
            int bestBeauty = 0;  // Si no hay ningún item con precio <= query, devolvemos belleza 0
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (items[mid][0] <= query) {
                    // Si el precio en items[mid] es menor o igual a la consulta,
                    // guardamos la belleza máxima hasta ese punto.
                    bestBeauty = maxBeauty[mid];
                    left = mid + 1;  // Buscamos en el lado derecho
                } else {
                    right = mid - 1;  // Buscamos en el lado izquierdo
                }
            }
            
            // Guardamos el resultado de esta consulta
            result[i] = bestBeauty;
        }
        
        return result;
    }
}
