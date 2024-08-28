package LeetCode.HashMapsAndSets;

/*
Jewels and Stones 771 de leetcode

Problema:
Se tiene un string jewels que contiene que letras son gemas y un String de piedras.
Se quiere saber cuantas de esas piedras son gemas.

Solucion:
Se guarda en un set las gemas y se consulta por cada piedra si es una gema.

*/
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
    Set<Character> jew = new HashSet<>();

    for(char ch : jewels.toCharArray()){
        jew.add(ch);
    }

    int count = 0;
    for(char ch : stones.toCharArray()){
        if(jew.contains(ch))
            count++;
    }
    return count;
    }
   
}
