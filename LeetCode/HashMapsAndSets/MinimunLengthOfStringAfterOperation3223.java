/*
3223. Minimum Length of String After Operations

Problema:
Se quiere calcular el tamaño final de un string luego de realizar eliminaciones de caracteres que:
Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
Delete the closest character to the left of index i that is equal to s[i].
Delete the closest character to the right of index i that is equal to s[i].

Solucion:
Se cuenta la frecuencia de los caracteres y los que tengan frecuencia>3 se suma eliminaciones
*/

class Solution {
    public int minimumLength(String s) {
        
    Map<Character,Integer> map = new HashMap<>();
    int count =  0;
    for(int i = 0 ; i < s.length() ; i++){
       char ch = s.charAt(i);
       map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        int currCount = entry.getValue();
        while(currCount>2){
            count+=2;
            //System.out.println(entry.getKey()+" "+count);
            currCount-=2;
            }
   
   }
    return s.length()-count;
    }
}
