/*
2401. Longest Nice Subarray

Problema:
Se quiere calcular la longitud del subarreglo mas largo que cumple que un AND entre todos los elementos diferentes es 0

Solucion:
Usa ventana deslizante calculando el acumulado de bits, ya que a lo mucho hay una longitud de 30 bits posibles usados entonces se van acumulando los que se encuentran
y en caso de encontrar uno repetido se reinicia la cuenta.
*/


class Solution {
    public int longestNiceSubarray(int[] nums) {
         int left = 0; 
        int right = 0;
        int max = 0;
        int currentBitwise = 0;  // Variable para almacenar la operación AND acumulada

        // Usamos el puntero "right" para explorar todos los elementos del arreglo
        while (right < nums.length) {
            // Si la operación AND acumulada con el nuevo número en nums[right] es 0
            if ((currentBitwise & nums[right]) == 0) {
                // Realizamos la operación AND entre el número actual y nums[right]
                currentBitwise |= nums[right];
                // Incrementamos la longitud de la subcadena válida
                max = Math.max(max, right - left + 1);
                // Movemos el puntero derecho hacia la derecha
                right++;
            } else {
                // Si hay un conflicto, movemos el puntero izquierdo hacia la derecha
                currentBitwise ^= nums[left];  // Eliminamos el efecto de nums[left] en la operación AND
                left++;
            }
        }
        return max;
    }
   
}
