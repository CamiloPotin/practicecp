package LeetCode.BinarySearch;/*
Search in rotated sorted array 33 de leetcode

Problema:
Se quiere buscar un numero en un arreglo ordenado rotado de 1 a k posiciones

Solucion:
Usando busqueda binaria primero se hace una comparacion si es mayor o menor que el target el medio
y a partir de eso se commparan las dos mitades para ver que puntero se actualiza



*/


class Solution {
    public int search(int[] nums, int target) {
 int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Si encontramos el target, devolvemos su índice
        if (nums[mid] == target) {
            return mid;
        }

        // Determinar si la parte izquierda está ordenada
        if (nums[left] <= nums[mid]) {
            // Si el target está en la mitad izquierda
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // De lo contrario, la parte derecha debe estar ordenada
        else {
            // Si el target está en la mitad derecha
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    // Si no encontramos el target, devolvemos -1
    return -1;

    }
}
