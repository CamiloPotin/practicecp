/*
2044. Count Number of Maximum Bitwise-OR Subsets

Problema:
Se quiere saber el numero de subset de un array que contienen el valor maximo posible de OR bitwise 


Solucion:
Se usa backtracking para recorrer el arreglo sumando cuando se llega al num maximo
*/




class Solution {
    private int max = 0;
    private int result = 0;
    public int countMaxOrSubsets(int[] nums) {
        max = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            max = max | nums[i];
        }
      //  System.out.println(max);
        backtrack(0,nums,0);
        return result;
    }


     private void backtrack(int sum, int[] nums, int start) {
        if(sum==max){
             result+=1;
        } 
        for (int i = start; i < nums.length; i++) {
            int aux = sum;
            sum = sum | nums[i]; // Incluye el elemento en el subconjunto actual
           // System.out.println(result+" "+sum+" "+nums+" "+i);
            backtrack(sum, nums, i + 1); // Llama recursivamente para el siguiente elemento
            sum = aux;
        }
    }   
}
