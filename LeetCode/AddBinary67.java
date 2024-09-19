/*
67. Add Binary

Problema:
Se quiere hacer una suma binaria entre dos numero binarios representados por Strings

Soluion:
Se recorre desde el final ambos strings y se va sumando al resultado manteniendo un carry.
*/


class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Comenzamos con el carry
            
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convertimos el carácter a entero
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convertimos el carácter a entero
                j--;
            }
            
            carry = sum / 2; // Calculamos el nuevo carry
            result.append(sum % 2); // Agregamos el resultado de la suma en binario
        }
        
        return result.reverse().toString(); // Devolvemos el resultado invertido
    }
}
