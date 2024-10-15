/*
2938. Separate Black and White Balls

Problema:
Se tiene un arreglo de Strings con 1s y 0s que representan pelotas blancas y negras
se quiere separar las pelotas negras a la derecha y blancas a la izquierda del arreglo y devolver 
el numero de swaps necesarios para el mismo.

Solucion:
Se recorre de derecha a izq y se va contando los 0s encontrados y cuando se encuentra un 1 se suma el count al resultado final
*/

class Solution {
    public long minimumSteps(String s) {
        
        long count=0,result=0;
        for(int i = s.length()-1; i>=0 ; i--){
            char ch = s.charAt(i);
            if(ch== '0'){
                count++;
            } else result+=count;

        }
        //System.out.println(count+" "+result);
        return  result;
    }
}
