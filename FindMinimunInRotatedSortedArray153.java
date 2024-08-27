/*
Find Minimun in rotated Sorted array 153 de leetcode

Problema:
Se tiene un arreglo ordenado que fue rotado de 1 a n veces y se queire saber el minimo

Solucion:
Usando binary search se busca el minimo

*/


class Solution {
    public int findMin(int[] nums) {
        int left = 0;
    int right = nums.length - 1;

    // Caso especial: si el arreglo está ordenado y no rotado
    if (nums[left] <= nums[right]) {
        return nums[left];
    }

    while (left < right) {
        int mid = left + (right - left) / 2;
        
        // Mostrar información para depuración (opcional)
         //System.out.println(left + " " + mid + " " + right);

        if (nums[mid] > nums[right]) {
            // El mínimo está en la parte derecha de mid
            left = mid + 1;
        } else {
            // El mínimo está en la parte izquierda de mid o es mid
            right = mid ;
        }
    }
    
    // Después del ciclo, left es el índice del valor mínimo
    return nums[left];
    }
}
