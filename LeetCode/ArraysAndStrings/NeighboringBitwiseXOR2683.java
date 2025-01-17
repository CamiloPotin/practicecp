/*
2683. Neighboring Bitwise XOR

Problema: 
Se tiene la derivada de un arreglo y se quiere saber si existe un arreglo valido para esa derivada
Cumple con lo siguiente:
Specifically, for each index i in the range [0, n - 1]:
If i = n - 1, then derived[i] = original[i] ⊕ original[0].
Otherwise, derived[i] = original[i] ⊕ original[i + 1].

Solucion:
Tiene que cumplir que hay pares de valores para que sea valido (lo saque de hints)
*/


class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sumXOR= derived[0];
        for(int i = 1 ; i < derived.length; i++){

            sumXOR^= derived[i];
        }

         return (sumXOR == 0) ? true : false;
    }
   
}
