package LeetCode.ArraysAndStrings;/*
Summary Ranges 228 de leetcode

Problema:
Se tiene un array de numeros ordenado y se quiere devolver un array de String con todos los rangos de los numeros consecutivos.

Solucion:
Se recorre el array contando y si i es distinto del valor consecutivo esperado se agrega al arreglo final

*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            if (nums.length == 0) {
            return result;
            }

            int left = nums[0];
            int act = nums[0];
            int right = -1;

            for (int i = 1; i < nums.length; i++) {
                act++;
                if (nums[i] != act) {
                    right = nums[i - 1];
                //System.out.println("Se agrega " + i + " " + left + " " + right);
                if (left != right) {
                  result.add(left + "->" + right);
                } else {
                  result.add(String.valueOf(left));
                }
                left = nums[i];
                act = nums[i];
                }
            }

            right = nums[nums.length - 1];
            if (left != right) {
                result.add(left + "->" + right);
            } else {
                result.add(String.valueOf(left));
            }
            return result;
 
    }
}
