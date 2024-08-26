/*
Search Insert Position 35 de leetcode

Problema: 
Se quiere encontrar un valor en una lista ordenada y si no se encuentra devolver la posicion donde iria el mismo

Solucion:
Se usa binary search y si no se encuentra devuelve left

*/


class Solution {
    public int searchInsert(int[] nums, int target) {
         int left = 0;
      int right = nums.length-1;
      int mid=(right + left) / 2;
      while(left<=right){
           mid = (right + left) / 2;
           
            if(nums[mid]==target){
             
                return mid;

                }
            else if(nums[mid]<target)
                    left = mid+1;
                 else right = mid-1;
      }  
      return left;
    }
}
