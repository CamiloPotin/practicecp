/*
189. Rotate Array

Problema:
Se quiere rotar un arreglo en k posiciones

Solucion:

chatgpt reveer


*/


class Solution {
    public void rotate(int[] nums, int k) {
           int n = nums.length;
        k = k % n; // Normalize k

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap the elements
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}