/*
1963. Minimum Number of Swaps to Make the String Balanced

Problema:
Se tiene un arreglo de corchetes y se quiere saber cuantos swaps son necesarios para que sea equilibrado

Solucion:
Se lleva una cuenta del equilibrio y se devuelve la mitad

*/

class Solution {
    public int minSwaps(String s) {
         int imbalance = 0;
        int maxImbalance = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance--;  // Un corchete abierto disminuye el desequilibrio
            } else {
                imbalance++;  // Un corchete cerrado aumenta el desequilibrio
            }

            // Mantén el máximo desequilibrio observado
            maxImbalance = Math.max(maxImbalance, imbalance);
        }

        // El número de intercambios es la mitad del máximo desequilibrio
        return (maxImbalance + 1) / 2;
    }
}
