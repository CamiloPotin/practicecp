/*
2516. Take K of Each Character From Left and Right

Problema:
Se quiere saber cual es el minimo de eliminaciones que se deben hacer para conseguir al menos K
valores de 'a'  'b' y 'c' en un String de esos caracteres

Solucion:
Se usa una sliding window
*/


class Solution {
    public int takeCharacters(String s, int k) {
          // Step 1: Count occurrences of 'a', 'b', and 'c'
        int[] count = new int[3];  // count[0] = 'a', count[1] = 'b', count[2] = 'c'
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
    
        // If any character appears less than k times, return -1
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        // Step 2: Use a sliding window approach
        int n = s.length();
        int left = 0, right = 0;
        int[] currentCount = new int[3];  // currentCount for 'a', 'b', 'c'
        int result =0;
        
        // Try to find the minimum number of operations
        while (right < n) {
            // Take character at right end
            char c = s.charAt(right);
            currentCount[c-'a']++;
            
            // If we have at least k of each character, try to minimize the window
            while(
                 left <= right &&
                count[0] - currentCount[0] < k ||
                count[1] - currentCount[1] < k ||
                count[2] - currentCount[2] < k) {
            
                char leftChar = s.charAt(left);
                currentCount[leftChar-'a']--;
                left++;
            }
             result = Math.max(result, right - left + 1);
            right++;
        }
        
        // Return the result
        return n- result;
    }
}
