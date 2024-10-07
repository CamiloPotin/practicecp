/*
2696. Minimum String Length After Removing Substrings

Problema:
Se quiere saber la longitud minima de un String luego de remover todas las ocurrencias posibles de las subcadenas "AB" y "CD"

Soluion:
Se guarad el String en una stack y se va consultando si los ultimos dos son la cadena y en ese caso se eliminan de la stack
*/



class Solution {
    public int minLength(String s) {
          Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            
            // Comprobar si los últimos dos caracteres forman "AB" o "CD"
            if (stack.size() >= 2) {
                char secondLast = stack.get(stack.size() - 2);
                char last = stack.peek();
                
                // Si hay coincidencia, eliminar los dos caracteres
                if ((secondLast == 'A' && last == 'B') || (secondLast == 'C' && last == 'D')) {
                    stack.pop(); // Eliminar 'B' o 'D'
                    stack.pop(); // Eliminar 'A' o 'C'
                }
            }
        }

        return stack.size(); // Devolver la longitud de la pila
    
    }
}
