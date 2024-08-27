/*
Binary Search 704 de leetcode

Problema:
Se quiere implementar una busqueda binaria

Solucion:
Se implementa tal cual

*/


class Solution {
    public int search(int[] nums, int target) {

      int left = 0;
      int right = nums.length-1;
      
      while(left<=right){
            int mid = (right + left) / 2;
           // System.out.println(left+" "+mid+" "+right);
            if(nums[mid]==target){
              //  System.out.println("asd");
                return mid;

                }
            else if(nums[mid]<target)
                    left = mid+1;
                 else right = mid-1;
      }  
      return -1;
        
    }
}