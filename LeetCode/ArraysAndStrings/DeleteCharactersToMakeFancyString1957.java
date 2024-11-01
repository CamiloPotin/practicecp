/*
1957. Delete Characters to Make Fancy String

Problema:
Se quiere hacer un String que no contenga tres caracteres seguidos

Solucion:
Se cuentan los caracteres y si es menos a 3 se agrga 
*/

class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);  
        result.append(prev);
        for(int i = 1 ; i < s.length(); i++){
              char ch = s.charAt(i);
             // System.out.println(prev+" "+ch);
              if(ch ==prev){
                 count++;
                 }else {
                    count=1;
                    prev = ch;
              }
              if(count<3){
                    result.append(ch);
                    //System.out.println(result);
                 } 
        }
        return result.toString();
    }
}
