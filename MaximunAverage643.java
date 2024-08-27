/*
Maximun Average 643 Subarray de leetcode

Problema:
Se quiere saber cual es el maximo posible de un subarreglo de tamaño k del arreglo original

Solucion:
Se usa el enfoque de ventana deslizante, se calcula la primer suma y a partir de la mism
se va agregando desde k a la suma y se resta el de a un elemento a medida que se agrega 
y por ultimo se calcula el max.

*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
double sum = 0;
 
    for(int i = 0 ; i < k ; i++){
           // System.out.println(i+" "+sum);
            sum+= nums[i];

    
    }
    double max = sum/k;
    for(int i = k; i<nums.length; i++){
        sum = sum - nums[i-k] + nums[i];
        if(sum/k>max){
            max=sum/k;
        }
    }
    return max;
    }
}
