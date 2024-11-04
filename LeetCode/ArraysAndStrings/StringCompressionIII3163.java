/*
3163. String Compression III

Problema:
Se quiere comprimir un String siguiendo las siguientes reglas:
-Begin with an empty string comp. While word is not empty, use the following operation:
-Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
-Append the length of the prefix followed by c to comp.

Solucion:
Se va contando la frecuencia del caracter y si cambia o es 9 se agrega 
*/


class Solution {
    public String compressedString(String word) {
        
        int count = 1 ;
        char ch = word.charAt(0);
         char curr ='a';
        StringBuilder result = new StringBuilder();
        for(int i = 1 ; i < word.length();i++){
             curr = word.charAt(i);
            if(curr == ch && count < 9){
                count++;
            }else{
                result.append(count);
                result.append(ch);
                ch = curr;
                count = 1;

            }
        }
        result.append(count);
        result.append(ch);
        return result.toString();
    }
}
