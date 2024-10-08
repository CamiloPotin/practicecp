package LeetCode.BinarySearch;
/*
Valid Perfect Square 367 de leetcode

Problema:
Se quiere saber la raiz de un numero sin usar la funcion.

Solucion
Se usa binary search para encontrar el numero que multiplicado por si mismo da num
- Se debe tener en cuenta el desbordamiento por eso en vez de comparar (mid*mid) se hace mid == num/mid
al hacer esa comparacion tmb hay que tener en cuenta que mid no sea 0


*/




class Solution {
    public boolean isPerfectSquare(int num) {
        
    if (num == 0) {
        return true; // 0 es un cuadrado perfecto (0*0)
    }
      int left = 1;
      int right = num;
      
      while(left<=right){
            int mid = left + (right - left) / 2;
    
            // Evitamos overflow comparando usando división en lugar de multiplicación
            if (mid == num / mid && num % mid == 0) {
              //  System.out.println("asd");
                return true;

                }
            else if (mid < num / mid)
                    left = mid+1;
                 else right = mid-1;
      }  
      return false;
    }
}
