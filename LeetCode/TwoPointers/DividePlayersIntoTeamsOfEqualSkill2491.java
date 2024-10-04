/*
2491. Divide Players Into Teams of Equal Skill

Problema:
Se quiere dividir un arreglo de skill en n/2 equipos de 2 con la misma suma de habilidad y devolver el total de quimica entre los equipos


Solucion:
Se ordena el arreglo y se suman las habilidades y si coinciden se suma al result y si no, no es posible armar el equipo

*/



class Solution {
    public long dividePlayers(int[] skill) {
       Arrays.sort(skill);
       int left = 0 ;
       int right = skill.length-1;
       int equal = skill[left] + skill[right];
       long result = 0;
       while(left<right){
        int even = skill[left] + skill[right];
        if(even == equal){
             result+= skill[left]*skill[right];
           //  System.out.println(skill[left]*skill[right]);
        } else {result = -1; break;}
        left++;
        right--;
       }

return result;

    }
}
