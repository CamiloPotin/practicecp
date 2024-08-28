package LeetCode.TwoPointers;/*
Trapping rain water 42 de leetcode

Problema:
Se tiene un arreglo de alturas de paredes
Y se quiere calcular cuanta agua acumulan entre ellas:


Solucion:
Se recorre primero el arreglo calculando los maximos desde izquieda a derecha
y de derecha a izquierda y se guardan en dos arreglos.
Luego se recorre una vez mas pero esta vez calculando el minimo entre los dos maximos en esa posicion
y dsps se resta a ese minimo la altura de la posicion i para saber la cantidad de agua en esa posicion.


*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        int lWall = 0, rWall = 0;
        
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            maxLeft[i] = lWall;
            maxRight[j] = rWall;
            lWall = Math.max(lWall, height[i]);
            rWall = Math.max(rWall, height[j]);
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int pot = Math.min(maxLeft[i], maxRight[i]);
            sum += Math.max(0, pot - height[i]);
        }
        
        return sum;

    }
}
