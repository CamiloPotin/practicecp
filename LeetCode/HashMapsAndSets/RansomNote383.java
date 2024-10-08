package LeetCode.HashMapsAndSets;/*
Ransom Note 383 de leetcode

Problema:
Se tiene dos Strings y se quiere saber si se puede armar uno usando las letras del otro

Solucion:
Se guardan las letras del primero en un map y se recorre el otro actualizando el map.

OBS: Este caso es mas rapido usar un arreglo de letras ya que son mas rapidas las operaciones de busqueda para este caso.


*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
                 map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch : ransomNote.toCharArray()){
                 if (map.containsKey(ch)) {
                         int count = map.get(ch)-1;
                          map.put(ch, map.get(ch) -1 );
                         if(count<0) return false;
                 } else return false;
        }
    return true;

    }
}
