/*
1684. Count the Number of Consistent Strings

Problema:
Se quiere saber cuantos strings permitidos contiene un arreglo, para ello, un String debe contener solo letras pertenecientes al String allowed

Solucion:
Se guarda en un Set las letras de allowed y se compara para cada String si cumple o no

*/


class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
     Set <Character> set = new HashSet<>();
     for (char ch : allowed.toCharArray())
            set.add(ch);
    
    int count = 0;
    for(String word  : words){
        boolean c = true;
        for(char ch : word.toCharArray()){
                if(!set.contains(ch)){
                    c = false;
                    break;
                }
        }
        if (c) count++;
    }
    return count;
}
}
