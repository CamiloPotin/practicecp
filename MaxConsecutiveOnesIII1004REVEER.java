/*
Max Consecutive Ones III 1004 de leetcode

Problema:
Se tiene un arreglo de 1s y 0s y se quiere saber cual es la cantidad maxima de 1s
consecutivos que se pueden conseguir al ir cambiar k 0s

Solucion
Se usa ventana deslizante contando los 0s se mueve right y se encuentra un 0 se suma
en caso de que la cuenta sea mayor a k se mueve left en consecuencia hasta que vuelva a ser menor
y asi se va formando la ventana deslizante con la mayor cantidad de 1s consecutivos posibles

*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        
          int left = 0, right = 0;
    int maxLength = 0;
    int countZeros = 0;

    while (right < nums.length) {
        // Expandir la ventana
        if (nums[right] == 0) {
            countZeros++;
        }

        // Si countZeros es mayor que k, contraer la ventana desde la izquierda
        while (countZeros > k) {
            if (nums[left] == 0) {
                countZeros--;
            }
            left++;
        }

        // Actualizar el máximo
        maxLength = Math.max(maxLength, right - left + 1);

        // Mover el puntero derecho hacia adelante
        right++;
    }

    return maxLength;

    }
}
