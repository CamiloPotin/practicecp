/*
1497. Check If Array Pairs Are Divisible by k

Problema:
Se quiere saber si existe n/2 pares de numeros que sumados son divisibles por K

Solucion:
Se cuenta las frecuencias y dsps se va comparando por cada frecuencia si son divisibles
*/


class Solution {
    public boolean canArrange(int[] arr, int k) {
              HashMap<Integer, Integer> remainderCount = new HashMap<>();

        // Contar los restos
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;  // Asegurarse de que el resto sea positivo
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // Verificar las condiciones
        for (int r = 0; r < k; r++) {
            if (r == 0) {
                // Debe haber un número par de elementos con resto 0
                if (remainderCount.getOrDefault(r, 0) % 2 != 0) {
                    return false;
                }
            } else {
                // Debe haber un número par de elementos para resto r y k - r
                int countR = remainderCount.getOrDefault(r, 0);
                int countKMinusR = remainderCount.getOrDefault(k - r, 0);
                if (countR != countKMinusR) {
                    return false;
                }
            }
        }

        return true;
    }
}
