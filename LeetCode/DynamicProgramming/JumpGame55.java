/*
55. Jump Game

Problema:
Se quiere calcular si se puede llegar al indice final de un arreglo saltando una longitud maxima de a[i] 

Solucion:
Se usa un greedy algorithm donde se almacena el salto mas largo que se puede hacer

(chatgpt reveer)

*/



class Solution {
    public boolean canJump(int[] nums) {
          int farthest = 0;
    for (int i = 0; i < nums.length; i++) {
        if (i > farthest) {
            return false;
        }
        farthest = Math.max(farthest, i + nums[i]);
        if (farthest >= nums.length - 1) {
            return true;
        }
    }
    return false;
}
}
