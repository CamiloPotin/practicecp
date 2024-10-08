package LeetCode.HashMapsAndSets;

/*
Valid anagram 242 de leetcode

Problema:
Se quiere saber si un String es anagrama de otro;

Solucion:
Se cuenta la frecuencia de letras en 1 y se compara con el otro (se puede resolver usando hashMap pero creo que es mas lento)

*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int [] letters = new int[26];
        if(s.length() != t.length()) return false;
        for(int ch: s.toCharArray()){
            letters[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            //System.out.println(ch+" s "+letters[ch-'a']);
             if(--letters[ch-'a']<0){
                   
                   return false;

                   }
           // System.out.println(ch+" "+letters[ch-'a']);
        }
          return true;
    }
  
}
