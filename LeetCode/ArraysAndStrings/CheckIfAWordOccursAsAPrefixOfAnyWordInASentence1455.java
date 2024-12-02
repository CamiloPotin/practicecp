/*
1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

Problema:
Se quiere saber si un String es prefijo de alguna palabra dentro de una oración

Solucion:
Se divide la oracion en los Strings y se recorre comparando por cada una el prefijo


*/


class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for ( int i = 0 ;  i < words.length ; i++){
            int j = 0;
            while(j<searchWord.length() && 
                  j<words[i].length() &&
                  words[i].charAt(j)== searchWord.charAt(j)){
                  j++ ;
            }
            if(j==searchWord.length() ){
                return i+1;
            }
            j=0;
        }
    return -1;
    }
}
