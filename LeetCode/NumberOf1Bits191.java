/*
191. Number of 1 Bits

Problema:
Se quiere contar la cantidad de bits en 1 de un numero n

Solucion:
Se hace un and con 1 para saber si el bit menos significativo es 1 y dsps se rota a la derecha en 1

*/



class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Check if the least significant bit is 1
            n >>>= 1; // Right shift n by 1 (unsigned shift)
        }
        return count;
    }
}
