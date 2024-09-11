/*
2220. Minimum Bit Flips to Convert Number

Problema:
Se quiere saber cuantos flips hay que hacer para que un numero start sea igual a un numero goal en binario ambos

Solucion:
Se hace un xor entre ambos numeros y se cuetan los 1s resultantes
*/

class Solution {
    public int minBitFlips(int start, int goal) {
        String result = Integer.toBinaryString(start^goal);

        int count = 0;
        for(char ch : result.toCharArray()){
                if (ch == '1')
                    count++;

        }
        return count;

    }
}
