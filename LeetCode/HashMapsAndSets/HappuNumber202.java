/*
202. Happy Number

Problema:
Se quiere saber si un numero es un happy number. Para ello tiene que cumplir:
  -Starting with any positive integer, replace the number by the sum of the squares of its digits.
  -Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  -Those numbers for which this process ends in 1 are happy.

Solucion:
Se va guardando en un set los numeros sumados y cuando se encuentra nuevamente un numero en el set devuelve falso
caso contrario se agrega y continua hasta encontrar un 1
*/

class Solution {
    public boolean isHappy(int n) {
         Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // Cycle detected
            }
            seen.add(n);
            n = sumOfSquares(n);
        }
        return true; // Number is happy
    }

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
