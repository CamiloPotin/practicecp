/*
88. Merge Sorted Array

Problema:
Se quiere ordenar dos ARREGLOS y devolver un unico arreglo ordenado, uno m es del tamaño m+n y otro de tamaño n. 
Ambos contienen valores ordenados y se quiere devolver el arreglo nuevo en m

Solucion:
Se va agregando al final del arreglo 1 y se comparan los ultimos valores entre ambos



*/



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
           int p1 = m - 1;  // Último índice de los elementos válidos en nums1
        int p2 = n - 1;  // Último índice de los elementos en nums2
        int p = m + n - 1;  // Último índice de nums1

        // Compara y coloca los elementos en el índice final de nums1
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Si quedan elementos en nums2, cópialos a nums1
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
