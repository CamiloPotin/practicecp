package LeetCode.TwoPointers;/*
Container With Most Water 11 de leetcode

Problema:
Se tiene un arreglo de alturas y se quiere calcular cual seria la mayor area de agua posible
(se calcula con la diferencia entre dos posiciones x multiplicado por la altura minima entre las dos y)

Solucion:
Se recorre usando un enfoque de dos punteros calculando el maximo para esas dos posiciones
dsps se compara con el maximoActual y por ultimo se mueve el puntero que tenga menor altura de los dos



*/



class Solution {
    public int maxArea(int[] height) {
        
        int maxArea=0;

        int left = 0;
        int right = height.length-1;
        while(left<right){
           int area = (right-left)*Math.min(height[left],height[right]);
           if(area>maxArea)
                maxArea=area;
            if(height[left]>height[right])
                right--;
            else left++;

        }
        return maxArea;

    }
}
