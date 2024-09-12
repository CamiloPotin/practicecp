/*
209. Minimum Size Subarray Sum

Problema:
Se quiere calcular el minimo subarreglo que cumple que la suma de sus valores da mayor o igual que target

Solucion:
Se usa Sliding window, se recorre hasta encontrar una suma que de y despues se va achicando la misma buscando el minimo
*/



class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;  // Para almacenar el tamaño mínimo del subarray
        int sum = 0;  // Para almacenar la suma de la ventana actual
        int left = 0;  // El índice izquierdo de la ventana

        // Recorrer el array con el índice derecho de la ventana
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];  // Agregar el elemento a la ventana actual
            
            // Mientras la suma sea mayor o igual al objetivo, ajusta la ventana
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);  // Actualiza el tamaño mínimo
                sum -= nums[left];  // Resta el elemento en el índice izquierdo
                left++;  // Mueve el índice izquierdo hacia la derecha
            }
        }

        // Si minLen no se ha actualizado, significa que no hay subarray válido
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
