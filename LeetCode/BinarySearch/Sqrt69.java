/*
69. Sqrt(x)

Problema:
Se quiere calcular la raiz cuadrada sin usar la operacion matematica

Solucion:
Se usa busqueda binaria para encontrar el valor

*/

class Solution {
    public int mySqrt(int x) {
     if (x < 2) return x; // Handle 0 and 1
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Use long to avoid overflow
            if (square == x) {
                return mid; // Exact square root
            } else if (square < x) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }
        return right; // The integer part of the square root
    }
}
