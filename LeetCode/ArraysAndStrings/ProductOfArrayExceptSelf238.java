package LeetCode.ArraysAndStrings;/*
Product of Array Except Self 238 de leetcode

Problema:
Se quiere calcular el producto de un arreglo y devolver un array del mismo tamaño pero en cada indice esta la multiplicacion del arreglo original 
sin el valor del mismo para ese indice.

Solucion:
Se calcula toda la multiplicacion de desde el princiio y tambien del final y dsps se recorre el arreglo calculando la multiplicacion de prefix*suffix de los valores




*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];    
    int[] prefix = new int[n];
    int[] suffix = new int[n]; 

    prefix[0] = 1;
    for (int i = 1; i < n; ++i)
      prefix[i] = prefix[i - 1] * nums[i - 1];

    suffix[n - 1] = 1;
    for (int i = n - 2; i >= 0; --i)
      suffix[i] = suffix[i + 1] * nums[i + 1];

    for (int i = 0; i < n; ++i)
      ans[i] = prefix[i] * suffix[i];

    return ans;
    }
}
